/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package com.ladybugger.devservice.payload.response;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;

/**
 *
 * @author mario
 */
public class PhaseResponseTest {
    
    private PhaseResponse phaseR;
    
    public PhaseResponseTest() {
    }
    
    @BeforeEach
    public void setUp() {
        phaseR = new PhaseResponse(null, null, null,
                null, null, null, null, null, null);
    }

    /**
     * Test of getName method, of class PhaseResponse.
     */
    @Test
    public void testGetName() {
        System.out.println("getName");
        PhaseResponse instance = phaseR;
        String expResult = "name";
        instance.setName(expResult);
        String result = instance.getName();
        assertEquals(expResult, result);
    }

    /**
     * Test of getDev_name method, of class PhaseResponse.
     */
    @Test
    public void testGetDev_name() {
        System.out.println("getDev_name");
        PhaseResponse instance = phaseR;
        String expResult = "devName";
        instance.setDev_name(expResult);
        String result = instance.getDev_name();
        assertEquals(expResult, result);
    }

    /**
     * Test of getStartDate method, of class PhaseResponse.
     */
    @Test
    public void testGetStartDate() {
        System.out.println("getStartDate");
        PhaseResponse instance = phaseR;
        String expResult = "10-10-2022";
        instance.setStartDate(expResult);
        String result = instance.getStartDate();
        assertEquals(expResult, result);
    }

    /**
     * Test of getDueDate method, of class PhaseResponse.
     */
    @Test
    public void testGetDueDate() {
        System.out.println("getDueDate");
        PhaseResponse instance = phaseR;
        String expResult = "10-10-2022";
        instance.setDueDate(expResult);
        String result = instance.getDueDate();
        assertEquals(expResult, result);
    }

    /**
     * Test of getProjectId method, of class PhaseResponse.
     */
    @Test
    public void testGetProjectId() {
        System.out.println("getProjectId");
        PhaseResponse instance = phaseR;
        Long expResult = 1l;
        instance.setProjectId(expResult);
        Long result = instance.getProjectId();
        assertEquals(expResult, result);
    }

    /**
     * Test of getProjectName method, of class PhaseResponse.
     */
    @Test
    public void testGetProjectName() {
        System.out.println("getProjectName");
        PhaseResponse instance = phaseR;
        String expResult = "projectName";
        instance.setProjectName(expResult);
        String result = instance.getProjectName();
        assertEquals(expResult, result);
    }

    /**
     * Test of getCaseId method, of class PhaseResponse.
     */
    @Test
    public void testGetCaseId() {
        System.out.println("getCaseId");
        PhaseResponse instance = phaseR;
        Long expResult = 1l;
        instance.setCaseId(expResult);
        Long result = instance.getCaseId();
        assertEquals(expResult, result);
    }

    /**
     * Test of getCaseName method, of class PhaseResponse.
     */
    @Test
    public void testGetCaseName() {
        System.out.println("getCaseName");
        PhaseResponse instance = phaseR;
        String expResult = "caseName";
        instance.setCaseName(expResult);
        String result = instance.getCaseName();
        assertEquals(expResult, result);
    }

    /**
     * Test of getCaseDescription method, of class PhaseResponse.
     */
    @Test
    public void testGetCaseDescription() {
        System.out.println("getCaseDescription");
        PhaseResponse instance = phaseR;
        String expResult = "desc";
        instance.setCaseDescription(expResult);
        String result = instance.getCaseDescription();
        assertEquals(expResult, result);
    }
    
}
