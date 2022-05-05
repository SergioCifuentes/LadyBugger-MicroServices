/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package com.ladybugger.managerservice.payload.request;

import java.sql.Date;
import java.time.LocalDate;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author mario
 */
public class PhaseAssignmentRequestTest {
    
    public PhaseAssignmentRequestTest() {
    }

    /**
     * Test of getDevId method, of class PhaseAssignmentRequest.
     */
    @Test
    public void testGetDevId() {
        System.out.println("getDevId");
        PhaseAssignmentRequest instance = new PhaseAssignmentRequest();
        int expResult = 1;
        instance.setDevId(expResult);
        int result = instance.getDevId();
        assertEquals(expResult, result);
    }

    /**
     * Test of getCaseId method, of class PhaseAssignmentRequest.
     */
    @Test
    public void testGetCaseId() {
        System.out.println("getCaseId");
        PhaseAssignmentRequest instance = new PhaseAssignmentRequest();
        int expResult = 1;
        instance.setCaseId(expResult);
        int result = instance.getCaseId();
        assertEquals(expResult, result);
    }

    /**
     * Test of getDescription method, of class PhaseAssignmentRequest.
     */
    @Test
    public void testGetDescription() {
        System.out.println("getDescription");
        PhaseAssignmentRequest instance = new PhaseAssignmentRequest();
        String expResult = "desc";
        instance.setDescription(expResult);
        String result = instance.getDescription();
        assertEquals(expResult, result);
    }

    /**
     * Test of getPhaseId method, of class PhaseAssignmentRequest.
     */
    @Test
    public void testGetPhaseId() {
        System.out.println("getPhaseId");
        PhaseAssignmentRequest instance = new PhaseAssignmentRequest();
        int expResult = 1;
        instance.setPhaseId(expResult);
        int result = instance.getPhaseId();
        assertEquals(expResult, result);
    }

    /**
     * Test of getStartDate method, of class PhaseAssignmentRequest.
     */
    @Test
    public void testGetStartDate() {
        System.out.println("getStartDate");
        PhaseAssignmentRequest instance = new PhaseAssignmentRequest();
        Date expResult = Date.valueOf(LocalDate.now());
        instance.setStartDate(expResult);
        Date result = instance.getStartDate();
        assertEquals(expResult, result);
    }

    /**
     * Test of getDueDate method, of class PhaseAssignmentRequest.
     */
    @Test
    public void testGetDueDate() {
        System.out.println("getDueDate");
        PhaseAssignmentRequest instance = new PhaseAssignmentRequest();
        Date expResult = Date.valueOf(LocalDate.now());
        instance.setDueDate(expResult);
        Date result = instance.getDueDate();
        assertEquals(expResult, result);
    }
    
}
