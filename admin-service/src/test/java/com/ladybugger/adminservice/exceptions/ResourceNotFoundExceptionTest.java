/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package com.ladybugger.adminservice.exceptions;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author mario
 */
public class ResourceNotFoundExceptionTest {
    
    public ResourceNotFoundExceptionTest() {
    }
    
    @AfterAll
    public static void tearDownClass() {
    }

    @Test
    public void testConstructor() {
        // TODO review the generated test code and remove the default call to fail.
        String message = "message error";
        ResourceNotFoundException rnfe = new ResourceNotFoundException("message error");
        assertEquals(rnfe.getMessage(), message);
    }
    
}
