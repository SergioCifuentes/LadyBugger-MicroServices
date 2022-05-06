/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package com.ladybugger.managerservice.service;

import com.ladybugger.managerservice.model.Case;
import com.ladybugger.managerservice.model.CaseType;
import com.ladybugger.managerservice.model.Employee;
import com.ladybugger.managerservice.model.PMAssignment;
import com.ladybugger.managerservice.model.Project;
import com.ladybugger.managerservice.payload.request.CaseCreationRequest;
import com.ladybugger.managerservice.repository.CaseRepository;
import com.ladybugger.managerservice.repository.CaseTypeRepository;
import com.ladybugger.managerservice.repository.EmployeeRepository;
import com.ladybugger.managerservice.repository.PMAssignmentRepository;
import com.ladybugger.managerservice.repository.ProjectRepository;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.Optional;
import static org.junit.jupiter.api.Assertions.*;
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
public class CaseTypeServiceTest {

    @Mock
    private CaseTypeRepository caseTypeRepository;
    @Mock
    private CaseRepository caseRepository;
    @Mock
    private EmployeeRepository employeeRepository;
    @Mock
    private ProjectRepository projectRepository;
    @Mock
    private PMAssignmentRepository pmaRepository;
    @InjectMocks
    private CaseTypeService caseTypeService;

    public CaseTypeServiceTest() {
    }

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    /**
     * Test of registerCaseType method, of class CaseTypeService.
     */
    @Test
    public void testNotRegisterCaseType() {
        System.out.println("registerCaseType");
        Long userId = 1l;
        CaseCreationRequest caseRequest = new CaseCreationRequest();
        caseRequest.setProjectId(1);
        Employee emp = new Employee();
        emp.setId(userId);
        Optional<Employee> opemp = Optional.of(emp);
        Mockito.when(employeeRepository.findById(userId)).thenReturn(opemp);
        Project pr = new Project();
        pr.setId(2l);
        Optional<Project> oppr = Optional.of(pr);
        Mockito.when(projectRepository.findById((long) caseRequest.getProjectId())).thenReturn(oppr);
        PMAssignment pma = new PMAssignment();
        Employee emp2 = new Employee();
        emp2.setId(2l);
        pma.setEmployee(emp2);
        Mockito.when(pmaRepository.findLastManager(pr.getId())).thenReturn(pma);
        String expResult = "Error: You are not the project Manager";
        String result = caseTypeService.registerCaseType(userId, caseRequest);
        assertEquals(expResult, result);
    }
    
    /**
     * Test of registerCaseType method, of class CaseTypeService.
     */
    @Test
    public void testRegisterCaseType() {
        System.out.println("registerCaseType");
        Long userId = 2l;
        CaseCreationRequest caseRequest = new CaseCreationRequest();
        caseRequest.setProjectId(1);
        Employee emp = new Employee();
        emp.setId(userId);
        Optional<Employee> opemp = Optional.of(emp);
        Mockito.when(employeeRepository.findById(userId)).thenReturn(opemp);
        Project pr = new Project();
        pr.setId(2l);
        Optional<Project> oppr = Optional.of(pr);
        Mockito.when(projectRepository.findById((long) caseRequest.getProjectId())).thenReturn(oppr);
        PMAssignment pma = new PMAssignment();
        Employee emp2 = new Employee();
        emp2.setId(2l);
        pma.setEmployee(emp2);
        Mockito.when(pmaRepository.findLastManager(pr.getId())).thenReturn(pma);
        CaseType caset = new CaseType();
        Optional<CaseType> caseo = Optional.of(caset);
        Mockito.when(caseTypeRepository.findById((long) caseRequest.getCaseTypeId())).thenReturn(caseo);
        Case newCase = new Case();
        Mockito.when(caseRepository.save(newCase)).thenReturn(newCase);
        String expResult = "{\"id\": \"" + newCase.getId() + "\"}";
        String result = caseTypeService.registerCaseType(userId, caseRequest);
        assertEquals(expResult, result);
    }

}
