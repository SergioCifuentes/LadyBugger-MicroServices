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
public class RevisionCreationRequestTest {
    
    public RevisionCreationRequestTest() {
    }

    /**
     * Test of isAccepted method, of class RevisionCreationRequest.
     */
    @Test
    public void testIsAccepted() {
        System.out.println("isAccepted");
        RevisionCreationRequest instance = new RevisionCreationRequest();
        boolean expResult = true;
        instance.setAccepted(expResult);
        boolean result = instance.isAccepted();
        assertEquals(expResult, result);
    }

    /**
     * Test of getSubmissionId method, of class RevisionCreationRequest.
     */
    @Test
    public void testGetSubmissionId() {
        System.out.println("getSubmissionId");
        RevisionCreationRequest instance = new RevisionCreationRequest();
        int expResult = 1;
        instance.setSubmissionId(expResult);
        int result = instance.getSubmissionId();
        assertEquals(expResult, result);
    }

    /**
     * Test of getDate method, of class RevisionCreationRequest.
     */
    @Test
    public void testGetDate() {
        System.out.println("getDate");
        RevisionCreationRequest instance = new RevisionCreationRequest();
        Date expResult = Date.valueOf(LocalDate.now());
        instance.setDate(expResult);
        Date result = instance.getDate();
        assertEquals(expResult, result);
    }

    /**
     * Test of getRejectReason method, of class RevisionCreationRequest.
     */
    @Test
    public void testGetRejectReason() {
        System.out.println("getRejectReason");
        RevisionCreationRequest instance = new RevisionCreationRequest();
        String expResult = "reject";
        instance.setRejectReason(expResult);
        String result = instance.getRejectReason();
        assertEquals(expResult, result);
    }
    
}
