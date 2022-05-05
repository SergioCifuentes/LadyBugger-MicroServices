/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package com.ladybugger.managerservice.payload.response;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author mario
 */
public class PhaseViewTest {
    
    private PhaseView phaseView;
    
    public PhaseViewTest() {
    }
    
    @BeforeEach
    public void setUp() {
        phaseView = new PhaseView(null, null, null, 0, 0, null, null);
    }

    /**
     * Test of getId method, of class PhaseView.
     */
    @Test
    public void testGetId() {
        System.out.println("getId");
        PhaseView instance = phaseView;
        Long expResult = 1l;
        instance.setId(expResult);
        Long result = instance.getId();
        assertEquals(expResult, result);
    }

    /**
     * Test of getDeveloper method, of class PhaseView.
     */
    @Test
    public void testGetDeveloper() {
        System.out.println("getDeveloper");
        PhaseView instance = phaseView;
        String expResult = "dev";
        instance.setDeveloper(expResult);
        String result = instance.getDeveloper();
        assertEquals(expResult, result);
    }

    /**
     * Test of getUser_id method, of class PhaseView.
     */
    @Test
    public void testGetUser_id() {
        System.out.println("getUser_id");
        PhaseView instance = phaseView;
        Long expResult = 1l;
        instance.setUser_id(expResult);
        Long result = instance.getUser_id();
        assertEquals(expResult, result);
    }

    /**
     * Test of getNumber method, of class PhaseView.
     */
    @Test
    public void testGetNumber() {
        System.out.println("getNumber");
        PhaseView instance = phaseView;
        int expResult = 1;
        instance.setNumber(expResult);
        int result = instance.getNumber();
        assertEquals(expResult, result);
    }

    /**
     * Test of getStatus method, of class PhaseView.
     */
    @Test
    public void testGetStatus() {
        System.out.println("getStatus");
        PhaseView instance = phaseView;
        int expResult = 1;
        instance.setStatus(expResult);
        int result = instance.getStatus();
        assertEquals(expResult, result);
    }

    /**
     * Test of getStart_date method, of class PhaseView.
     */
    @Test
    public void testGetStart_date() {
        System.out.println("getStart_date");
        PhaseView instance = phaseView;
        String expResult = "10-10-2022";
        instance.setStart_date(expResult);
        String result = instance.getStart_date();
        assertEquals(expResult, result);
    }

    /**
     * Test of getDue_date method, of class PhaseView.
     */
    @Test
    public void testGetDue_date() {
        System.out.println("getDue_date");
        PhaseView instance = phaseView;
        String expResult = "10-10-2022";
        instance.setDue_date(expResult);
        String result = instance.getDue_date();
        assertEquals(expResult, result);
    }
    
}
