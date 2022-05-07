/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package com.ladybugger.authservice.entity;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;

/**
 *
 * @author mario
 */
public class RoleTest {
    
    public RoleTest() {
    }
    
    @Test
    public void setUpClass() {
        Role casetype = new Role(ERole.ROLE_USER);
        assertTrue(casetype instanceof Role);
    }

    /**
     * Test of getId method, of class Role.
     */
    @Test
    public void testGetId() {
        System.out.println("getId");
        Role instance = new Role();
        Integer expResult = 1;
        instance.setId(expResult);
        Integer result = instance.getId();
        assertEquals(expResult, result);
    }

    /**
     * Test of getName method, of class Role.
     */
    @Test
    public void testGetName() {
        System.out.println("getName");
        Role instance = new Role();
        ERole expResult = ERole.ROLE_ADMIN;
        instance.setName(expResult);
        ERole result = instance.getName();
        assertEquals(expResult, result);
    }
    
}
