/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package com.ladybugger.adminservice.service;

import com.ladybugger.adminservice.model.Case;
import com.ladybugger.adminservice.model.Employee;
import com.ladybugger.adminservice.model.PMAssignment;
import com.ladybugger.adminservice.model.Project;
import com.ladybugger.adminservice.payload.request.ProjectCreationRequest;
import com.ladybugger.adminservice.payload.response.ProjectCases;
import com.ladybugger.adminservice.repository.EmployeeRepository;
import com.ladybugger.adminservice.repository.PMAssignmentRepository;
import com.ladybugger.adminservice.repository.ProjectRepository;
import java.sql.Date;
import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import org.junit.jupiter.api.BeforeEach;
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
    
    @Mock
    private EmployeeRepository employeeRepository;
    
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
    
    @Test
    public void testRegisterProject() {
        System.out.println("registerProject");
        Long userId = 1l;
        ProjectCreationRequest projectCreationRequest = createPojectRequest();
        Optional<Employee> empOpt = Optional.of(new Employee());
        Mockito.when(employeeRepository.findById(userId)).thenReturn(empOpt);
        Optional<Employee> empOpt2 = Optional.of(new Employee());
        Mockito.when(employeeRepository.findById((long) projectCreationRequest.getPmId())).thenReturn(empOpt2);
        Mockito.when(projectRepository.save(Mockito.any(Project.class))).thenReturn(null);
        Mockito.when(pmaRepository.save(Mockito.any(PMAssignment.class))).thenReturn(null);
        String expected = "{\"id\": \"" + null + "\"}";
        String result = projectService.registerProject(userId, projectCreationRequest);
        assertEquals(expected, result);
    }
    
    private ProjectCreationRequest createPojectRequest() {
        ProjectCreationRequest projectCreationRequest = new ProjectCreationRequest();
        projectCreationRequest.setDescription("desc");
        projectCreationRequest.setDueDate(Date.valueOf(LocalDate.now()));
        projectCreationRequest.setName("name");
        projectCreationRequest.setPmId(1);
        projectCreationRequest.setStartDate(Date.valueOf(LocalDate.now()));
        return projectCreationRequest;
    }
    
}
