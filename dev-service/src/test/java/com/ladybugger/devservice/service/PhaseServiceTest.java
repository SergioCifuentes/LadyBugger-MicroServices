/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package com.ladybugger.devservice.service;

import com.ladybugger.devservice.exception.LogicalError;
import com.ladybugger.devservice.model.Case;
import com.ladybugger.devservice.model.CaseType;
import com.ladybugger.devservice.model.Employee;
import com.ladybugger.devservice.model.PMAssignment;
import com.ladybugger.devservice.model.Phase;
import com.ladybugger.devservice.model.PhaseAssignment;
import com.ladybugger.devservice.model.Project;
import com.ladybugger.devservice.payload.response.PhaseDevResponse;
import com.ladybugger.devservice.payload.response.PhaseResponse;
import com.ladybugger.devservice.repository.EmployeeRepository;
import com.ladybugger.devservice.repository.PMAssignmentRepository;
import com.ladybugger.devservice.repository.PhaseAssignmentRepository;
import java.lang.reflect.Executable;
import java.sql.Date;
import java.time.LocalDate;
import java.util.List;
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
public class PhaseServiceTest {

    @Mock
    PhaseAssignmentRepository phaseAssignmentRepository;
    @Mock
    EmployeeRepository employeeRepository;
    @Mock
    PMAssignmentRepository pmaRepository;
    @InjectMocks
    PhaseService phaseService;

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
        Long userId = 1l;
        String projectId = "1";
        Employee emp = new Employee();
        emp.setId(userId);
        Optional<Employee> optEmp = Optional.of(emp);
        Mockito.when(employeeRepository.findById(userId)).thenReturn(optEmp);
        PhaseAssignment phAssi = new PhaseAssignment(emp,
                new Phase("name", 0, new CaseType()),
                new Case(projectId, projectId, new CaseType(), 0, new Project(), Date.valueOf(LocalDate.now()), Date.valueOf(LocalDate.now()), 0),
                projectId, 0, Date.valueOf(LocalDate.now()), Date.valueOf(LocalDate.now()));
        phAssi.setDev(emp);
        Optional<PhaseAssignment> optPh = Optional.of(phAssi);
        Mockito.when(phaseAssignmentRepository.findById(Mockito.anyLong())).thenReturn(optPh);
        PhaseResponse result = phaseService.getPhase(userId, projectId);
        assertEquals(PhaseResponse.class, result.getClass());
    }

    /**
     * Test of getPhase method, of class PhaseService.
     */
    @Test
    public void testGetPhaseAndIsNotDeveloper() {
        System.out.println("getPhase");
        Long userId = 1l;
        String projectId = "1";
        Employee emp = new Employee();
        emp.setId(userId);
        Optional<Employee> optEmp = Optional.of(emp);
        Mockito.when(employeeRepository.findById(userId)).thenReturn(optEmp);
        Employee newe = new Employee();
        newe.setId(4l);
        PhaseAssignment phAssi = new PhaseAssignment(newe,
                new Phase("name", 0, new CaseType()),
                new Case(projectId, projectId, new CaseType(), 0, new Project(), Date.valueOf(LocalDate.now()), Date.valueOf(LocalDate.now()), 0),
                projectId, 0, Date.valueOf(LocalDate.now()), Date.valueOf(LocalDate.now()));
        Optional<PhaseAssignment> optPh = Optional.of(phAssi);
        Mockito.when(phaseAssignmentRepository.findById(Mockito.anyLong())).thenReturn(optPh);
        LogicalError assertThrows = assertThrows(LogicalError.class, () -> {
            phaseService.getPhase(userId, projectId);
        });
        assertEquals("Error: You are not the developer of this phase", assertThrows.getMessage());
    }

    /**
     * Test of getPhase method, of class PhaseService.
     */
    @Test
    public void testGetPhaseAndIdIsNotLong() {
        System.out.println("getPhase");
        Long userId = 1l;
        String projectId = "error";
        Employee emp = new Employee();
        emp.setId(userId);
        Optional<Employee> optEmp = Optional.of(emp);
        Mockito.when(employeeRepository.findById(userId)).thenReturn(optEmp);
        LogicalError assertThrows = assertThrows(LogicalError.class, () -> {
            phaseService.getPhase(userId, projectId);
        });
        assertEquals("Wrong id", assertThrows.getMessage());
    }

    /**
     * Test of getPhases method, of class PhaseService.
     */
    @Test
    public void testGetPhases() {
        System.out.println("getPhases");
        Long userId = 1l;
        Employee emp = new Employee();
        emp.setId(1l);
        emp.setName("name");
        emp.setLastName("last");
        Optional<Employee> optEmp = Optional.of(emp);
        Mockito.when(employeeRepository.findById(userId)).thenReturn(optEmp);
        List<PhaseAssignment> phaseAssignments = List.of(createPhaseAssignment(), createPhaseAssignment());
        Mockito.when(phaseAssignmentRepository.findPhasesByDev(emp.getId())).thenReturn(phaseAssignments);
        List<PhaseDevResponse> result = phaseService.getPhases(userId);
        assertEquals(phaseAssignments.size(), result.size());
    }

    private PhaseAssignment createPhaseAssignment() {
        return new PhaseAssignment(new Employee(), new Phase(),
                new Case("name", "desc", new CaseType(), 0, new Project(), null, null, 0),
                "desc", 0, Date.valueOf(LocalDate.now()), Date.valueOf(LocalDate.now()));
    }

    /**
     * Test of getPhaseJob method, of class PhaseService.
     */
    @Test
    public void testGetPhaseJobPhaseIdDoesntParse() {
        System.out.println("getPhaseJob");
        Long userId = 1l;
        String phase_id = "error";
        Employee emp = new Employee();
        emp.setId(userId);
        Optional<Employee> optEmp = Optional.of(emp);
        Mockito.when(employeeRepository.findById(userId)).thenReturn(optEmp);
        String expected = "Wrong id";
        String result = phaseService.getPhaseJob(userId, phase_id);
        assertEquals(expected, result);
    }

    /**
     * Test of getPhaseJob method, of class PhaseService.
     */
    @Test
    public void testGetPhaseJobAndIsPM() {
        System.out.println("getPhaseJob");
        Long userId = 1l;
        String phase_id = "1";
        Employee emp = new Employee();
        emp.setId(userId);
        Optional<Employee> optEmp = Optional.of(emp);
        Mockito.when(employeeRepository.findById(userId)).thenReturn(optEmp);
        PhaseAssignment phAssig = new PhaseAssignment();
        Case casem = new Case();
        casem.setProject(new Project());
        phAssig.setCaseM(casem);
        Optional<PhaseAssignment> optPhase = Optional.of(phAssig);
        Mockito.when(phaseAssignmentRepository.findById(Mockito.anyLong())).thenReturn(optPhase);
        PMAssignment pma = new PMAssignment();
        pma.setEmployee(emp);
        Mockito.when(pmaRepository.findLastManager(phAssig.getCaseM().getProject().getId())).thenReturn(pma);
        String expected = "PM";
        String result = phaseService.getPhaseJob(userId, phase_id);
        assertEquals(expected, result);
    }

    /**
     * Test of getPhaseJob method, of class PhaseService.
     */
    @Test
    public void testGetPhaseJobAndIsDev() {
        System.out.println("getPhaseJob");
        Long userId = 1l;
        String phase_id = "1";
        Employee emp = new Employee();
        emp.setId(userId);
        Optional<Employee> optEmp = Optional.of(emp);
        Mockito.when(employeeRepository.findById(userId)).thenReturn(optEmp);
        PhaseAssignment phAssig = new PhaseAssignment();
        Case casem = new Case();
        casem.setProject(new Project());
        phAssig.setCaseM(casem);
        phAssig.setDev(emp);
        Optional<PhaseAssignment> optPhase = Optional.of(phAssig);
        Mockito.when(phaseAssignmentRepository.findById(Mockito.anyLong())).thenReturn(optPhase);
        PMAssignment pma = new PMAssignment();
        Employee newe = new Employee();
        newe.setId(3l);
        pma.setEmployee(newe);
        Mockito.when(pmaRepository.findLastManager(phAssig.getCaseM().getProject().getId())).thenReturn(pma);
        String expected = "DEV";
        String result = phaseService.getPhaseJob(userId, phase_id);
        assertEquals(expected, result);
    }

    /**
     * Test of getPhaseJob method, of class PhaseService.
     */
    @Test
    public void testGetPhaseJobAndIsNone() {
        System.out.println("getPhaseJob");
        Long userId = 1l;
        String phase_id = "1";
        Employee emp = new Employee();
        emp.setId(userId);
        Optional<Employee> optEmp = Optional.of(emp);
        Mockito.when(employeeRepository.findById(userId)).thenReturn(optEmp);
        PhaseAssignment phAssig = new PhaseAssignment();
        Case casem = new Case();
        casem.setProject(new Project());
        phAssig.setCaseM(casem);
        Employee phEmp = new Employee();
        phEmp.setId(2l);
        phAssig.setDev(phEmp);
        Optional<PhaseAssignment> optPhase = Optional.of(phAssig);
        Mockito.when(phaseAssignmentRepository.findById(Mockito.anyLong())).thenReturn(optPhase);
        PMAssignment pma = new PMAssignment();
        Employee newe = new Employee();
        newe.setId(3l);
        pma.setEmployee(newe);
        Mockito.when(pmaRepository.findLastManager(phAssig.getCaseM().getProject().getId())).thenReturn(pma);
        String expected = "None";
        String result = phaseService.getPhaseJob(userId, phase_id);
        assertEquals(expected, result);
    }

}
