/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package com.ladybugger.adminservice.payload.response;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;

/**
 *
 * @author mario
 */
public class CaseResponseTest {
    
    private CaseResponse caseResponse;
    
    public CaseResponseTest() {
    }

    @BeforeEach
    void setUp(){
        caseResponse = new CaseResponse(null,
                null, null, 0, null, null, null, null);
    }

    /**
     * Test of getId method, of class CaseResponse.
     */
    @Test
    public void testGetId() {
        System.out.println("getId");
        CaseResponse instance = caseResponse;
        instance.setId((long) 1);
        Long expResult = (long) 1;
        Long result = instance.getId();
        assertEquals(expResult, result);
    }

    /**
     * Test of getDescription method, of class CaseResponse.
     */
    @Test
    public void testGetDescription() {
        System.out.println("getDescription");
        CaseResponse instance = caseResponse;
        instance.setDescription("desc");
        String expResult = "desc";
        String result = instance.getDescription();
        assertEquals(expResult, result);
    }

    /**
     * Test of getCaseTypeName method, of class CaseResponse.
     */
    @Test
    public void testGetCaseTypeName() {
        System.out.println("getCaseTypeName");
        CaseResponse instance = caseResponse;
        instance.setCaseTypeName("case");
        String expResult = "case";
        String result = instance.getCaseTypeName();
        assertEquals(expResult, result);
    }

    /**
     * Test of getStatus method, of class CaseResponse.
     */
    @Test
    public void testGetStatus() {
        System.out.println("getStatus");
        CaseResponse instance = caseResponse;
        instance.setStatus(1);
        int expResult = 1;
        int result = instance.getStatus();
        assertEquals(expResult, result);
    }

    /**
     * Test of getProjectName method, of class CaseResponse.
     */
    @Test
    public void testGetProjectName() {
        System.out.println("getProjectName");
        CaseResponse instance = caseResponse;
        instance.setProjectName("pname");
        String expResult = "pname";
        String result = instance.getProjectName();
        assertEquals(expResult, result);
    }

    /**
     * Test of getProjectId method, of class CaseResponse.
     */
    @Test
    public void testGetProjectId() {
        System.out.println("getProjectId");
        CaseResponse instance = caseResponse;
        instance.setProjectId((long) 1);
        Long expResult = (long) 1;
        Long result = instance.getProjectId();
        assertEquals(expResult, result);
    }

    /**
     * Test of getStart_date method, of class CaseResponse.
     */
    @Test
    public void testGetStart_date() {
        System.out.println("getStart_date");
        CaseResponse instance = caseResponse;
        instance.setStart_date("10-10-2022");
        String expResult = "10-10-2022";
        String result = instance.getStart_date();
        assertEquals(expResult, result);
    }

    /**
     * Test of getDue_date method, of class CaseResponse.
     */
    @Test
    public void testGetDue_date() {
        System.out.println("getDue_date");
        CaseResponse instance = caseResponse;
        instance.setDue_date("10-10-2022");
        String expResult = "10-10-2022";
        String result = instance.getDue_date();
        assertEquals(expResult, result);
    }
    
}
