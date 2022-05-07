/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package com.ladybugger.adminservice.service;

import com.ladybugger.adminservice.exception.LogicalError;
import com.ladybugger.adminservice.model.Employee;
import com.ladybugger.adminservice.repository.EmployeeRepository;
import java.util.Optional;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

/**
 *
 * @author mario
 */
public class EmployeeServiceTest {
    
    @Mock
    private EmployeeRepository employeeRepository;
    @InjectMocks
    private EmployeeService employeeService;
    
    public EmployeeServiceTest() {
    }
    
    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    /**
     * Test of deleteEmployee method, of class EmployeeService.
     */
    @Test
    public void testDeleteOtherEmployee() {
        System.out.println("deleteEmployee");
        Long userId = 1l;
        Long userToDelete = 2l;
        Employee toChange = new Employee();
        toChange.setId(userId);
        Optional<Employee> optToChange= Optional.of(toChange);
        Mockito.when(employeeRepository.findById(userId)).thenReturn(optToChange);
        Employee toDelete = new Employee();
        Optional<Employee> optToDelete= Optional.of(toDelete);
        Mockito.when(employeeRepository.findById(userToDelete)).thenReturn(optToDelete);
        Employee expResult = new Employee();
        Mockito.when(employeeRepository.save(toDelete)).thenReturn(expResult);
        Employee result = employeeService.deleteEmployee(userId, userToDelete);
        assertEquals(expResult, result);
    }
    
    /**
     * Test of deleteEmployee method, of class EmployeeService.
     */
    @Test
    public void testDeleteYourself() {
        System.out.println("deleteEmployee");
        Long userId = 1l;
        Long userToDelete = 1l;
        Employee toChange = new Employee();
        toChange.setId(userId);
        Optional<Employee> optToChange= Optional.of(toChange);
        Mockito.when(employeeRepository.findById(userId)).thenReturn(optToChange);
        try {
            employeeService.deleteEmployee(userId, userToDelete);
        } catch (LogicalError e) {
            assertEquals("You can't delete yourself", e.getMessage());
        }
    }
    
}
