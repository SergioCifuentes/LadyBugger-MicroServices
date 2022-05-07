/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package com.ladybugger.devservice.service;

import com.ladybugger.devservice.exception.LogicalError;
import com.ladybugger.devservice.model.Employee;
import com.ladybugger.devservice.model.PhaseAssignment;
import com.ladybugger.devservice.payload.request.SubmissionRequest;
import com.ladybugger.devservice.repository.EmployeeRepository;
import com.ladybugger.devservice.repository.PhaseAssignmentRepository;
import com.ladybugger.devservice.repository.SubmissionRepository;
import java.sql.Date;
import java.time.LocalDate;
import java.util.Optional;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

/**
 *
 * @author mario
 */
public class SubmissionServiceTest {
    
    @Mock
    private EmployeeRepository employeeRepository;
    @Mock
    private PhaseAssignmentRepository phaseAssignmentRepository;
    @Mock
    private SubmissionRepository submissionRepository;
    @InjectMocks
    private SubmissionService subService;
    
    public SubmissionServiceTest() {
    }
    
    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    /**
     * Test of createSubmission method, of class SubmissionService.
     */
    @Test
    public void testCreateSubmission() {
        System.out.println("createSubmission");
        Long userId = 1l;
        SubmissionRequest submissionRequest = getSubmissionRequest();
        submissionRequest.setPhaseAssignmentId(2);
        Employee emp = new Employee();
        emp.setId(userId);
        Optional<Employee> optEmp = Optional.of(emp);
        Mockito.when(employeeRepository.findById(userId)).thenReturn(optEmp);
        PhaseAssignment phaAssig = new PhaseAssignment();
        phaAssig.setDev(emp);
        Optional<PhaseAssignment> optPha = Optional.of(phaAssig);
        Mockito.when(phaseAssignmentRepository.findById((long) submissionRequest.getPhaseAssignmentId())).thenReturn(optPha);
        String expResult = "{\"id\": \"" + null + "\"}";
        String result = subService.createSubmission(userId, submissionRequest);
        assertEquals(expResult, result);
    }
    
    /**
     * Test of createSubmission method, of class SubmissionService.
     */
    @Test
    public void testCreateSubmissionAndIsNotSameDev() {
        System.out.println("createSubmission");
        Long userId = 1l;
        SubmissionRequest submissionRequest = getSubmissionRequest();
        submissionRequest.setPhaseAssignmentId(2);
        Employee emp = new Employee();
        emp.setId(userId);
        Optional<Employee> optEmp = Optional.of(emp);
        Mockito.when(employeeRepository.findById(userId)).thenReturn(optEmp);
        PhaseAssignment phaAssig = new PhaseAssignment();
        Employee phaEmp = new Employee();
        phaEmp.setId(2l);
        phaAssig.setDev(phaEmp);
        Optional<PhaseAssignment> optPha = Optional.of(phaAssig);
        Mockito.when(phaseAssignmentRepository.findById((long) submissionRequest.getPhaseAssignmentId())).thenReturn(optPha);
        LogicalError assertThrows = assertThrows(LogicalError.class, () -> {
            subService.createSubmission(userId, submissionRequest);
        });
        assertEquals("Error: You are not the developer of this phase", assertThrows.getMessage());
    }
    
    private SubmissionRequest getSubmissionRequest() {
        SubmissionRequest sub = new SubmissionRequest();
        sub.setComment("comment");
        sub.setCost(1f);
        sub.setDate(Date.valueOf(LocalDate.now()));
        sub.setHours(1);
        sub.setPhaseAssignmentId(1);
        return sub;
    }
    
}
