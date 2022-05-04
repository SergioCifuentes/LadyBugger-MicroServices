/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package com.ladybugger.adminservice.payload.request;

import java.util.Set;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;


/**
 *
 * @author mario
 */
public class CaseTypeCreationRequestTest {
    
    public CaseTypeCreationRequestTest() {
    }

    /**
     * Test of getName method, of class CaseTypeCreationRequest.
     */
    @Test
    public void testGetName() {
        System.out.println("getName");
        CaseTypeCreationRequest instance = new CaseTypeCreationRequest();
        instance.setName("name");
        String expResult = "name";
        String result = instance.getName();
        assertEquals(expResult, result);
    }

    /**
     * Test of getDescription method, of class CaseTypeCreationRequest.
     */
    @Test
    public void testGetDescription() {
        System.out.println("getDescription");
        CaseTypeCreationRequest instance = new CaseTypeCreationRequest();
        instance.setDescription("description");
        String expResult = "description";
        String result = instance.getDescription();
        assertEquals(expResult, result);
    }

    /**
     * Test of getPhases method, of class CaseTypeCreationRequest.
     */
    @Test
    public void testGetPhases() {
        System.out.println("getPhases");
        CaseTypeCreationRequest instance = new CaseTypeCreationRequest();
        Set<String> expResult = Set.of();
        instance.setPhases(expResult);
        Set<String> result = instance.getPhases();
        assertEquals(expResult, result);
    }
    
}

