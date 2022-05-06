/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package com.ladybugger.managerservice.service;

import com.ladybugger.managerservice.payload.request.CaseCreationRequest;
import com.ladybugger.managerservice.repository.CaseRepository;
import com.ladybugger.managerservice.repository.CaseTypeRepository;
import com.ladybugger.managerservice.repository.EmployeeRepository;
import com.ladybugger.managerservice.repository.PMAssignmentRepository;
import com.ladybugger.managerservice.repository.ProjectRepository;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

/**
 *
 * @author mario
 */
public class CaseTypeServiceTest {
    
    @Mock
    CaseTypeRepository caseTypeRepository;
    @Mock
    CaseRepository caseRepository;
    @Mock
    EmployeeRepository employeeRepository;
    @Mock
    ProjectRepository projectRepository;
    @Mock
    PMAssignmentRepository pmaRepository;
    
    public CaseTypeServiceTest() {
    }
    
    @Before
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    /**
     * Test of registerCaseType method, of class CaseTypeService.
     */
    @Test
    public void testRegisterCaseType() {
        System.out.println("registerCaseType");
        Long userId = null;
        CaseCreationRequest caseRequest = null;
        CaseTypeService instance = new CaseTypeService();
        String expResult = "";
        String result = instance.registerCaseType(userId, caseRequest);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
