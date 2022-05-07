/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package com.ladybugger.authservice.security;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

/**
 *
 * @author mario
 */
public class PasswordEncoderConfigTest {
    
    public PasswordEncoderConfigTest() {
    }

    /**
     * Test of passwordEncoder method, of class PasswordEncoderConfig.
     */
    @Test
    public void testPasswordEncoder() {
        System.out.println("passwordEncoder");
        PasswordEncoderConfig instance = new PasswordEncoderConfig();
        PasswordEncoder expResult = new BCryptPasswordEncoder();
        PasswordEncoder result = instance.passwordEncoder();
        assertEquals(expResult.getClass(), result.getClass());
    }
    
}
