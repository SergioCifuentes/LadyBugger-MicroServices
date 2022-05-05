/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package com.ladybugger.devservice.payload.request;

import java.sql.Date;
import java.time.LocalDate;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author mario
 */
public class SubmissionRequestTest {
    
    public SubmissionRequestTest() {
    }

    /**
     * Test of getPhaseAssignmentId method, of class SubmissionRequest.
     */
    @Test
    public void testGetPhaseAssignmentId() {
        System.out.println("getPhaseAssignmentId");
        SubmissionRequest instance = new SubmissionRequest();
        int expResult = 1;
        instance.setPhaseAssignmentId(expResult);
        int result = instance.getPhaseAssignmentId();
        assertEquals(expResult, result);
    }

    /**
     * Test of getComment method, of class SubmissionRequest.
     */
    @Test
    public void testGetComment() {
        System.out.println("getComment");
        SubmissionRequest instance = new SubmissionRequest();
        String expResult = "comment";
        instance.setComment(expResult);
        String result = instance.getComment();
        assertEquals(expResult, result);
    }

    /**
     * Test of getHours method, of class SubmissionRequest.
     */
    @Test
    public void testGetHours() {
        System.out.println("getHours");
        SubmissionRequest instance = new SubmissionRequest();
        int expResult = 1;
        instance.setHours(expResult);
        int result = instance.getHours();
        assertEquals(expResult, result);
    }

    /**
     * Test of getCost method, of class SubmissionRequest.
     */
    @Test
    public void testGetCost() {
        System.out.println("getCost");
        SubmissionRequest instance = new SubmissionRequest();
        Float expResult = 1f;
        instance.setCost(expResult);
        Float result = instance.getCost();
        assertEquals(expResult, result);
    }

    /**
     * Test of getDate method, of class SubmissionRequest.
     */
    @Test
    public void testGetDate() {
        System.out.println("getDate");
        SubmissionRequest instance = new SubmissionRequest();
        Date expResult = Date.valueOf(LocalDate.now());
        instance.setDate(expResult);
        Date result = instance.getDate();
        assertEquals(expResult, result);
    }
    
}
