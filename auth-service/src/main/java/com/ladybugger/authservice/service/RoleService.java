/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ladybugger.authservice.service;

import com.ladybugger.authservice.entity.Employee;
import com.ladybugger.authservice.entity.Role;
import java.util.HashSet;
import java.util.Set;
import org.springframework.stereotype.Service;

/**
 *
 * @author sergio
 */
@Service
public class RoleService {

    private static final String ADMIN = "ADMIN";
    private static final String USER = "USER";

    public void createRoles(Employee employee) {
        Set<Role> roles = new HashSet<>();
        if (employee.getRole().equals(ADMIN)) {

        } else {

        }

    }

}
