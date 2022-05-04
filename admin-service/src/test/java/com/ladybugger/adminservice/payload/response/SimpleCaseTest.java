/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package com.ladybugger.adminservice.payload.response;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author mario
 */
public class SimpleCaseTest {
    
    private SimpleCase simpleCase;
    
    public SimpleCaseTest() {
    }
    
    @BeforeEach
    public void setUp() {
        simpleCase = new SimpleCase(null, null, null);
    }

    /**
     * Test of getId method, of class SimpleCase.
     */
    @Test
    public void testGetId() {
        System.out.println("getId");
        SimpleCase instance = simpleCase;
        Long expResult = (long) 1;
        instance.setId(expResult);
        Long result = instance.getId();
        assertEquals(expResult, result);
    }

    /**
     * Test of getName method, of class SimpleCase.
     */
    @Test
    public void testGetName() {
        System.out.println("getName");
        SimpleCase instance = simpleCase;
        String expResult = "name";
        instance.setName(expResult);
        String result = instance.getName();
        assertEquals(expResult, result);
    }

    /**
     * Test of getDescription method, of class SimpleCase.
     */
    @Test
    public void testGetDescription() {
        System.out.println("getDescription");
        SimpleCase instance = simpleCase;
        String expResult = "desc";
        instance.setDescription(expResult);
        String result = instance.getDescription();
        assertEquals(expResult, result);
    }
    
}
