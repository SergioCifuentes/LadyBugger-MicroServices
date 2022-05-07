/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package com.ladybugger.adminservice.controller;

import com.ladybugger.adminservice.payload.request.CaseTypeCreationRequest;
import com.ladybugger.adminservice.payload.request.PMAssignmentRequest;
import com.ladybugger.adminservice.payload.response.CaseResponse;
import com.ladybugger.adminservice.payload.response.EmployeeResponse;
import com.ladybugger.adminservice.payload.response.ProjectCases;
import com.ladybugger.adminservice.service.CaseService;
import com.ladybugger.adminservice.service.CaseTypeService;
import com.ladybugger.adminservice.service.DevsService;
import com.ladybugger.adminservice.service.ProjectService;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

/**
 *
 * @author mario
 */
public class AdminControllerTest {
    
    @Mock
    private DevsService devsService;
    @Mock
    private CaseTypeService caseTypeService;
    @Mock
    private ProjectService projectService;
    @Mock
    private CaseService caseService;
    @InjectMocks
    private AdminController adminController;
    
    public AdminControllerTest() {
    }
    
    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    /**
     * Test of registerProject method, of class AdminController.
     */
    /*@Test
    public void testRegisterProject() {
        System.out.println("registerProject");
        ProjectCreationRequest projectCreationRequest = null;
        AdminController instance = new AdminController();
        ResponseEntity expResult = null;
        ResponseEntity result = instance.registerProject(projectCreationRequest);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }*/

    /**
     * Test of getDevs method, of class AdminController.
     */
    @Test
    public void testGetDevs() {
        System.out.println("getDevs");
        List expResult = new ArrayList();
        Mockito.when(devsService.getDevsByRole()).thenReturn(expResult);
        assertEquals(expResult, adminController.getDevs());
    }

    /**
     * Test of registerCaseType method, of class AdminController.
     */
    @Test
    public void testRegisterCaseType() {
        System.out.println("registerCaseType");
        CaseTypeCreationRequest caseRequest = new CaseTypeCreationRequest();
        String body = "body";
        ResponseEntity expResult = new ResponseEntity<String>(body, HttpStatus.OK);
        Mockito.when(caseTypeService.createCaseTypeService(caseRequest)).thenReturn(body);
        ResponseEntity result = adminController.registerCaseType(caseRequest);
        assertEquals(expResult, result);
    }

    /**
     * Test of assignProject method, of class AdminController.
     */
    @Test
    public void testAssignProject() {
        System.out.println("assignProject");
        PMAssignmentRequest pmAssignmentRequest = new PMAssignmentRequest();
        String body = "body";
        ResponseEntity expResult = new ResponseEntity<String>(body, HttpStatus.OK);
        Mockito.when(devsService.assignProject(pmAssignmentRequest)).thenReturn(body);
        ResponseEntity result = adminController.assignProject(pmAssignmentRequest);
        assertEquals(expResult, result);
    }

    /**
     * Test of getProjects method, of class AdminController.
     */
    @Test
    public void testGetProjects() {
        System.out.println("getProjects");
        Pageable pageable = Pageable.unpaged();
        List<ProjectCases> pc = List.of();
        ResponseEntity expResult = ResponseEntity.ok(pc);
        Mockito.when(projectService.getProjectsPageable(pageable)).thenReturn(pc);
        ResponseEntity result = adminController.getProjects(pageable);
        assertEquals(expResult, result);
    }

    /**
     * Test of softDeleteEmployee method, of class AdminController.
     */
    /*@Test
    public void testSoftDeleteEmployee() {
        System.out.println("softDeleteEmployee");
        Long employeeId = null;
        AdminController instance = new AdminController();
        ResponseEntity expResult = null;
        ResponseEntity result = instance.softDeleteEmployee(employeeId);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }*/

    /**
     * Test of getCases method, of class AdminController.
     */
    @Test
    public void testGetCases() {
        System.out.println("getCases");
        Pageable pageable = Pageable.unpaged();
        List<CaseResponse> cr = List.of();
        ResponseEntity expResult = ResponseEntity.ok(cr);
        Mockito.when(caseService.getProjectsPageable(pageable)).thenReturn(cr);
        ResponseEntity result = adminController.getCases(pageable);
        assertEquals(expResult, result);
    }

    /**
     * Test of getUsers method, of class AdminController.
     */
    @Test
    public void testGetUsers() {
        System.out.println("getUsers");
        Pageable pageable = Pageable.unpaged();
        List<EmployeeResponse> cr = List.of();
        ResponseEntity expResult = ResponseEntity.ok(cr);
        Mockito.when(devsService.getUsers(pageable)).thenReturn(cr);
        ResponseEntity result = adminController.getUsers(pageable);
        assertEquals(expResult, result);
    }
    
}
