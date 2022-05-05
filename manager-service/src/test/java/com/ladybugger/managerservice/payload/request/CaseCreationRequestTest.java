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
public class CaseCreationRequestTest {
    
    public CaseCreationRequestTest() {
    }

    /**
     * Test of getTitle method, of class CaseCreationRequest.
     */
    @Test
    public void testGetTitle() {
        System.out.println("getTitle");
        CaseCreationRequest instance = new CaseCreationRequest();
        String expResult = "title";
        instance.setTitle(expResult);
        String result = instance.getTitle();
        assertEquals(expResult, result);
    }

    /**
     * Test of getStartDate method, of class CaseCreationRequest.
     */
    @Test
    public void testGetStartDate() {
        System.out.println("getStartDate");
        CaseCreationRequest instance = new CaseCreationRequest();
        Date expResult = Date.valueOf(LocalDate.now());
        instance.setStartDate(expResult);
        Date result = instance.getStartDate();
        assertEquals(expResult, result);
    }

    /**
     * Test of getDueDate method, of class CaseCreationRequest.
     */
    @Test
    public void testGetDueDate() {
        System.out.println("getDueDate");
        CaseCreationRequest instance = new CaseCreationRequest();
        Date expResult = Date.valueOf(LocalDate.now());
        instance.setDueDate(expResult);
        Date result = instance.getDueDate();
        assertEquals(expResult, result);
    }

    /**
     * Test of getDescription method, of class CaseCreationRequest.
     */
    @Test
    public void testGetDescription() {
        System.out.println("getDescription");
        CaseCreationRequest instance = new CaseCreationRequest();
        String expResult = "desc";
        instance.setDescription(expResult);
        String result = instance.getDescription();
        assertEquals(expResult, result);
    }

    /**
     * Test of getCaseTypeId method, of class CaseCreationRequest.
     */
    @Test
    public void testGetCaseTypeId() {
        System.out.println("getCaseTypeId");
        CaseCreationRequest instance = new CaseCreationRequest();
        int expResult = 1;
        instance.setCaseTypeId(expResult);
        int result = instance.getCaseTypeId();
        assertEquals(expResult, result);
    }

    /**
     * Test of getProjectId method, of class CaseCreationRequest.
     */
    @Test
    public void testGetProjectId() {
        System.out.println("getProjectId");
        CaseCreationRequest instance = new CaseCreationRequest();
        int expResult = 1;
        instance.setProjectId(expResult);
        int result = instance.getProjectId();
        assertEquals(expResult, result);
    }
    
}
