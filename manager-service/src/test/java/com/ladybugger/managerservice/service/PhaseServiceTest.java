/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package com.ladybugger.managerservice.service;

import com.ladybugger.managerservice.exceptions.LogicalError;
import com.ladybugger.managerservice.model.Case;
import com.ladybugger.managerservice.model.CaseType;
import com.ladybugger.managerservice.model.Employee;
import com.ladybugger.managerservice.model.Phase;
import com.ladybugger.managerservice.model.PhaseAssignment;
import com.ladybugger.managerservice.payload.response.ListPhasesView;
import com.ladybugger.managerservice.payload.response.PhaseView;
import com.ladybugger.managerservice.repository.CaseRepository;
import com.ladybugger.managerservice.repository.EmployeeRepository;
import com.ladybugger.managerservice.repository.PhaseAssignmentRepository;
import com.ladybugger.managerservice.repository.PhaseRepository;
import java.sql.Date;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Set;
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
public class PhaseServiceTest {

    @Mock
    private CaseRepository caseRepository;
    @Mock
    private PhaseAssignmentRepository phaseAssignmentRepository;
    @Mock
    private EmployeeRepository employeeRepository;
    @Mock
    private PhaseRepository phaseRepository;
    @InjectMocks
    private PhaseService phaseService;
    
    public PhaseServiceTest() {
    }
    
    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    /**
     * Test of getPhase method, of class PhaseService.
     */
    @Test
    public void testGetPhase() {
        System.out.println("getPhase");
        String projectId = "1";
        Case casem = new Case();
        CaseType caset = new CaseType();
        caset.setPhases(Set.of(new Phase("name", 0, new CaseType())));
        casem.setCasetype(caset);
        Optional<Case> optCase = Optional.of(casem);
        Mockito.when(caseRepository.findById(Mockito.anyLong())).thenReturn(optCase);
        Mockito.when(phaseAssignmentRepository.findDev(Mockito.anyLong(), Mockito.anyLong())).thenReturn(null);
        ListPhasesView result = phaseService.getPhase(projectId);
        assertNotNull(result);
    }

    /**
     * Test of getPhase method, of class PhaseService.
     */
    @Test
    public void testGetPhaseWhenIdIsNotLong() {
        System.out.println("getPhase");
        String projectId = "error";
        LogicalError error = assertThrows(LogicalError.class, ()-> {
            phaseService.getPhase(projectId);
        });
        assertEquals("Wrong id", error.getMessage());
    }

    /**
     * Test of getPv method, of class PhaseService.
     */
    @Test
    public void testGetPv() {
        System.out.println("getPv");
        Employee emp = new Employee();
        PhaseAssignment pa = new PhaseAssignment(emp, null, null, null, 0, Date.valueOf(LocalDate.now()), Date.valueOf(LocalDate.now()));
        Phase phase = new Phase();
        phase.setNumber(1);
        PhaseView result = phaseService.getPv(pa, phase);
        assertNotNull(result);
    }

    /**
     * Test of getPv method, of class PhaseService.
     */
    @Test
    public void testGetPvWhenPhaseAssignmentIsNull() {
        System.out.println("getPv");
        Phase phase = new Phase();
        phase.setNumber(1);
        phase.setId(1l);
        PhaseView result = phaseService.getPv(null, phase);
        assertNotNull(result);
    }

    /**
     * Test of addToList method, of class PhaseService.
     */
    @Test
    public void testAddToListProcess() {
        System.out.println("addToList");
        List<PhaseView> list = new ArrayList<>();
        PhaseAssignment pa = new PhaseAssignment();
        pa.setStatus(1);
        PhaseView pv = new PhaseView(1l, "dev", 1l, 0, 0, "10-10-2022", "10-10-2022");
        assertTrue(phaseService.addToList(list, null, null, null, pa, pv));
    }

    /**
     * Test of addToList method, of class PhaseService.
     */
    @Test
    public void testAddToListToDo() {
        System.out.println("addToList");
        List<PhaseView> list = new ArrayList<>();
        PhaseAssignment pa = new PhaseAssignment();
        pa.setStatus(0);
        PhaseView pv = new PhaseView(1l, "dev", 1l, 0, 0, "10-10-2022", "10-10-2022");
        assertTrue(phaseService.addToList(null, null, null, list, pa, pv));
    }

    /**
     * Test of addToList method, of class PhaseService.
     */
    @Test
    public void testAddToListFinished() {
        System.out.println("addToList");
        List<PhaseView> list = new ArrayList<>();
        PhaseAssignment pa = new PhaseAssignment();
        pa.setStatus(2);
        PhaseView pv = new PhaseView(1l, "dev", 1l, 0, 0, "10-10-2022", "10-10-2022");
        assertTrue(phaseService.addToList(null, null, list, null, pa, pv));
    }

    /**
     * Test of addToList method, of class PhaseService.
     */
    @Test
    public void testAddToListCanceled() {
        System.out.println("addToList");
        List<PhaseView> list = new ArrayList<>();
        PhaseAssignment pa = new PhaseAssignment();
        pa.setStatus(3);
        PhaseView pv = new PhaseView(1l, "dev", 1l, 0, 0, "10-10-2022", "10-10-2022");
        assertTrue(phaseService.addToList(null, list, null, null, pa, pv));
    }
    
    /**
     * Test of addToList method, of class PhaseService.
     */
    @Test
    public void testAddToAnyList() {
        System.out.println("addToList");
        PhaseAssignment pa = new PhaseAssignment();
        pa.setStatus(10);
        PhaseView pv = new PhaseView(1l, "dev", 1l, 0, 0, "10-10-2022", "10-10-2022");
        assertFalse(phaseService.addToList(null, null, null, null, pa, pv));
    }
    
}
