/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ladybugger.authservice.service;

import com.ladybugger.authservice.dto.AuthUserDto;
import com.ladybugger.authservice.dto.NewUserDto;
import com.ladybugger.authservice.dto.RequestDto;
import com.ladybugger.authservice.dto.TokenDto;
import com.ladybugger.authservice.entity.Employee;
import com.ladybugger.authservice.repository.EmployeeRepository;
import com.ladybugger.authservice.security.JwtProvider;
import java.time.LocalDate;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

/**
 *
 * @author sergio
 */
@Service
public class EmployeeService {
    @Autowired
    EmployeeRepository employeeRepository;

    @Autowired
    PasswordEncoder passwordEncoder;

    @Autowired
    JwtProvider jwtProvider;

    public Employee save(NewUserDto dto) {
        Optional<Employee> user =  employeeRepository.findByEmail(dto.getEmail());
        if(user.isPresent())
            return null;
        String password = passwordEncoder.encode(dto.getPassword());
        Employee employee = new Employee(dto.getEmail(),
							 password,
							 dto.getName(),
							 dto.getMiddleName(),
							 dto.getLastName(),							
							 java.sql.Date.valueOf(LocalDate.now()),1,
                                                        dto.getRole());
        return employeeRepository.save(employee);
    }

    public TokenDto login(AuthUserDto dto) {
        Optional<Employee> user = employeeRepository.findByEmail(dto.getEmail());
        System.out.println("hola");
        if(!user.isPresent())
            return null;
        System.out.println("\nEmail");
        if(passwordEncoder.matches(dto.getPassword(), user.get().getPassword()))
            return new TokenDto(jwtProvider.createToken(user.get()),user.get().getId());
        System.out.println("Password");
        return null;
    }

    public TokenDto validate(String token, RequestDto dto) {
        System.out.println("entra");
        if(!jwtProvider.validate(token, dto))
            return null;
        System.out.println("1");
        String email = jwtProvider.getEmailFromToken(token);
        Optional<Employee> user=employeeRepository.findByEmail(email);
        if(!user.isPresent())
            return null;
        System.out.println("2");
        return new TokenDto(token,user.get().getId());
    }
}
