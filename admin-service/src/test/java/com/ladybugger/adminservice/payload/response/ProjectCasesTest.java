/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package com.ladybugger.adminservice.payload.response;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;

/**
 *
 * @author mario
 */
public class ProjectCasesTest {
    
    private ProjectCases projectCases;
    
    public ProjectCasesTest() {
    }
    
    @BeforeEach
    void setUp() {
        projectCases = new ProjectCases(null, null, null, 0, null, null, new ArrayList<>());
    }

    /**
     * Test of getId method, of class ProjectCases.
     */
    @Test
    public void testGetId() {
        System.out.println("getId");
        ProjectCases instance = projectCases;
        Long expResult = (long) 1;
        instance.setId(expResult);
        Long result = instance.getId();
        assertEquals(expResult, result);
    }

    /**
     * Test of getName method, of class ProjectCases.
     */
    @Test
    public void testGetName() {
        System.out.println("getName");
        ProjectCases instance = projectCases;
        String expResult = "name";
        instance.setName(expResult);
        String result = instance.getName();
        assertEquals(expResult, result);
    }

    /**
     * Test of getPm_name method, of class ProjectCases.
     */
    @Test
    public void testGetPm_name() {
        System.out.println("getPm_name");
        ProjectCases instance = projectCases;
        String expResult = "pmName";
        instance.setPm_name(expResult);
        String result = instance.getPm_name();
        assertEquals(expResult, result);
    }

    /**
     * Test of getStatus method, of class ProjectCases.
     */
    @Test
    public void testGetStatus() {
        System.out.println("getStatus");
        ProjectCases instance = projectCases;
        int expResult = 1;
        instance.setStatus(expResult);
        int result = instance.getStatus();
        assertEquals(expResult, result);
    }

    /**
     * Test of getStart_date method, of class ProjectCases.
     */
    @Test
    public void testGetStart_date() {
        System.out.println("getStart_date");
        ProjectCases instance = projectCases;
        String expResult = "10-10-2022";
        instance.setStart_date(expResult);
        String result = instance.getStart_date();
        assertEquals(expResult, result);
    }

    /**
     * Test of getDue_date method, of class ProjectCases.
     */
    @Test
    public void testGetDue_date() {
        System.out.println("getDue_date");
        ProjectCases instance = projectCases;
        String expResult = "10-10-2022";
        instance.setDue_date(expResult);
        String result = instance.getDue_date();
        assertEquals(expResult, result);
    }

    /**
     * Test of getCases_amount method, of class ProjectCases.
     */
    @Test
    public void testGetCases_amount() {
        System.out.println("getCases_amount");
        ProjectCases instance = projectCases;
        int expResult = 1;
        instance.setCases_amount(expResult);
        int result = instance.getCases_amount();
        assertEquals(expResult, result);
    }

    /**
     * Test of getCases method, of class ProjectCases.
     */
    @Test
    public void testGetCases() {
        System.out.println("getCases");
        ProjectCases instance = projectCases;
        List<SimpleCase> expResult = new ArrayList<>();
        instance.setCases(expResult);
        List<SimpleCase> result = instance.getCases();
        assertEquals(expResult, result);
    }
    
}
