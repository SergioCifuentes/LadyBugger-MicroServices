/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package com.ladybugger.managerservice.exceptions;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author mario
 */
public class EmployeeNotFoundTest {
    
    public EmployeeNotFoundTest() {
    }

    @Test
    public void testConstructor() {
        EmployeeNotFound pnf = new EmployeeNotFound("exception");
        assertEquals(pnf.getMessage(), "exception");
        assertTrue(pnf instanceof RuntimeException);
    }
    
}
