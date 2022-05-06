/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package com.ladybugger.managerservice.service;

import com.ladybugger.managerservice.model.Case;
import com.ladybugger.managerservice.model.Employee;
import com.ladybugger.managerservice.model.PMAssignment;
import com.ladybugger.managerservice.model.Phase;
import com.ladybugger.managerservice.model.PhaseAssignment;
import com.ladybugger.managerservice.model.Project;
import com.ladybugger.managerservice.payload.request.PhaseAssignmentRequest;
import com.ladybugger.managerservice.repository.CaseRepository;
import com.ladybugger.managerservice.repository.EmployeeRepository;
import com.ladybugger.managerservice.repository.PMAssignmentRepository;
import com.ladybugger.managerservice.repository.PhaseAssignmentRepository;
import com.ladybugger.managerservice.repository.PhaseRepository;
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
public class PhaseAssignmentServiceTest {
    
    @Mock
    PhaseRepository phaseRepository;
    @Mock
    CaseRepository caseRepository;
    @Mock
    PMAssignmentRepository pmaRepository;
    @Mock
    EmployeeRepository employeeRepository;
    @Mock
    PhaseAssignmentRepository phaseAssignmentRepository;
    @InjectMocks
    PhaseAssignmentService phaseAsService;
    
    public PhaseAssignmentServiceTest() {
    }
    
    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    /**
     * Test of assignPhase method, of class PhaseAssignmentService.
     */
    @Test
    public void testAssignPhase() {
        System.out.println("assignPhase");
        Long userId = 1l;
        PhaseAssignmentRequest assignmentRequest = new PhaseAssignmentRequest();
        assignmentRequest.setPhaseId(1);
        assignmentRequest.setCaseId(1);
        assignmentRequest.setDevId(1);
        Employee emp = new Employee();
        emp.setId(1l);
        Optional<Employee> opEmp = Optional.of(emp);
        Mockito.when(employeeRepository.findById(userId)).thenReturn(opEmp);
        Phase pha = new Phase();
        Optional<Phase> opPha = Optional.of(pha);
        Mockito.when(phaseRepository.findById((long) assignmentRequest.getPhaseId())).thenReturn(opPha);
        Case cas = new Case();
        Project pr = new Project();
        pr.setId(1l);
        cas.setProject(pr);
        Optional<Case> opCas = Optional.of(cas);
        Mockito.when(caseRepository.findById((long) assignmentRequest.getCaseId())).thenReturn(opCas);
        PMAssignment pma = new PMAssignment();
        pma.setEmployee(emp);
        Mockito.when(pmaRepository.findLastManager(cas.getProject().getId())).thenReturn(pma);
        PhaseAssignment phAss = new PhaseAssignment();
        Employee dev = new Employee();
        Optional<Employee> opDev = Optional.of(emp);
        Mockito.when(employeeRepository.findById((long) assignmentRequest.getDevId())).thenReturn(opDev);
        Mockito.when(phaseAssignmentRepository.save(phAss)).thenReturn(null);
        String expResult = "{\"id\": \"" +phAss.getId() + "\"}";
        String result = phaseAsService.assignPhase(userId, assignmentRequest);
        assertEquals(expResult, result);
    }

    /**
     * Test of assignPhase method, of class PhaseAssignmentService.
     */
    @Test
    public void testNotAssignPhase() {
        System.out.println("assignPhase");
        Long userId = 1l;
        PhaseAssignmentRequest assignmentRequest = new PhaseAssignmentRequest();
        assignmentRequest.setPhaseId(1);
        assignmentRequest.setCaseId(1);
        assignmentRequest.setDevId(1);
        Employee emp = new Employee();
        emp.setId(1l);
        Optional<Employee> opEmp = Optional.of(emp);
        Mockito.when(employeeRepository.findById(userId)).thenReturn(opEmp);
        Phase pha = new Phase();
        Optional<Phase> opPha = Optional.of(pha);
        Mockito.when(phaseRepository.findById((long) assignmentRequest.getPhaseId())).thenReturn(opPha);
        Case cas = new Case();
        Project pr = new Project();
        pr.setId(1l);
        cas.setProject(pr);
        Optional<Case> opCas = Optional.of(cas);
        Mockito.when(caseRepository.findById((long) assignmentRequest.getCaseId())).thenReturn(opCas);
        PMAssignment pma = new PMAssignment();
        Employee dif = new Employee();
        dif.setId(2l);
        pma.setEmployee(dif);
        Mockito.when(pmaRepository.findLastManager(cas.getProject().getId())).thenReturn(pma);
        String expResult = "Error: You are not the project manager";
        String result = phaseAsService.assignPhase(userId, assignmentRequest);
        assertEquals(expResult, result);
    }
    
}
