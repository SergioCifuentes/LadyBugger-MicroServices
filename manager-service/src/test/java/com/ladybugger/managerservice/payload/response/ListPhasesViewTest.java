/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package com.ladybugger.managerservice.payload.response;

import java.util.ArrayList;
import java.util.List;
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
public class ListPhasesViewTest {
    
    private ListPhasesView listPhase;
    
    public ListPhasesViewTest() {
    }
    
    @BeforeEach
    public void setUp() {
        listPhase = new ListPhasesView(null, null, null, null);
    }

    /**
     * Test of getPhasesProcess method, of class ListPhasesView.
     */
    @Test
    public void testGetPhasesProcess() {
        System.out.println("getPhasesProcess");
        ListPhasesView instance = listPhase;
        List<PhaseView> expResult = new ArrayList<>();
        instance.setPhasesProcess(expResult);
        List<PhaseView> result = instance.getPhasesProcess();
        assertEquals(expResult, result);
    }

    /**
     * Test of getPhasesCanceled method, of class ListPhasesView.
     */
    @Test
    public void testGetPhasesCanceled() {
        System.out.println("getPhasesCanceled");
        ListPhasesView instance = listPhase;
        List<PhaseView> expResult = new ArrayList<>();
        instance.setPhasesCanceled(expResult);
        List<PhaseView> result = instance.getPhasesCanceled();
        assertEquals(expResult, result);
    }

    /**
     * Test of getPhasesFinished method, of class ListPhasesView.
     */
    @Test
    public void testGetPhasesFinished() {
        System.out.println("getPhasesFinished");
        ListPhasesView instance = listPhase;
        List<PhaseView> expResult = new ArrayList<>();
        instance.setPhasesFinished(expResult);
        List<PhaseView> result = instance.getPhasesFinished();
        assertEquals(expResult, result);
    }

    /**
     * Test of getPhasesToDo method, of class ListPhasesView.
     */
    @Test
    public void testGetPhasesToDo() {
        System.out.println("getPhasesToDo");
        ListPhasesView instance = listPhase;
        List<PhaseView> expResult = new ArrayList<>();
        instance.setPhasesToDo(expResult);
        List<PhaseView> result = instance.getPhasesToDo();
        assertEquals(expResult, result);
    }
    
}
