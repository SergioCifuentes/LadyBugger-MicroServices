package com.ladybugger.authservice.controller;

import com.ladybugger.authservice.dto.AuthUserDto;
import com.ladybugger.authservice.dto.NewUserDto;
import com.ladybugger.authservice.dto.RequestDto;
import com.ladybugger.authservice.dto.TokenDto;
import com.ladybugger.authservice.entity.Employee;
import com.ladybugger.authservice.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class AuthUserController {

    @Autowired
    EmployeeService employeeService;

    @PostMapping("/login")
    public ResponseEntity<TokenDto> login(@RequestBody AuthUserDto dto){
        TokenDto tokenDto = employeeService.login(dto);
        if(tokenDto == null)
            return ResponseEntity.badRequest().build();
        return ResponseEntity.ok(tokenDto);
    }

    @PostMapping("/validate")
    public ResponseEntity<TokenDto> validate(@RequestParam String token, @RequestBody RequestDto dto){
        TokenDto tokenDto = employeeService.validate(token, dto);
        if(tokenDto == null)
            return ResponseEntity.badRequest().build();
        return ResponseEntity.ok(tokenDto);
    }

    @PostMapping("/create-user")
    public ResponseEntity<Employee> create(@RequestBody NewUserDto dto){
        Employee employee = employeeService.save(dto);
        if(employee == null)
            return ResponseEntity.badRequest().build();
        
        return ResponseEntity.ok(employee);
    }
}
