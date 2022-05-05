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
public class PhaseDevResponseTest {
    
    private PhaseDevResponse phaseDev;
    
    public PhaseDevResponseTest() {
    }
    
    @BeforeEach
    public void setUp() {
        phaseDev = new PhaseDevResponse(1l, "name",
                "project", "case", "dev", "10-10-2022", "10-10-2022", 1);
    }

    /**
     * Test of getId method, of class PhaseDevResponse.
     */
    @Test
    public void testGetId() {
        System.out.println("getId");
        PhaseDevResponse instance = phaseDev;
        Long expResult = 1l;
        instance.setId(expResult);
        Long result = instance.getId();
        assertEquals(expResult, result);
    }

    /**
     * Test of getName method, of class PhaseDevResponse.
     */
    @Test
    public void testGetName() {
        System.out.println("getName");
        PhaseDevResponse instance = phaseDev;
        String expResult = "name";
        instance.setName(expResult);
        String result = instance.getName();
        assertEquals(expResult, result);
    }

    /**
     * Test of getProjectName method, of class PhaseDevResponse.
     */
    @Test
    public void testGetProjectName() {
        System.out.println("getProjectName");
        PhaseDevResponse instance = phaseDev;
        String expResult = "project";
        instance.setProjectName(expResult);
        String result = instance.getProjectName();
        assertEquals(expResult, result);
    }

    /**
     * Test of getCaseName method, of class PhaseDevResponse.
     */
    @Test
    public void testGetCaseName() {
        System.out.println("getCaseName");
        PhaseDevResponse instance = phaseDev;
        String expResult = "caseName";
        instance.setCaseName(expResult);
        String result = instance.getCaseName();
        assertEquals(expResult, result);
    }

    /**
     * Test of getDev_name method, of class PhaseDevResponse.
     */
    @Test
    public void testGetDev_name() {
        System.out.println("getDev_name");
        PhaseDevResponse instance = phaseDev;
        String expResult = "dev name";
        instance.setDev_name(expResult);
        String result = instance.getDev_name();
        assertEquals(expResult, result);
    }

    /**
     * Test of getStartDate method, of class PhaseDevResponse.
     */
    @Test
    public void testGetStartDate() {
        System.out.println("getStartDate");
        PhaseDevResponse instance = phaseDev;
        String expResult = "10-10-2022";
        instance.setStartDate(expResult);
        String result = instance.getStartDate();
        assertEquals(expResult, result);
    }

    /**
     * Test of getDueDate method, of class PhaseDevResponse.
     */
    @Test
    public void testGetDueDate() {
        System.out.println("getDueDate");
        PhaseDevResponse instance = phaseDev;
        String expResult = "10-10-2022";
        instance.setDueDate(expResult);
        String result = instance.getDueDate();
        assertEquals(expResult, result);
    }

    /**
     * Test of getStatus method, of class PhaseDevResponse.
     */
    @Test
    public void testGetStatus() {
        System.out.println("getStatus");
        PhaseDevResponse instance = phaseDev;
        int expResult = 1;
        instance.setStatus(expResult);
        int result = instance.getStatus();
        assertEquals(expResult, result);
    }
    
}
