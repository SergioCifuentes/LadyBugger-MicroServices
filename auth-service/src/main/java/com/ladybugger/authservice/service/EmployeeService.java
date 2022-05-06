/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ladybugger.authservice.service;

import com.ladybugger.authservice.dto.AuthUserDto;
import com.ladybugger.authservice.dto.NewUserDto;
import com.ladybugger.authservice.dto.RequestDto;
import com.ladybugger.authservice.dto.TokenDto;
import com.ladybugger.authservice.entity.ERole;
import com.ladybugger.authservice.entity.Employee;
import com.ladybugger.authservice.entity.Role;
import com.ladybugger.authservice.repository.EmployeeRepository;
import com.ladybugger.authservice.repository.RoleRepository;
import com.ladybugger.authservice.security.JwtProvider;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import java.util.Set;

/**
 *
 * @author sergio
 */
@Service
public class EmployeeService {

    @Autowired
    EmployeeRepository employeeRepository;

    @Autowired
    RoleRepository roleRepository;

    @Autowired
    PasswordEncoder passwordEncoder;

    @Autowired
    JwtProvider jwtProvider;

    public Employee save(NewUserDto dto) {
        Optional<Employee> user = employeeRepository.findByEmail(dto.getEmail());
        if (user.isPresent()) {
            return null;
        }
        String password = passwordEncoder.encode(dto.getPassword());
        Employee employee = new Employee(dto.getEmail(),
                password,
                dto.getName(),
                dto.getMiddleName(),
                dto.getLastName(),
                java.sql.Date.valueOf(LocalDate.now()), 1,
                dto.getRole());
        Set<Role> roles = new HashSet<>();
        if (dto.getRole().equals("ADMIN")) {
            Role adminRole = roleRepository.findByName(ERole.ROLE_ADMIN)
                    .orElseThrow(() -> new RuntimeException("Error: Role is not found."));
            roles.add(adminRole);
            Role userRole = roleRepository.findByName(ERole.ROLE_USER)
                    .orElseThrow(() -> new RuntimeException("Error: Role is not found."));
            roles.add(userRole);
        } else {
            Role userRole = roleRepository.findByName(ERole.ROLE_USER)
                    .orElseThrow(() -> new RuntimeException("Error: Role is not found."));
            roles.add(userRole);

        }
        employee.setRoles(roles);

        return employeeRepository.save(employee);
    }

    public TokenDto login(AuthUserDto dto) {
        Optional<Employee> user = employeeRepository.findByEmail(dto.getEmail());
        if (!user.isPresent()) {
            return null;
        }
        if (passwordEncoder.matches(dto.getPassword(), user.get().getPassword())) {
            return new TokenDto(jwtProvider.createToken(user.get()), user.get().getId());
        }
        return null;
    }

    public TokenDto validate(String token, RequestDto dto) {
        if (!jwtProvider.validate(token, dto)) {
            return null;
        }
        String email = jwtProvider.getEmailFromToken(token);
        Optional<Employee> user = employeeRepository.findByEmail(email);
        if (!user.isPresent()) {
            return null;
        }
        return new TokenDto(token, user.get().getId());
    }
}
