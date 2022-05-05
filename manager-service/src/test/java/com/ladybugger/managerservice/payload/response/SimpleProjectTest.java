/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package com.ladybugger.managerservice.payload.response;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author mario
 */
public class SimpleProjectTest {
    
    private SimpleProject simpleP;
    
    public SimpleProjectTest() {
    }
    
    @BeforeEach
    public void setUp() {
        simpleP = new SimpleProject(null, null, null, null, 0);
    }

    /**
     * Test of getId method, of class SimpleProject.
     */
    @Test
    public void testGetId() {
        System.out.println("getId");
        SimpleProject instance = simpleP;
        Long expResult = 1l;
        instance.setId(expResult);
        Long result = instance.getId();
        assertEquals(expResult, result);
    }

    /**
     * Test of getPm_name method, of class SimpleProject.
     */
    @Test
    public void testGetPm_name() {
        System.out.println("getPm_name");
        SimpleProject instance = simpleP;
        String expResult = "10-10-208";
        instance.setPm_name(expResult);
        String result = instance.getPm_name();
        assertEquals(expResult, result);
    }

    /**
     * Test of getName method, of class SimpleProject.
     */
    @Test
    public void testGetName() {
        System.out.println("getName");
        SimpleProject instance = simpleP;
        String expResult = "name";
        instance.setName(expResult);
        String result = instance.getName();
        assertEquals(expResult, result);
    }

    /**
     * Test of getDue_date method, of class SimpleProject.
     */
    @Test
    public void testGetDue_date() {
        System.out.println("getDue_date");
        SimpleProject instance = simpleP;
        String expResult = "10-10-2022";
        instance.setDue_date(expResult);
        String result = instance.getDue_date();
        assertEquals(expResult, result);
    }

    /**
     * Test of getStatus method, of class SimpleProject.
     */
    @Test
    public void testGetStatus() {
        System.out.println("getStatus");
        SimpleProject instance = simpleP;
        int expResult = 1;
        instance.setStatus(expResult);
        int result = instance.getStatus();
        assertEquals(expResult, result);
    }
    
}
