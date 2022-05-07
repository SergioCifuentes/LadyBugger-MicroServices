/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package com.ladybugger.authservice.security;

import com.ladybugger.authservice.dto.RequestDto;
import java.util.List;
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
public class RouteValidatorTest {
    
    public RouteValidatorTest() {
    }

    /**
     * Test of getPaths method, of class RouteValidator.
     */
    @Test
    public void testGetPaths() {
        System.out.println("getPaths");
        RouteValidator instance = new RouteValidator();
        List<RequestDto> expResult = List.of();
        instance.setPaths(expResult);
        List<RequestDto> result = instance.getPaths();
        assertEquals(expResult, result);
    }

    /**
     * Test of isAdminPath method, of class RouteValidator.
     */
    @Test
    public void testIsAdminPath() {
        System.out.println("isAdminPath");
        RequestDto dto = new RequestDto("uri", "method");
        RouteValidator instance = new RouteValidator();
        List<RequestDto> list = List.of();
        instance.setPaths(list);
        boolean result = instance.isAdminPath(dto);
        assertFalse(result);
    }
    
}
