/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package com.ladybugger.adminservice.service;

import com.ladybugger.adminservice.model.Case;
import com.ladybugger.adminservice.model.Employee;
import com.ladybugger.adminservice.model.PMAssignment;
import com.ladybugger.adminservice.model.Project;
import com.ladybugger.adminservice.payload.response.ProjectCases;
import com.ladybugger.adminservice.repository.PMAssignmentRepository;
import com.ladybugger.adminservice.repository.ProjectRepository;
import java.sql.Date;
import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Set;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;

/**
 *
 * @author mario
 */
public class ProjectServiceTest {
    
    @Mock
    private PMAssignmentRepository pmaRepository;
    
    @Mock
    private ProjectRepository projectRepository;
    
    @InjectMocks
    private ProjectService projectService;
    
    public ProjectServiceTest() {
    }

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    /**
     * Test of getProjectsPageable method, of class ProjectService.
     */
    @Test
    public void testGetProjectsPageable() {
        System.out.println("getProjectsPageable");
        Pageable pageable = Pageable.ofSize(5);
        Employee emp = new Employee("email", "pass", "name", "middle", "last", Date.valueOf(LocalDate.now()), 0);
        Project pro = new Project("name", "desc", 0, Date.valueOf(LocalDate.now()), Date.valueOf(LocalDate.now()), emp);
        pro.setCases(Set.of(new Case()));
        List<Project> employees = List.of(pro);
        Page<Project> pr = new PageImpl(employees, pageable, employees.size());
        Mockito.when(projectRepository.findAll(pageable)).thenReturn(pr);
        PMAssignment assig = new PMAssignment(emp, pro, Timestamp.valueOf(LocalDateTime.now()));
        Mockito.when(pmaRepository.findLastManager(pro.getId())).thenReturn(assig);
        List<ProjectCases> expResult = List.of(Mockito.mock(ProjectCases.class));
        List<ProjectCases> result = projectService.getProjectsPageable(pageable);
        assertEquals(expResult.size(), result.size());
    }
    
}
