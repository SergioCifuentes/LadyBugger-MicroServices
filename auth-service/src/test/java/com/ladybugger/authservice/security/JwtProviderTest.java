/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package com.ladybugger.authservice.security;

import com.ladybugger.authservice.dto.RequestDto;
import com.ladybugger.authservice.entity.Employee;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.JwtException;
import io.jsonwebtoken.JwtParser;
import io.jsonwebtoken.Jwts;
import java.sql.Date;
import java.time.LocalDate;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.test.web.servlet.MockMvc;

/**
 *
 * @author mario
 */
@AutoConfigureMockMvc
public class JwtProviderTest {
    
    @Mock
    private RouteValidator routeValidator;
    @Mock
    private JwtParser jwtParser;
    @InjectMocks
    private JwtProvider jwtProvider;

    
    public JwtProviderTest() {
    }
    
    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    /**
     * Test of init method, of class JwtProvider.
     */
    @Test
    public void testInit() {
        System.out.println("init");
        jwtProvider.init();
    }

    /**
     * Test of createToken method, of class JwtProvider.
     */
    @Test
    public void testCreateToken() throws Exception  {
        System.out.println("createToken");
        Employee employee = new Employee();
        employee.setEmail("email@gmail.com");
        employee.setId(1l);
        employee.setRole("ADMIN");
        String result = jwtProvider.createToken(employee);
        assertNotNull(result);
    }

    /**
     * Test of validate method, of class JwtProvider.
     */
    @Test
    public void testValidateAndThrowsError() {
        System.out.println("validate");
        String token = "Bearer";
        RequestDto dto = new RequestDto("uri", "method");
        Mockito.when(jwtParser.setSigningKey(Mockito.anyString())).thenReturn(jwtParser);
        Mockito.when(jwtParser.parseClaimsJws(token)).thenThrow(new JwtException("message"));
        boolean expResult = false;
        boolean result = jwtProvider.validate(token, dto);
        assertEquals(expResult, result);
    }

    /**
     * Test of validate method, of class JwtProvider.
     */
    @Test
    public void testValidateAndIsNotAdminInAdminPath() {
        System.out.println("validate");
        String token = jwtProvider.createToken(new Employee("email", "pass", "name", "middle", "last", Date.valueOf(LocalDate.now()), 0, "ADMIN"));
        RequestDto dto = new RequestDto("uri", "method");
        Mockito.when(routeValidator.isAdminPath(dto)).thenReturn(false);
        boolean expResult = true;
        boolean result = jwtProvider.validate(token, dto);
        assertEquals(expResult, result);
    }

    /**
     * Test of validate method, of class JwtProvider.
     */
    @Test
    public void testValidateAndIsAdminInAdminPath() {
        System.out.println("validate");
        String token = jwtProvider.createToken(new Employee("email", "pass", "name", "middle", "last", Date.valueOf(LocalDate.now()), 0, "DEV"));
        RequestDto dto = new RequestDto("uri", "method");
        Mockito.when(routeValidator.isAdminPath(dto)).thenReturn(true);
        boolean expResult = false;
        boolean result = jwtProvider.validate(token, dto);
        assertEquals(expResult, result);
    }

    /**
     * Test of getEmailFromToken method, of class JwtProvider.
     */
    @Test
    public void testGetEmailFromToken() {
        System.out.println("getEmailFromToken");
        String token = jwtProvider.createToken(new Employee("email", "pass", "name", "middle", "last", Date.valueOf(LocalDate.now()), 0, "ADMIN"));
        String expResult = "email";
        String result = jwtProvider.getEmailFromToken(token);
        assertEquals(expResult, result);
    }

    /**
     * Test of getEmailFromToken method, of class JwtProvider.
     */
    @Test
    public void testGetEmailFromTokenThrowError() {
        System.out.println("getEmailFromToken");
        String token = "token";
        String expResult = "bad token";
        String result = jwtProvider.getEmailFromToken(token);
        assertEquals(expResult, result);
    }
    
}
