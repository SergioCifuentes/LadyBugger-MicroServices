/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package com.ladybugger.managerservice.service;

import com.ladybugger.managerservice.model.Employee;
import com.ladybugger.managerservice.model.Project;
import com.ladybugger.managerservice.payload.response.SimpleProject;
import com.ladybugger.managerservice.repository.EmployeeRepository;
import com.ladybugger.managerservice.repository.PMAssignmentRepository;
import com.ladybugger.managerservice.repository.ProjectRepository;
import java.sql.Date;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import static org.junit.Assert.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

/**
 *
 * @author mario
 */
public class ProjectServiceTest {
    
    @Mock
    private EmployeeRepository employeeRepository;
    @Mock
    private ProjectRepository projectRepository;
    @Mock
    private PMAssignmentRepository pmaRepository;
    @InjectMocks
    private ProjectService projectService;
    
    public ProjectServiceTest() {
    }
    
    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    /**
     * Test of getAssignedProject method, of class ProjectService.
     */
    @Test
    public void testGetAssignedProject() {
        System.out.println("getAssignedProject");
        Long userId = 1l;
        Employee emp = new Employee();
        emp.setId(1l);
        Optional<Employee> optEmp = Optional.of(emp);
        Mockito.when(employeeRepository.findById(userId)).thenReturn(optEmp);
        List<Long> longs = List.of(3l);
        Mockito.when(pmaRepository.findProjects(emp.getId())).thenReturn(longs);
        Project project = new Project("name", "desc", 0, Date.valueOf(LocalDate.now()), Date.valueOf(LocalDate.now()), emp);
        project.setId(3l);
        Optional<Project> op = Optional.of(project);
        Mockito.when(projectRepository.findById(project.getId())).thenReturn(op);
        List<SimpleProject> expResult = List.of(Mockito.mock(SimpleProject.class));
        List<SimpleProject> result = projectService.getAssignedProject(userId);
        assertEquals(expResult.size(), result.size());
    }
    
}
