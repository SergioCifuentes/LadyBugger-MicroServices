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
import org.springframework.security.config.annotation.ObjectPostProcessor;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;

/**
 *
 * @author mario
 */
public class SecurityConfigTest {
    
    public SecurityConfigTest() {
    }

    /**
     * Test of configure method, of class SecurityConfig.
     */
    @Test
    public void testConfigureThrowError() {
        System.out.println("configure");
        HttpSecurity http = null;
        SecurityConfig instance = new SecurityConfig();
        try {
            instance.configure(http);
        } catch(Exception e) {
            assertTrue(e instanceof NullPointerException);
        }
    }
    
}
