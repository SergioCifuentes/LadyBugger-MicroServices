/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package com.ladybugger.adminservice.service;

import com.ladybugger.adminservice.model.Case;
import com.ladybugger.adminservice.model.Employee;
import com.ladybugger.adminservice.model.PMAssignment;
import com.ladybugger.adminservice.model.Project;
import com.ladybugger.adminservice.payload.request.PMAssignmentRequest;
import com.ladybugger.adminservice.payload.response.CaseResponse;
import com.ladybugger.adminservice.payload.response.EmployeeResponse;
import com.ladybugger.adminservice.repository.EmployeeRepository;
import com.ladybugger.adminservice.repository.PMAssignmentRepository;
import com.ladybugger.adminservice.repository.ProjectRepository;
import java.sql.Date;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
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
public class DevsServiceTest {
    
    public DevsServiceTest() {
    }
    
    @Mock
    EmployeeRepository employeeRepo;
    @Mock
    ProjectRepository projectRepo;
    @Mock
    PMAssignmentRepository PMAssignmentRepo;
    @InjectMocks
    DevsService devsService;
    
    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    /**
     * Test of getDevsByRole method, of class DevsService.
     */
    @Test
    public void testGetDevsByRole() {
        System.out.println("getDevsByRole");
        List expResult = new ArrayList();
        Mockito.when(employeeRepo.findByDevRole()).thenReturn(expResult);
        List result = devsService.getDevsByRole();
        assertEquals(expResult, result);
    }

    /**
     * Test of assignProject method, of class DevsService.
     */
    @Test
    public void testAssignProject() {
        System.out.println("assignProject");
        PMAssignmentRequest pmAssignmentRequest = new PMAssignmentRequest();
        Project project = new Project();
        Optional<Project> opt = Optional.of(project);
        Mockito.when(projectRepo.findById((long)pmAssignmentRequest.getProjectId())).thenReturn(opt);
        Employee employee = Mockito.mock(Employee.class);
        Optional<Employee> opt2 = Optional.of(employee);
        Mockito.when(employeeRepo.findById((long)pmAssignmentRequest.getEmployeeId())).thenReturn(opt2);
        PMAssignment pma = Mockito.mock(PMAssignment.class);
        Mockito.when(PMAssignmentRepo.save(pma)).thenReturn(null);
        String expResult = "Project Manager Asignado";
        String result = devsService.assignProject(pmAssignmentRequest);
        assertEquals(expResult, result);
    }

    /**
     * Test of getUsers method, of class DevsService.
     */
    @Test
    public void testGetUsers() {
        System.out.println("getUsers");
        Pageable pageable = Pageable.ofSize(5);
        Employee emp = new Employee("email", "pass", "name", "middle", "last", Date.valueOf(LocalDate.now()), 0);
        List<Employee> employees = List.of(emp);
        Page<Employee> pr = new PageImpl(employees, pageable, employees.size());
        Mockito.when(
                employeeRepo.findAll(pageable)
        ).thenReturn(pr);
        List<CaseResponse> casesre = List.of(Mockito.mock(CaseResponse.class));
        assertEquals(casesre.size(), devsService.getUsers(pageable).size());
    }
    
}
