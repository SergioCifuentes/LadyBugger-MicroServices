/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
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
import java.util.Optional;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;

/**
 *
 * @author mario
 */
public class EmployeeServiceTest {
    
    @Mock
    private EmployeeRepository employeeRepository;

    @Mock
    private RoleRepository roleRepository;

    @Mock
    private PasswordEncoder passwordEncoder;

    @Mock
    private JwtProvider jwtProvider;
    
    @InjectMocks
    private EmployeeService employeeService;
    
    public EmployeeServiceTest() {
    }
    
    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    /**
     * Test of save method, of class EmployeeService.
     */
    @Test
    public void testSaveIfIspresent() {
        System.out.println("SaveIfIspresent");
        NewUserDto dto = new NewUserDto();
        dto.setEmail("email@gmail.com");
        Optional<Employee> optEmp = Optional.of(new Employee());
        Mockito.when(employeeRepository.findByEmail(dto.getEmail())).thenReturn(optEmp);
        Employee result = employeeService.save(dto);
        assertNull(result);
    }

    /**
     * Test of save method, of class EmployeeService.
     */
    @Test
    public void testSaveIfIsNotPresentAndRoleIsAdmin() {
        System.out.println("SaveIfIsNotPresentAndRoleIsAdmin");
        NewUserDto dto = new NewUserDto("email@gmail.com", "pass", "name", "middle", "last", "ADMIN");
        Optional<Employee> optEmp = Optional.empty();
        Mockito.when(employeeRepository.findByEmail(dto.getEmail())).thenReturn(optEmp);
        String pass = "pass";
        Mockito.when(passwordEncoder.encode(dto.getPassword())).thenReturn(pass);
        Optional<Role> optRole = Optional.of(new Role(ERole.ROLE_ADMIN));
        Mockito.when(roleRepository.findByName(ERole.ROLE_ADMIN)).thenReturn(optRole);
        Optional<Role> optRoleU = Optional.of(new Role(ERole.ROLE_USER));
        Mockito.when(roleRepository.findByName(ERole.ROLE_USER)).thenReturn(optRoleU);
        Employee expected = new Employee();
        Mockito.when(employeeRepository.save(Mockito.any(Employee.class))).thenReturn(expected);
        Employee result = employeeService.save(dto);
        assertEquals(expected, result);
    }

    /**
     * Test of save method, of class EmployeeService.
     */
    @Test
    public void testSaveIfIsNotPresentAndRoleIsNotAdmin() {
        System.out.println("SaveIfIsNotPresentAndRoleIsNotAdmin");
        NewUserDto dto = new NewUserDto("email@gmail.com", "pass", "name", "middle", "last", "DEV");
        Optional<Employee> optEmp = Optional.empty();
        Mockito.when(employeeRepository.findByEmail(dto.getEmail())).thenReturn(optEmp);
        String pass = "pass";
        Mockito.when(passwordEncoder.encode(dto.getPassword())).thenReturn(pass);
        Optional<Role> optRoleU = Optional.of(new Role(ERole.ROLE_USER));
        Mockito.when(roleRepository.findByName(ERole.ROLE_USER)).thenReturn(optRoleU);
        Employee expected = new Employee();
        Mockito.when(employeeRepository.save(Mockito.any(Employee.class))).thenReturn(expected);
        Employee result = employeeService.save(dto);
        assertEquals(expected, result);
    }

    /**
     * Test of login method, of class EmployeeService.
     */
    @Test
    public void testLoginIfNotExists() {
        System.out.println("login");
        AuthUserDto dto = new AuthUserDto("email", "pass");
        Optional<Employee> optEm = Optional.empty();
        Mockito.when(employeeRepository.findByEmail(dto.getEmail())).thenReturn(optEm);
        TokenDto result = employeeService.login(dto);
        assertNull(result);
    }

    /**
     * Test of login method, of class EmployeeService.
     */
    @Test
    public void testLoginIfNotMatch() {
        System.out.println("login");
        AuthUserDto dto = new AuthUserDto("email", "pass");
        Employee user = new Employee();
        user.setPassword("pass");
        Optional<Employee> optEm = Optional.of(user);
        Mockito.when(employeeRepository.findByEmail(dto.getEmail())).thenReturn(optEm);
        Mockito.when(passwordEncoder.matches(dto.getPassword(), optEm.get().getPassword())).thenReturn(false);
        TokenDto result = employeeService.login(dto);
        assertNull(result);
    }

    /**
     * Test of login method, of class EmployeeService.
     */
    @Test
    public void testLoginSuccess() {
        System.out.println("login");
        AuthUserDto dto = new AuthUserDto("email", "pass");
        Employee user = new Employee();
        user.setPassword("pass");
        user.setId(1l);
        Optional<Employee> optEm = Optional.of(user);
        Mockito.when(employeeRepository.findByEmail(dto.getEmail())).thenReturn(optEm);
        Mockito.when(passwordEncoder.matches(dto.getPassword(), optEm.get().getPassword())).thenReturn(true);
        String pass = "pass";
        Mockito.when(jwtProvider.createToken(optEm.get())).thenReturn(pass);
        TokenDto result = employeeService.login(dto);
        assertEquals(new TokenDto(pass, user.getId()),result);
    }

    /**
     * Test of validate method, of class EmployeeService.
     */
    @Test
    public void testValidateIsValidate() {
        System.out.println("validate");
        String token = "token";
        RequestDto dto = new RequestDto();
        Mockito.when(jwtProvider.validate(token, dto)).thenReturn(false);
        TokenDto result = employeeService.validate(token, dto);
        assertNull(result);
    }

    /**
     * Test of validate method, of class EmployeeService.
     */
    @Test
    public void testValidateIfUserIsNotPresent() {
        System.out.println("validate");
        String token = "token";
        RequestDto dto = new RequestDto();
        Mockito.when(jwtProvider.validate(token, dto)).thenReturn(true);
        String email = "email@gmail.com";
        Mockito.when(jwtProvider.getEmailFromToken(token)).thenReturn(email);
        Optional<Employee> optEmp = Optional.empty();
        Mockito.when(employeeRepository.findByEmail(email)).thenReturn(optEmp);
        TokenDto result = employeeService.validate(token, dto);
        assertNull(result);
    }

    /**
     * Test of validate method, of class EmployeeService.
     */
    @Test
    public void testValidateOk() {
        System.out.println("validate");
        String token = "token";
        RequestDto dto = new RequestDto();
        Mockito.when(jwtProvider.validate(token, dto)).thenReturn(true);
        String email = "email@gmail.com";
        Mockito.when(jwtProvider.getEmailFromToken(token)).thenReturn(email);
        Employee emp = new Employee();
        emp.setId(1l);
        Optional<Employee> optEmp = Optional.of(emp);
        Mockito.when(employeeRepository.findByEmail(email)).thenReturn(optEmp);
        TokenDto result = employeeService.validate(token, dto);
        assertEquals(new TokenDto(token, emp.getId()),result);
    }
    
}
