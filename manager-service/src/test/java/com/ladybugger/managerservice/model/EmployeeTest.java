/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package com.ladybugger.managerservice.model;

import java.sql.Date;
import java.time.LocalDate;
import java.util.Set;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeAll;

/**
 *
 * @author mario
 */
public class EmployeeTest {
    
    public EmployeeTest() {
    }
    
    @BeforeAll
    public static void setUpClass() {
        Employee employee = new Employee("email", "pass");
        employee = new Employee("email", "pass", "name", "middle", "last", Date.valueOf(LocalDate.now()), 1);
    }

    /**
     * Test of getStartDate method, of class Employee.
     */
    @Test
    public void testGetStartDate() {
        System.out.println("getStartDate");
        Employee instance = new Employee();
        Date expResult = Date.valueOf(LocalDate.now());
        instance.setStartDate(expResult);
        Date result = instance.getStartDate();
        assertEquals(expResult, result);
    }

    /**
     * Test of getStatus method, of class Employee.
     */
    @Test
    public void testGetStatus() {
        System.out.println("getStatus");
        Employee instance = new Employee();
        int expResult = 1;
        instance.setStatus(expResult);
        int result = instance.getStatus();
        assertEquals(expResult, result);
    }

    /**
     * Test of getPhases method, of class Employee.
     */
    @Test
    public void testGetPhases() {
        System.out.println("getPhases");
        Employee instance = new Employee();
        Set<PhaseAssignment> expResult = Set.of();
        instance.setPhases(expResult);
        Set<PhaseAssignment> result = instance.getPhases();
        assertEquals(expResult, result);
    }

    /**
     * Test of getRoles method, of class Employee.
     */
    @Test
    public void testGetRoles() {
        System.out.println("getRoles");
        Employee instance = new Employee();
        Set<Role> expResult = Set.of();
        instance.setRoles(expResult);
        Set<Role> result = instance.getRoles();
        assertEquals(expResult, result);
    }

    /**
     * Test of getProjects method, of class Employee.
     */
    @Test
    public void testGetProjects() {
        System.out.println("getProjects");
        Employee instance = new Employee();
        Set<PMAssignment> expResult = Set.of();
        instance.setProjects(expResult);
        Set<PMAssignment> result = instance.getProjects();
        assertEquals(expResult, result);
    }

    /**
     * Test of getPassword method, of class Employee.
     */
    @Test
    public void testGetPassword() {
        System.out.println("getPassword");
        Employee instance = new Employee();
        String expResult = "pass";
        instance.setPassword(expResult);
        String result = instance.getPassword();
        assertEquals(expResult, result);
    }

    /**
     * Test of getMiddleName method, of class Employee.
     */
    @Test
    public void testGetMiddleName() {
        System.out.println("getMiddleName");
        Employee instance = new Employee();
        String expResult = "middle";
        instance.setMiddleName(expResult);
        String result = instance.getMiddleName();
        assertEquals(expResult, result);
    }

    /**
     * Test of getId method, of class Employee.
     */
    @Test
    public void testGetId() {
        System.out.println("getId");
        Employee instance = new Employee();
        Long expResult = (long) 1;
        instance.setId(expResult);
        Long result = instance.getId();
        assertEquals(expResult, result);
    }

    /**
     * Test of getName method, of class Employee.
     */
    @Test
    public void testGetName() {
        System.out.println("getName");
        Employee instance = new Employee();
        String expResult = "name";
        instance.setName(expResult);
        String result = instance.getName();
        assertEquals(expResult, result);
    }

    /**
     * Test of getLastName method, of class Employee.
     */
    @Test
    public void testGetLastName() {
        System.out.println("getLastName");
        Employee instance = new Employee();
        String expResult = "last";
        instance.setLastName(expResult);
        String result = instance.getLastName();
        assertEquals(expResult, result);
    }

    /**
     * Test of getEmail method, of class Employee.
     */
    @Test
    public void testGetEmail() {
        System.out.println("getEmail");
        Employee instance = new Employee();
        String expResult = "email@gmail.com";
        instance.setEmail(expResult);
        String result = instance.getEmail();
        assertEquals(expResult, result);
    }
    
}
