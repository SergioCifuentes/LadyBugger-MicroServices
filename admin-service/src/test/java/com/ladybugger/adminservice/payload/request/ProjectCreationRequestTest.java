/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package com.ladybugger.adminservice.payload.request;

import java.sql.Date;
import java.time.LocalDate;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author mario
 */
public class ProjectCreationRequestTest {
    
    public ProjectCreationRequestTest() {
    }

    /**
     * Test of getStartDate method, of class ProjectCreationRequest.
     */
    @Test
    public void testGetStartDate() {
        System.out.println("getStartDate");
        ProjectCreationRequest instance = new ProjectCreationRequest();
        Date expResult = Date.valueOf(LocalDate.now());
        instance.setStartDate(expResult);
        Date result = instance.getStartDate();
        assertEquals(expResult, result);
    }

    /**
     * Test of getDueDate method, of class ProjectCreationRequest.
     */
    @Test
    public void testGetDueDate() {
        System.out.println("getDueDate");
        ProjectCreationRequest instance = new ProjectCreationRequest();
        Date expResult = Date.valueOf(LocalDate.now());
        instance.setDueDate(expResult);
        Date result = instance.getDueDate();
        assertEquals(expResult, result);
    }

    /**
     * Test of getName method, of class ProjectCreationRequest.
     */
    @Test
    public void testGetName() {
        System.out.println("getName");
        ProjectCreationRequest instance = new ProjectCreationRequest();
        instance.setName("name");
        String expResult = "name";
        String result = instance.getName();
        assertEquals(expResult, result);
    }

    /**
     * Test of getDescription method, of class ProjectCreationRequest.
     */
    @Test
    public void testGetDescription() {
        System.out.println("getDescription");
        ProjectCreationRequest instance = new ProjectCreationRequest();
        instance.setDescription("description");
        String expResult = "description";
        String result = instance.getDescription();
        assertEquals(expResult, result);
    }

    /**
     * Test of getPmId method, of class ProjectCreationRequest.
     */
    @Test
    public void testGetPmId() {
        System.out.println("getPmId");
        ProjectCreationRequest instance = new ProjectCreationRequest();
        instance.setPmId(1);
        int expResult = 1;
        int result = instance.getPmId();
        assertEquals(expResult, result);
    }
    
}
