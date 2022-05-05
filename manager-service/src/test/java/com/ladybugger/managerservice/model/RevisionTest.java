/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package com.ladybugger.managerservice.model;

import java.sql.Date;
import java.time.LocalDate;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;

/**
 *
 * @author mario
 */
public class RevisionTest {
    
    private Revision revision;
    
    public RevisionTest() {
    }
    
    @BeforeEach
    public void setUp() {
        revision = new Revision(false, null, null, null);
    }

    /**
     * Test of getId method, of class Revision.
     */
    @Test
    public void testGetId() {
        System.out.println("getId");
        Revision instance = revision;
        Long expResult = 1l;
        instance.setId(expResult);
        Long result = instance.getId();
        assertEquals(expResult, result);
    }

    /**
     * Test of getIsAccepted method, of class Revision.
     */
    @Test
    public void testGetIsAccepted() {
        System.out.println("getIsAccepted");
        Revision instance = revision;
        Boolean expResult = true;
        instance.setIsAccepted(expResult);
        Boolean result = instance.getIsAccepted();
        assertEquals(expResult, result);
    }

    /**
     * Test of getSubmission method, of class Revision.
     */
    @Test
    public void testGetSubmission() {
        System.out.println("getSubmission");
        Revision instance = revision;
        Submission expResult = new Submission();
        instance.setSubmission(expResult);
        Submission result = instance.getSubmission();
        assertEquals(expResult, result);
    }

    /**
     * Test of getDate method, of class Revision.
     */
    @Test
    public void testGetDate() {
        System.out.println("getDate");
        Revision instance = revision;
        Date expResult = Date.valueOf(LocalDate.now());
        instance.setDate(expResult);
        Date result = instance.getDate();
        assertEquals(expResult, result);
    }

    /**
     * Test of getRejectReason method, of class Revision.
     */
    @Test
    public void testGetRejectReason() {
        System.out.println("getRejectReason");
        Revision instance = revision;
        String expResult = "reason";
        instance.setRejectReason(expResult);
        String result = instance.getRejectReason();
        assertEquals(expResult, result);
    }
    
}
