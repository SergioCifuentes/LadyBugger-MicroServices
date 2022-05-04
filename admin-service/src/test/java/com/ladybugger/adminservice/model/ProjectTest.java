/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package com.ladybugger.adminservice.model;

import java.sql.Date;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeAll;

/**
 *
 * @author mario
 */
public class ProjectTest {
    
    public ProjectTest() {
    }
    
    @BeforeAll
    public static void setUpClass() {
        Project project = new Project("name", "desc", 1, Date.valueOf(LocalDate.now()),
                Date.valueOf(LocalDate.now()), new Employee());
    }

    /**
     * Test of getCases method, of class Project.
     */
    @Test
    public void testGetCases() {
        System.out.println("getCases");
        Project instance = new Project();
        Set<Case> expResult = Set.of();
        instance.setCases(expResult);
        Set<Case> result = instance.getCases();
        assertEquals(expResult, result);
    }

    /**
     * Test of getStartDate method, of class Project.
     */
    @Test
    public void testGetStartDate() {
        System.out.println("getStartDate");
        Project instance = new Project();
        Date expResult = Date.valueOf(LocalDate.now());
        instance.setStartDate(expResult);
        Date result = instance.getStartDate();
        assertEquals(expResult, result);
    }

    /**
     * Test of getDueDate method, of class Project.
     */
    @Test
    public void testGetDueDate() {
        System.out.println("getDueDate");
        Project instance = new Project();
        Date expResult = Date.valueOf(LocalDate.now());
        instance.setDueDate(expResult);
        Date result = instance.getDueDate();
        assertEquals(expResult, result);
    }

    /**
     * Test of getPms method, of class Project.
     */
    @Test
    public void testGetPms() {
        System.out.println("getPms");
        Project instance = new Project();
        PMAssignment pma = new PMAssignment();
        Set<PMAssignment> expResult = new HashSet<>();
        instance.setPms(expResult);
        Set<PMAssignment> result = instance.getPms();
        assertEquals(expResult, result);
        instance.addPm(pma);
    }

    /**
     * Test of getDescription method, of class Project.
     */
    @Test
    public void testGetDescription() {
        System.out.println("getDescription");
        Project instance = new Project();
        String expResult = "desc";
        instance.setDescription(expResult);
        String result = instance.getDescription();
        assertEquals(expResult, result);
    }

    /**
     * Test of getStatus method, of class Project.
     */
    @Test
    public void testGetStatus() {
        System.out.println("getStatus");
        Project instance = new Project();
        int expResult = 1;
        instance.setStatus(expResult);
        int result = instance.getStatus();
        assertEquals(expResult, result);
    }

    /**
     * Test of getAdmin method, of class Project.
     */
    @Test
    public void testGetAdmin() {
        System.out.println("getAdmin");
        Project instance = new Project();
        Employee expResult = new Employee();
        instance.setAdmin(expResult);
        Employee result = instance.getAdmin();
        assertEquals(expResult, result);
    }

    /**
     * Test of getId method, of class Project.
     */
    @Test
    public void testGetId() {
        System.out.println("getId");
        Project instance = new Project();
        Long expResult = (long) 1;
        instance.setId(expResult);
        Long result = instance.getId();
        assertEquals(expResult, result);
    }

    /**
     * Test of getName method, of class Project.
     */
    @Test
    public void testGetName() {
        System.out.println("getName");
        Project instance = new Project();
        String expResult = "name";
        instance.setName(expResult);
        String result = instance.getName();
        assertEquals(expResult, result);
    }
    
}
