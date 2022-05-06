/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ladybugger.adminservice.service;

import com.ladybugger.adminservice.exception.EmployeeNotFound;
import com.ladybugger.adminservice.exception.LogicalError;
import com.ladybugger.adminservice.model.Employee;
import com.ladybugger.adminservice.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author sergio
 */
@Service
public class EmployeeService {
    
        @Autowired
    EmployeeRepository employeeRepository;
    
    public Employee deleteEmployee(Long userId,Long userToDelete){
        Employee em = employeeRepository.findById(userId)
                .orElseThrow(() -> new EmployeeNotFound("Error: Employee not found"));

        if (em.getId().equals(userToDelete)) {
            throw new LogicalError("You can't delete yourself");
            
        }
        Employee employee = employeeRepository.findById(userToDelete)
                .orElseThrow(() -> new EmployeeNotFound("Employee not found for this id :: " + userToDelete));
        employee.setStatus(2);
        final Employee updatedEmployee = employeeRepository.save(employee);
        return updatedEmployee;
    }
    
}
