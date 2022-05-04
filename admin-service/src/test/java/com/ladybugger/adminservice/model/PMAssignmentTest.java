/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package com.ladybugger.adminservice.model;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeAll;

/**
 *
 * @author mario
 */
public class PMAssignmentTest {
    
    public PMAssignmentTest() {
    }
    
    @BeforeAll
    public static void setUpClass() {
        PMAssignment pmAssignment = new PMAssignment(new Employee(), new Project(), Timestamp.valueOf(LocalDateTime.now()));
    }

    /**
     * Test of getDate method, of class PMAssignment.
     */
    @Test
    public void testGetDate() {
        System.out.println("getDate");
        PMAssignment instance = new PMAssignment();
        Timestamp expResult = Timestamp.valueOf(LocalDateTime.now());
        instance.setDate(expResult);
        Timestamp result = instance.getDate();
        assertEquals(expResult, result);
    }

    /**
     * Test of getEmployee method, of class PMAssignment.
     */
    @Test
    public void testGetEmployee() {
        System.out.println("getEmployee");
        PMAssignment instance = new PMAssignment();
        Employee expResult = new Employee();
        instance.setEmployee(expResult);
        Employee result = instance.getEmployee();
        assertEquals(expResult, result);
    }

    /**
     * Test of getProject method, of class PMAssignment.
     */
    @Test
    public void testGetProject() {
        System.out.println("getProject");
        PMAssignment instance = new PMAssignment();
        Project expResult = new Project();
        instance.setProject(expResult);
        Project result = instance.getProject();
        assertEquals(expResult, result);
    }
    
}
