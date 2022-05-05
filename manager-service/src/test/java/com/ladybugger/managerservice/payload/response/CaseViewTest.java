/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package com.ladybugger.managerservice.payload.response;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author mario
 */
public class CaseViewTest {
    
    private CaseView caseView;
    
    public CaseViewTest() {
    }
    
    @BeforeEach
    public void setUp() {
        caseView = new CaseView(null, null, null, null, null, 0, null, 0);
    }

    /**
     * Test of getId method, of class CaseView.
     */
    @Test
    public void testGetId() {
        System.out.println("getId");
        CaseView instance = caseView;
        long expResult = 1L;
        instance.setId(expResult);
        long result = instance.getId();
        assertEquals(expResult, result);
        Long l = 1l;
        instance.setId(l);
    }

    /**
     * Test of getPhases method, of class CaseView.
     */
    @Test
    public void testGetPhases() {
        System.out.println("getPhases");
        CaseView instance = caseView;
        List<PhaseView> expResult = new ArrayList<>();
        instance.setPhases(expResult);
        List<PhaseView> result = instance.getPhases();
        assertEquals(expResult, result);
    }

    /**
     * Test of getName method, of class CaseView.
     */
    @Test
    public void testGetName() {
        System.out.println("getName");
        CaseView instance = caseView;
        String expResult = "name";
        instance.setName(expResult);
        String result = instance.getName();
        assertEquals(expResult, result);
    }

    /**
     * Test of getStart_date method, of class CaseView.
     */
    @Test
    public void testGetStart_date() {
        System.out.println("getStart_date");
        CaseView instance = caseView;
        String expResult = "10-10-2022";
        instance.setStart_date(expResult);
        String result = instance.getStart_date();
        assertEquals(expResult, result);
    }

    /**
     * Test of getDue_date method, of class CaseView.
     */
    @Test
    public void testGetDue_date() {
        System.out.println("getDue_date");
        CaseView instance = caseView;
        String expResult = "10-10-2022";
        instance.setDue_date(expResult);
        String result = instance.getDue_date();
        assertEquals(expResult, result);
    }

    /**
     * Test of getDescription method, of class CaseView.
     */
    @Test
    public void testGetDescription() {
        System.out.println("getDescription");
        CaseView instance = caseView;
        String expResult = "desc";
        instance.setDescription(expResult);
        String result = instance.getDescription();
        assertEquals(expResult, result);
    }

    /**
     * Test of getStatus method, of class CaseView.
     */
    @Test
    public void testGetStatus() {
        System.out.println("getStatus");
        CaseView instance = caseView;
        int expResult = 1;
        instance.setStatus(expResult);
        int result = instance.getStatus();
        assertEquals(expResult, result);
    }

    /**
     * Test of getActual method, of class CaseView.
     */
    @Test
    public void testGetActual() {
        System.out.println("getActual");
        CaseView instance = caseView;
        int expResult = 1;
        instance.setActual(expResult);
        int result = instance.getActual();
        assertEquals(expResult, result);
    }
    
}
