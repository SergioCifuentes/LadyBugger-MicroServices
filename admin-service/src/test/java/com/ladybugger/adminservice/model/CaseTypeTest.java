/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package com.ladybugger.adminservice.model;

import java.util.Set;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeAll;

/**
 *
 * @author mario
 */
public class CaseTypeTest {
    
    public CaseTypeTest() {
    }
    
    @BeforeAll
    public static void setUpClass() {
        CaseType casetype = new CaseType("name", "desc", 1);
    }

    /**
     * Test of getPhases method, of class CaseType.
     */
    @Test
    public void testGetPhases() {
        System.out.println("getPhases");
        CaseType instance = new CaseType();
        Set<Phase> expResult = Set.of();
        instance.setPhases(expResult);
        Set<Phase> result = instance.getPhases();
        assertEquals(expResult, result);
    }

    /**
     * Test of getId method, of class CaseType.
     */
    @Test
    public void testGetId() {
        System.out.println("getId");
        CaseType instance = new CaseType();
        Long expResult = (long) 1;
        instance.setId(expResult);
        Long result = instance.getId();
        assertEquals(expResult, result);
    }

    /**
     * Test of getName method, of class CaseType.
     */
    @Test
    public void testGetName() {
        System.out.println("getName");
        CaseType instance = new CaseType();
        String expResult = "name";
        instance.setName(expResult);
        String result = instance.getName();
        assertEquals(expResult, result);
    }

    /**
     * Test of getDescription method, of class CaseType.
     */
    @Test
    public void testGetDescription() {
        System.out.println("getDescription");
        CaseType instance = new CaseType();
        String expResult = "desc";
        instance.setDescription(expResult);
        String result = instance.getDescription();
        assertEquals(expResult, result);
    }

    /**
     * Test of getStatus method, of class CaseType.
     */
    @Test
    public void testGetStatus() {
        System.out.println("getStatus");
        CaseType instance = new CaseType();
        int expResult = 1;
        instance.setStatus(expResult);
        int result = instance.getStatus();
        assertEquals(expResult, result);
    }
    
}
