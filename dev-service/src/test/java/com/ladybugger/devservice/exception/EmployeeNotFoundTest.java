/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package com.ladybugger.devservice.exception;

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
public class EmployeeNotFoundTest {
    
    public EmployeeNotFoundTest() {
    }

    @Test
    public void testSomeMethod() {
        EmployeeNotFound pnf = new EmployeeNotFound("exception");
        assertEquals(pnf.getMessage(), "exception");
        assertTrue(pnf instanceof RuntimeException);
    }
    
}
