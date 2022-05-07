/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package com.ladybugger.authservice.entity;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author mario
 */
public class ERoleTest {
    
    public ERoleTest() {
    }

    /**
     * Test of values method, of class ERole.
     */
    @Test
    public void testValues() {
        System.out.println("values");
        ERole[] expResult = {ERole.ROLE_USER, ERole.ROLE_ADMIN};
        ERole[] result = ERole.values();
        assertArrayEquals(expResult, result);
    }

    /**
     * Test of valueOf method, of class ERole.
     */
    @Test
    public void testValueOf() {
        System.out.println("valueOf");
        String string = "ROLE_USER";
        ERole expResult = ERole.ROLE_USER;
        ERole result = ERole.valueOf(string);
        assertEquals(expResult, result);
    }
    
}
