/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package com.ladybugger.managerservice.service;

import com.ladybugger.managerservice.exceptions.LogicalError;
import com.ladybugger.managerservice.model.Case;
import com.ladybugger.managerservice.model.CaseType;
import com.ladybugger.managerservice.model.Employee;
import com.ladybugger.managerservice.model.PMAssignment;
import com.ladybugger.managerservice.model.Phase;
import com.ladybugger.managerservice.model.PhaseAssignment;
import com.ladybugger.managerservice.model.Project;
import com.ladybugger.managerservice.payload.response.ProjectView;
import com.ladybugger.managerservice.payload.response.SimpleProject;
import com.ladybugger.managerservice.repository.EmployeeRepository;
import com.ladybugger.managerservice.repository.PMAssignmentRepository;
import com.ladybugger.managerservice.repository.PhaseAssignmentRepository;
import com.ladybugger.managerservice.repository.ProjectRepository;
import java.sql.Date;
import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.LocalDateTime;
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
public class ProjectServiceTest {
    
    @Mock
    private EmployeeRepository employeeRepository;
    @Mock
    private ProjectRepository projectRepository;
    @Mock
    private PMAssignmentRepository pmaRepository;
    @Mock
    private PhaseAssignmentRepository phaseAssignmentRepository;
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
    
    @Test
    public void testGetProject() {
        System.out.println("getProject");
        String projectId = "1";
        Project project = new Project("name", "desc", 0, Date.valueOf(LocalDate.now()), Date.valueOf(LocalDate.now()), new Employee());
        project.setCases(Set.of(getCase()));
        Optional<Project> optProject = Optional.of(project);
        Mockito.when(projectRepository.findById(Mockito.anyLong())).thenReturn(optProject);
        PMAssignment pma = new PMAssignment(new Employee(), project, Timestamp.valueOf(LocalDateTime.MIN));
        Mockito.when(pmaRepository.findLastManager(project.getId())).thenReturn(pma);
        PhaseAssignment pha = new PhaseAssignment(new Employee(), null, null, projectId, 0, Date.valueOf(LocalDate.now()), Date.valueOf(LocalDate.now()));
        Mockito.when(phaseAssignmentRepository.findDev(1l, 1l)).thenReturn(pha);
        ProjectView pv = projectService.getProject(projectId);
        assertNotNull(pv);
    }
    
    @Test
    public void testGetProjectWhenPhaseAssignmentIsNull() {
        System.out.println("getProject");
        String projectId = "1";
        Project project = new Project("name", "desc", 0, Date.valueOf(LocalDate.now()), Date.valueOf(LocalDate.now()), new Employee());
        project.setCases(Set.of(getCase()));
        Optional<Project> optProject = Optional.of(project);
        Mockito.when(projectRepository.findById(Mockito.anyLong())).thenReturn(optProject);
        PMAssignment pma = new PMAssignment(new Employee(), project, Timestamp.valueOf(LocalDateTime.MIN));
        Mockito.when(pmaRepository.findLastManager(project.getId())).thenReturn(pma);
        Mockito.when(phaseAssignmentRepository.findDev(Mockito.anyLong(), Mockito.anyLong())).thenReturn(null);
        ProjectView pv = projectService.getProject(projectId);
        assertNotNull(pv);
    }
    
    @Test
    public void testGetProjectWhenProjectIdIsNotLong() {
        System.out.println("getProject");
        String projectId = "error";
        LogicalError error = assertThrows(LogicalError.class, () -> {
            projectService.getProject(projectId);
        });
        assertEquals("Wrong id", error.getMessage());
    }
    
    private Case getCase() {
        CaseType caset = new CaseType("desc", "desc", 0);
        Phase ph = new Phase();
        ph.setId(1l);
        caset.setPhases(Set.of(ph));
        Case casem = new Case("title", "desc", caset, 0, new Project(), Date.valueOf(LocalDate.now()), Date.valueOf(LocalDate.now()), 0);
        casem.setId(1l);
        return casem;
    }
    
}
