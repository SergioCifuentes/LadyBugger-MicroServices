/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package com.ladybugger.adminservice.exception;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

/**
 *
 * @author mario
 */
public class EmployeeNotFoundTest {
    
    public EmployeeNotFoundTest() {
    }

    @Test
    public void testConstructor() {
        String message = "Exception";
        EmployeeNotFound emp = new EmployeeNotFound(message);
        RuntimeException assertInstanceOf = assertInstanceOf(RuntimeException.class, emp);
        assertEquals(message, assertInstanceOf.getMessage());
    }
    
}
