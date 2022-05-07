/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package com.ladybugger.devservice.payload.response;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


/**
 *
 * @author mario
 */
public class ProfileResponseTest {
    
    private ProfileResponse profileResponse;
    
    public ProfileResponseTest() {
    }
    
    @BeforeEach
    public void setUp() {
        profileResponse = new ProfileResponse(null, null, null, null, null, 0, null, 0);
    }

    /**
     * Test of getStart_date method, of class ProfileResponse.
     */
    @Test
    public void testGetStart_date() {
        System.out.println("getStart_date");
        String expResult = "10-10-2022";
        profileResponse.setStart_date(expResult);
        String result = profileResponse.getStart_date();
        assertEquals(expResult, result);
    }

    /**
     * Test of getPhases_worked_on method, of class ProfileResponse.
     */
    @Test
    public void testGetPhases_worked_on() {
        System.out.println("getPhases_worked_on");
        int expResult = 0;
        profileResponse.setPhases_worked_on(expResult);
        int result = profileResponse.getPhases_worked_on();
        assertEquals(expResult, result);
    }

    /**
     * Test of getId method, of class ProfileResponse.
     */
    @Test
    public void testGetId() {
        System.out.println("getId");
        Long expResult = 1l;
        profileResponse.setId(expResult);
        Long result = profileResponse.getId();
        assertEquals(expResult, result);
    }

    /**
     * Test of getName method, of class ProfileResponse.
     */
    @Test
    public void testGetName() {
        System.out.println("getName");
        String expResult = "name";
        profileResponse.setName(expResult);
        String result = profileResponse.getName();
        assertEquals(expResult, result);
    }

    /**
     * Test of getLast_name method, of class ProfileResponse.
     */
    @Test
    public void testGetLast_name() {
        System.out.println("getLast_name");
        String expResult = "last name";
        profileResponse.setLast_name(expResult);
        String result = profileResponse.getLast_name();
        assertEquals(expResult, result);
    }

    /**
     * Test of getMiddle_name method, of class ProfileResponse.
     */
    @Test
    public void testGetMiddle_name() {
        System.out.println("getMiddle_name");
        String expResult = "middle";
        profileResponse.setMiddle_name(expResult);
        String result = profileResponse.getMiddle_name();
        assertEquals(expResult, result);
    }

    /**
     * Test of getEmail method, of class ProfileResponse.
     */
    @Test
    public void testGetEmail() {
        System.out.println("getEmail");
        String expResult = "email@gmail.com";
        profileResponse.setEmail(expResult);
        String result = profileResponse.getEmail();
        assertEquals(expResult, result);
    }

    /**
     * Test of getStatus method, of class ProfileResponse.
     */
    @Test
    public void testGetStatus() {
        System.out.println("getStatus");
        int expResult = 1;
        profileResponse.setStatus(expResult);
        int result = profileResponse.getStatus();
        assertEquals(expResult, result);
    }
    
}
