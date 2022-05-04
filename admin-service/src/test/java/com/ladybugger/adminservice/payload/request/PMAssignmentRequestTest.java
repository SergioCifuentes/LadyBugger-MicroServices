/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package com.ladybugger.adminservice.payload.request;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;


/**
 *
 * @author mario
 */
public class PMAssignmentRequestTest {
    
    public PMAssignmentRequestTest() {
    }

    /**
     * Test of getProjectId method, of class PMAssignmentRequest.
     */
    @Test
    public void testGetProjectId() {
        System.out.println("getProjectId");
        PMAssignmentRequest instance = new PMAssignmentRequest();
        instance.setProjectId(1);
        int expResult = 1;
        int result = instance.getProjectId();
        assertEquals(expResult, result);
    }

    /**
     * Test of getEmployeeId method, of class PMAssignmentRequest.
     */
    @Test
    public void testGetEmployeeId() {
        System.out.println("getEmployeeId");
        PMAssignmentRequest instance = new PMAssignmentRequest();
        instance.setEmployeeId(1);
        int expResult = 1;
        int result = instance.getEmployeeId();
        assertEquals(expResult, result);
    }
    
}
