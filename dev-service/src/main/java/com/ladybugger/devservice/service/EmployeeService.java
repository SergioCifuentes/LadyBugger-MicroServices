/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ladybugger.devservice.service;

import com.ladybugger.devservice.exception.EmployeeNotFound;
import com.ladybugger.devservice.exception.LogicalError;
import com.ladybugger.devservice.model.Employee;
import com.ladybugger.devservice.payload.response.ProfileResponse;
import com.ladybugger.devservice.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

/**
 *
 * @author sergio
 */
@Service
public class EmployeeService {
    @Autowired
    EmployeeRepository employeeRepository;

    public ProfileResponse getProfile(String id) {
        
        long id_long;
        try {
            id_long = Long.parseLong(id);
        } catch (Exception e) {
            throw new LogicalError("Wrong id");
        }
        Employee em = employeeRepository.findById(id_long)
                                .orElseThrow(() -> new EmployeeNotFound("Error: Employee not found"));
        return new ProfileResponse(em.getId(),
                                em.getName(),
                                em.getLastName(),
                                em.getMiddleName(),
                                em.getEmail(),
                                1,
                                em.getStartDate().toString(),
                                em.getPhases().size());
        
    }

}
