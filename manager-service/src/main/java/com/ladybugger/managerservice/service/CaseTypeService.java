/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ladybugger.managerservice.service;

import com.ladybugger.managerservice.model.Case;
import com.ladybugger.managerservice.model.CaseType;
import com.ladybugger.managerservice.model.Employee;
import com.ladybugger.managerservice.model.PMAssignment;
import com.ladybugger.managerservice.model.Project;
import com.ladybugger.managerservice.payload.request.CaseCreationRequest;
import com.ladybugger.managerservice.payload.response.MessageResponse;
import com.ladybugger.managerservice.repository.CaseRepository;
import com.ladybugger.managerservice.repository.CaseTypeRepository;
import com.ladybugger.managerservice.repository.EmployeeRepository;
import com.ladybugger.managerservice.repository.PMAssignmentRepository;
import com.ladybugger.managerservice.repository.ProjectRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

/**
 *
 * @author sergio
 */
@Service
public class CaseTypeService {
    @Autowired
    CaseTypeRepository caseTypeRepository;
    @Autowired
    CaseRepository caseRepository;
    @Autowired
    EmployeeRepository employeeRepository;
    @Autowired
    ProjectRepository projectRepository;
    @Autowired
    PMAssignmentRepository pmaRepository;
            
    public String registerCaseType(Long userId,CaseCreationRequest caseRequest){
        Employee em = employeeRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("Error: Employee not found"));

        Project pr = projectRepository.findById((long) caseRequest.getProjectId())
                .orElseThrow(() -> new RuntimeException("Error: Project not found"));
        PMAssignment pma = pmaRepository.findLastManager(pr.getId());
        if (!pma.getEmployee().getId().equals(em.getId())) {
            return "Error: You are not the project Manager";
        }

        CaseType ct = caseTypeRepository.findById((long) caseRequest.getCaseTypeId())
                .orElseThrow(() -> new RuntimeException("Error: CaseType not found"));
        Case newCase = new Case(caseRequest.getTitle(),
                caseRequest.getDescription(),
                ct,
                1,
                pr,
                caseRequest.getStartDate(),
                caseRequest.getDueDate(), 1);

        caseRepository.save(newCase);
        return "{\"id\": \"" + newCase.getId() + "\"}";
    } 
    
}
