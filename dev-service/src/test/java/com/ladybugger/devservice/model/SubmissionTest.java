/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package com.ladybugger.devservice.model;

import java.sql.Date;
import java.time.LocalDate;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author mario
 */
public class SubmissionTest {
    
    public SubmissionTest() {
    }
    
    @BeforeAll
    public static void setUpClass() {
        Submission submission = new Submission(new PhaseAssignment(), "comment", 1, 3f, Date.valueOf(LocalDate.now()));
    }

    /**
     * Test of getId method, of class Submission.
     */
    @Test
    public void testGetId() {
        System.out.println("getId");
        Submission instance = new Submission();
        Long expResult = 1l;
        instance.setId(expResult);
        Long result = instance.getId();
        assertEquals(expResult, result);
    }

    /**
     * Test of getPhaseAssignment method, of class Submission.
     */
    @Test
    public void testGetPhaseAssignment() {
        System.out.println("getPhaseAssignment");
        Submission instance = new Submission();
        PhaseAssignment expResult = new PhaseAssignment();
        instance.setPhaseAssignment(expResult);
        PhaseAssignment result = instance.getPhaseAssignment();
        assertEquals(expResult, result);
    }

    /**
     * Test of getComment method, of class Submission.
     */
    @Test
    public void testGetComment() {
        System.out.println("getComment");
        Submission instance = new Submission();
        String expResult = "comment";
        instance.setComment(expResult);
        String result = instance.getComment();
        assertEquals(expResult, result);
    }

    /**
     * Test of getHours method, of class Submission.
     */
    @Test
    public void testGetHours() {
        System.out.println("getHours");
        Submission instance = new Submission();
        int expResult = 1;
        instance.setHours(expResult);
        int result = instance.getHours();
        assertEquals(expResult, result);
    }

    /**
     * Test of getCost method, of class Submission.
     */
    @Test
    public void testGetCost() {
        System.out.println("getCost");
        Submission instance = new Submission();
        Float expResult = 1f;
        instance.setCost(expResult);
        Float result = instance.getCost();
        assertEquals(expResult, result);
    }

    /**
     * Test of getDate method, of class Submission.
     */
    @Test
    public void testGetDate() {
        System.out.println("getDate");
        Submission instance = new Submission();
        Date expResult = Date.valueOf(LocalDate.now());
        instance.setDate(expResult);
        Date result = instance.getDate();
        assertEquals(expResult, result);
    }
    
}
