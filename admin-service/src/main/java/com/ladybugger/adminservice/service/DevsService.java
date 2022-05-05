/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ladybugger.adminservice.service;

import com.ladybugger.adminservice.model.Employee;
import com.ladybugger.adminservice.model.PMAssignment;
import com.ladybugger.adminservice.model.Project;
import com.ladybugger.adminservice.model.Role;
import com.ladybugger.adminservice.payload.request.PMAssignmentRequest;
import com.ladybugger.adminservice.payload.response.EmployeeResponse;
import com.ladybugger.adminservice.repository.EmployeeRepository;
import com.ladybugger.adminservice.repository.PMAssignmentRepository;
import com.ladybugger.adminservice.repository.ProjectRepository;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

/**
 *
 * @author mario
 */
@Service
public class DevsService {
    
    @Autowired
    EmployeeRepository userRepository;
    @Autowired
    ProjectRepository projectRepository;
    @Autowired
    PMAssignmentRepository pmAssignmentRepository;
    
    public List<Object[]> getDevsByRole() {
        System.out.println("Hola");
        return userRepository.findByDevRole();
    }
    
    public String assignProject(PMAssignmentRequest pmAssignmentRequest) {
        Project pr = projectRepository.findById((long) pmAssignmentRequest.getProjectId())
                .orElseThrow(() -> new RuntimeException("Error: Project not found"));

        Employee dev = userRepository.findById((long) pmAssignmentRequest.getEmployeeId())
                .orElseThrow(() -> new RuntimeException("Error: Dev not found"));
        java.sql.Timestamp timestamp1 = new java.sql.Timestamp(System.currentTimeMillis());
        PMAssignment pma = new PMAssignment(dev,
                pr,
                timestamp1);
        pmAssignmentRepository.save(pma);
        return "Project Manager Asignado";
    }
    
    public List<EmployeeResponse> getUsers(Pageable pageable) {
        Page<Employee> employees = userRepository.findAll(pageable);
        List<EmployeeResponse> employeeResponse = new ArrayList<EmployeeResponse>();
        for (Employee employee : employees) {

            List<Role> roles = new ArrayList<>(employee.getRoles());
            String role = getRole(roles.size());
            employeeResponse.add(new EmployeeResponse(employee.getId(),
                    employee.getName() + " " + employee.getLastName(),
                    employee.getEmail(),
                    role,
                    employee.getStatus(),
                    employee.getStartDate().toString()));

        }
        return employeeResponse;
    }
    
    private String getRole(int size) {
        return size == 2 ? "ROLE_ADMIN" : "ROLE_USER";
    }
    
}
