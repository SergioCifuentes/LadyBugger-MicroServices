/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package com.ladybugger.adminservice.payload.response;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;

/**
 *
 * @author mario
 */
public class EmployeeResponseTest {
    
    private EmployeeResponse emplyeeResponse;
    
    public EmployeeResponseTest() {
    }
    
    @BeforeEach
    void setUp() {
       emplyeeResponse = new EmployeeResponse(null, null, null, null, 0, null);
    }

    /**
     * Test of getId method, of class EmployeeResponse.
     */
    @Test
    public void testGetId() {
        System.out.println("getId");
        EmployeeResponse instance = emplyeeResponse;
        instance.setId((long) 1);
        Long expResult = (long) 1;
        Long result = instance.getId();
        assertEquals(expResult, result);
    }

    /**
     * Test of getFull_name method, of class EmployeeResponse.
     */
    @Test
    public void testGetFull_name() {
        System.out.println("getFull_name");
        EmployeeResponse instance = emplyeeResponse;
        instance.setFull_name("fullname");
        String expResult = "fullname";
        String result = instance.getFull_name();
        assertEquals(expResult, result);
    }

    /**
     * Test of getEmail method, of class EmployeeResponse.
     */
    @Test
    public void testGetEmail() {
        System.out.println("getEmail");
        EmployeeResponse instance = emplyeeResponse;
        instance.setEmail("email");
        String expResult = "email";
        String result = instance.getEmail();
        assertEquals(expResult, result);
    }

    /**
     * Test of getRoles method, of class EmployeeResponse.
     */
    @Test
    public void testGetRoles() {
        System.out.println("getRoles");
        EmployeeResponse instance = emplyeeResponse;
        instance.setRoles("roles");
        String expResult = "roles";
        String result = instance.getRoles();
        assertEquals(expResult, result);
    }

    /**
     * Test of getStatus method, of class EmployeeResponse.
     */
    @Test
    public void testGetStatus() {
        System.out.println("getStatus");
        EmployeeResponse instance = emplyeeResponse;
        instance.setStatus(1);
        int expResult = 1;
        int result = instance.getStatus();
        assertEquals(expResult, result);
    }

    /**
     * Test of getCreation_date method, of class EmployeeResponse.
     */
    @Test
    public void testGetCreation_date() {
        System.out.println("getCreation_date");
        EmployeeResponse instance = emplyeeResponse;
        instance.setCreation_date("10-10-2022");
        String expResult = "10-10-2022";
        String result = instance.getCreation_date();
        assertEquals(expResult, result);
    }
    
}
