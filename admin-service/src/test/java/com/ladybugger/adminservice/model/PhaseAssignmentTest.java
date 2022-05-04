/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package com.ladybugger.adminservice.model;

import java.sql.Date;
import java.time.LocalDate;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeAll;

/**
 *
 * @author mario
 */
public class PhaseAssignmentTest {
    
    public PhaseAssignmentTest() {
    }
    
    @BeforeAll
    public static void setUpClass() {
        PhaseAssignment phaseAssignment = new PhaseAssignment(new Employee(),
                new Phase(), new Case(), "desc", 1, Date.valueOf(LocalDate.now()), Date.valueOf(LocalDate.now()));
    }

    /**
     * Test of getDescription method, of class PhaseAssignment.
     */
    @Test
    public void testGetDescription() {
        System.out.println("getDescription");
        PhaseAssignment instance = new PhaseAssignment();
        String expResult = "desc";
        instance.setDescription(expResult);
        String result = instance.getDescription();
        assertEquals(expResult, result);
    }

    /**
     * Test of getCaseM method, of class PhaseAssignment.
     */
    @Test
    public void testGetCaseM() {
        System.out.println("getCaseM");
        PhaseAssignment instance = new PhaseAssignment();
        Case expResult = new Case();
        instance.setCaseM(expResult);
        Case result = instance.getCaseM();
        assertEquals(expResult, result);
    }

    /**
     * Test of getId method, of class PhaseAssignment.
     */
    @Test
    public void testGetId() {
        System.out.println("getId");
        PhaseAssignment instance = new PhaseAssignment();
        Long expResult = (long) 1;
        instance.setId(expResult);
        Long result = instance.getId();
        assertEquals(expResult, result);
    }

    /**
     * Test of getDev method, of class PhaseAssignment.
     */
    @Test
    public void testGetDev() {
        System.out.println("getDev");
        PhaseAssignment instance = new PhaseAssignment();
        Employee expResult = new Employee();
        instance.setDev(expResult);
        Employee result = instance.getDev();
        assertEquals(expResult, result);
    }

    /**
     * Test of getPhase method, of class PhaseAssignment.
     */
    @Test
    public void testGetPhase() {
        System.out.println("getPhase");
        PhaseAssignment instance = new PhaseAssignment();
        Phase expResult = new Phase();
        instance.setPhase(expResult);
        Phase result = instance.getPhase();
        assertEquals(expResult, result);
    }

    /**
     * Test of getStatus method, of class PhaseAssignment.
     */
    @Test
    public void testGetStatus() {
        System.out.println("getStatus");
        PhaseAssignment instance = new PhaseAssignment();
        int expResult = 1;
        instance.setStatus(expResult);
        int result = instance.getStatus();
        assertEquals(expResult, result);
    }

    /**
     * Test of getStartDate method, of class PhaseAssignment.
     */
    @Test
    public void testGetStartDate() {
        System.out.println("getStartDate");
        PhaseAssignment instance = new PhaseAssignment();
        Date expResult = Date.valueOf(LocalDate.now());
        instance.setStartDate(expResult);
        Date result = instance.getStartDate();
        assertEquals(expResult, result);
    }

    /**
     * Test of getDueDate method, of class PhaseAssignment.
     */
    @Test
    public void testGetDueDate() {
        System.out.println("getDueDate");
        PhaseAssignment instance = new PhaseAssignment();
        Date expResult = Date.valueOf(LocalDate.now());
        instance.setDueDate(expResult);
        Date result = instance.getDueDate();
        assertEquals(expResult, result);
    }
    
}
