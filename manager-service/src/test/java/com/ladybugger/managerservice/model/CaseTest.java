/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package com.ladybugger.managerservice.model;

import java.sql.Date;
import java.time.LocalDate;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeAll;

/**
 *
 * @author mario
 */
public class CaseTest {
    
    public CaseTest() {
    }
    
    @BeforeAll
    public static void setUpClass() {
        Case casem = new Case("title", "desc", new CaseType(), 0, new Project(), Date.valueOf(LocalDate.now()), Date.valueOf(LocalDate.now()), 0);
    }

    /**
     * Test of getCurrent method, of class Case.
     */
    @Test
    public void testGetCurrent() {
        System.out.println("getCurrent");
        Case instance = new Case();
        int expResult = 1;
        instance.setCurrent(expResult);
        int result = instance.getCurrent();
        assertEquals(expResult, result);
    }

    /**
     * Test of getId method, of class Case.
     */
    @Test
    public void testGetId() {
        System.out.println("getId");
        Case instance = new Case();
        Long expResult = (long) 1;
        instance.setId(expResult);
        Long result = instance.getId();
        assertEquals(expResult, result);
    }

    /**
     * Test of getTitle method, of class Case.
     */
    @Test
    public void testGetTitle() {
        System.out.println("getTitle");
        Case instance = new Case();
        String expResult = "title";
        instance.setTitle(expResult);
        String result = instance.getTitle();
        assertEquals(expResult, result);
    }

    /**
     * Test of getDescription method, of class Case.
     */
    @Test
    public void testGetDescription() {
        System.out.println("getDescription");
        Case instance = new Case();
        String expResult = "desc";
        instance.setDescription(expResult);
        String result = instance.getDescription();
        assertEquals(expResult, result);
    }

    /**
     * Test of getCasetype method, of class Case.
     */
    @Test
    public void testGetCasetype() {
        System.out.println("getCasetype");
        Case instance = new Case();
        CaseType expResult = new CaseType();
        instance.setCasetype(expResult);
        CaseType result = instance.getCasetype();
        assertEquals(expResult, result);
    }

    /**
     * Test of getStatus method, of class Case.
     */
    @Test
    public void testGetStatus() {
        System.out.println("getStatus");
        Case instance = new Case();
        int expResult = 1;
        instance.setStatus(expResult);
        int result = instance.getStatus();
        assertEquals(expResult, result);
    }

    /**
     * Test of getProject method, of class Case.
     */
    @Test
    public void testGetProject() {
        System.out.println("getProject");
        Case instance = new Case();
        Project expResult = new Project();
        instance.setProject(expResult);
        Project result = instance.getProject();
        assertEquals(expResult, result);
    }

    /**
     * Test of getStartDate method, of class Case.
     */
    @Test
    public void testGetStartDate() {
        System.out.println("getStartDate");
        Case instance = new Case();
        Date expResult = Date.valueOf(LocalDate.now());
        instance.setStartDate(expResult);
        Date result = instance.getStartDate();
        assertEquals(expResult, result);
    }

    /**
     * Test of getDueDate method, of class Case.
     */
    @Test
    public void testGetDueDate() {
        System.out.println("getDueDate");
        Case instance = new Case();
        Date expResult = Date.valueOf(LocalDate.now());
        instance.setDueDate(expResult);
        Date result = instance.getDueDate();
        assertEquals(expResult, result);
    }
    
}
