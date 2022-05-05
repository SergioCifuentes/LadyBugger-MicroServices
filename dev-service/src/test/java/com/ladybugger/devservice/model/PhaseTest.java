/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package com.ladybugger.devservice.model;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeAll;

/**
 *
 * @author mario
 */
public class PhaseTest {
    
    public PhaseTest() {
    }
    
    @BeforeAll
    public static void setUpClass() {
        Phase phase = new Phase("name", 1, new CaseType());
    }

    /**
     * Test of getId method, of class Phase.
     */
    @Test
    public void testGetId() {
        System.out.println("getId");
        Phase instance = new Phase();
        Long expResult = (long) 1;
        instance.setId(expResult);
        Long result = instance.getId();
        assertEquals(expResult, result);
    }

    /**
     * Test of getName method, of class Phase.
     */
    @Test
    public void testGetName() {
        System.out.println("getName");
        Phase instance = new Phase();
        String expResult = "name";
        instance.setName(expResult);
        String result = instance.getName();
        assertEquals(expResult, result);
    }

    /**
     * Test of getNumber method, of class Phase.
     */
    @Test
    public void testGetNumber() {
        System.out.println("getNumber");
        Phase instance = new Phase();
        int expResult = 1;
        instance.setNumber(expResult);
        int result = instance.getNumber();
        assertEquals(expResult, result);
    }

    /**
     * Test of getCasetype method, of class Phase.
     */
    @Test
    public void testGetCasetype() {
        System.out.println("getCasetype");
        Phase instance = new Phase();
        CaseType expResult = new CaseType();
        instance.setCasetype(expResult);
        CaseType result = instance.getCasetype();
        assertEquals(expResult, result);
    }
    
}
