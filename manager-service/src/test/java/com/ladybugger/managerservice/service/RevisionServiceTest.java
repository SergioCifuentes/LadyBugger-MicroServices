/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package com.ladybugger.managerservice.service;

import com.ladybugger.managerservice.exceptions.LogicalError;
import com.ladybugger.managerservice.model.Case;
import com.ladybugger.managerservice.model.Employee;
import com.ladybugger.managerservice.model.PMAssignment;
import com.ladybugger.managerservice.model.PhaseAssignment;
import com.ladybugger.managerservice.model.Project;
import com.ladybugger.managerservice.model.Revision;
import com.ladybugger.managerservice.model.Submission;
import com.ladybugger.managerservice.payload.request.RevisionCreationRequest;
import com.ladybugger.managerservice.repository.EmployeeRepository;
import com.ladybugger.managerservice.repository.PMAssignmentRepository;
import com.ladybugger.managerservice.repository.RevisionRepository;
import com.ladybugger.managerservice.repository.SubmissionRepository;
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
public class RevisionServiceTest {
    
    @Mock
    private EmployeeRepository employeeRepository;
    @Mock
    private PMAssignmentRepository pmaRepository;
    @Mock
    private SubmissionRepository submissionRepository;
    @Mock
    private RevisionRepository revisionRepository;
    @InjectMocks
    private RevisionService revisionService;
    
    public RevisionServiceTest() {
    }
    
    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    /**
     * Test of createRevision method, of class RevisionService.
     */
    @Test
    public void testCreateRevision() {
        System.out.println("createRevision");
        Long userId = 1l;
        RevisionCreationRequest revisionCreationRequest = new RevisionCreationRequest();
        Employee emp = new Employee();
        emp.setId(userId);
        Optional<Employee> optEmp = Optional.of(emp);
        Mockito.when(employeeRepository.findById(userId)).thenReturn(optEmp);
        Submission sub = new Submission();
        PhaseAssignment pa = new PhaseAssignment();
        Case ca = new Case();
        pa.setCaseM(ca);
        ca.setProject(new Project());
        sub.setPhaseAssignment(pa);
        Optional<Submission> optSub = Optional.of(sub);
        Mockito.when(submissionRepository.findById((long) revisionCreationRequest.getSubmissionId())).thenReturn(optSub);
        PMAssignment pma = new PMAssignment();
        pma.setEmployee(emp);
        Mockito.when(pmaRepository.findLastManager(sub.getPhaseAssignment().getCaseM().getProject().getId())).thenReturn(pma);
        Mockito.when(revisionRepository.save(Mockito.any(Revision.class))).thenReturn(null);
        String expResult = "{\"id\": \"" + null + "\"}";
        String result = revisionService.createRevision(userId, revisionCreationRequest);
        assertEquals(expResult, result);
    }

    /**
     * Test of createRevision method, of class RevisionService.
     */
    @Test
    public void testCreateRevisionAndIsNotPM() {
        System.out.println("createRevision");
        Long userId = 1l;
        RevisionCreationRequest revisionCreationRequest = new RevisionCreationRequest();
        Employee emp = new Employee();
        emp.setId(userId);
        Optional<Employee> optEmp = Optional.of(emp);
        Mockito.when(employeeRepository.findById(userId)).thenReturn(optEmp);
        Submission sub = new Submission();
        PhaseAssignment pa = new PhaseAssignment();
        Case ca = new Case();
        pa.setCaseM(ca);
        ca.setProject(new Project());
        sub.setPhaseAssignment(pa);
        Optional<Submission> optSub = Optional.of(sub);
        Mockito.when(submissionRepository.findById((long) revisionCreationRequest.getSubmissionId())).thenReturn(optSub);
        PMAssignment pma = new PMAssignment();
        Employee pmaDev = new Employee();
        pmaDev.setId(2l);
        pma.setEmployee(pmaDev);
        Mockito.when(pmaRepository.findLastManager(sub.getPhaseAssignment().getCaseM().getProject().getId())).thenReturn(pma);
        LogicalError error = assertThrows(LogicalError.class, () -> {
            revisionService.createRevision(userId, revisionCreationRequest);
        });
        assertEquals("You are not the Project's Manager", error.getMessage());
    }
    
}
