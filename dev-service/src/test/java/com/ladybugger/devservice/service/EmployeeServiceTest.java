/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package com.ladybugger.devservice.service;

import com.ladybugger.devservice.exception.LogicalError;
import com.ladybugger.devservice.model.Employee;
import com.ladybugger.devservice.payload.response.ProfileResponse;
import com.ladybugger.devservice.repository.EmployeeRepository;
import java.sql.Date;
import java.time.LocalDate;
import java.util.Optional;
import java.util.Set;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.function.Executable;
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
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    /**
     * Test of getProfile method, of class EmployeeService.
     */
    @Test
    public void testGetProfile() {
        System.out.println("getProfile");
        String id = "1";
        Employee emp = new Employee("email", "password", "name", "middle", "last", Date.valueOf(LocalDate.now()), 0);
        emp.setPhases(Set.of());
        Optional<Employee> optEmp = Optional.of(emp);
        Mockito.when(employeeRepository.findById(Mockito.anyLong())).thenReturn(optEmp);
        ProfileResponse result = employeeService.getProfile(id);
        assertNotNull(result);
    }

    /**
     * Test of getProfile method, of class EmployeeService.
     */
    @Test
    public void testGetProfileAndIdIsNotLong() {
        System.out.println("getProfile");
        String id = "error";
        Employee emp = new Employee("email", "password", "name", "middle", "last", Date.valueOf(LocalDate.now()), 0);
        Optional<Employee> optEmp = Optional.of(emp);
        Mockito.when(employeeRepository.findById(Mockito.anyLong())).thenReturn(optEmp);
        LogicalError assertThrows = assertThrows(LogicalError.class, () -> {
            employeeService.getProfile(id);
        });
        assertEquals("Wrong id", assertThrows.getMessage());
    }
    
}
