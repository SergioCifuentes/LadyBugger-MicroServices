/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ladybugger.managerservice.service;

import com.ladybugger.managerservice.model.Case;
import com.ladybugger.managerservice.model.Employee;
import com.ladybugger.managerservice.model.PMAssignment;
import com.ladybugger.managerservice.model.Phase;
import com.ladybugger.managerservice.model.PhaseAssignment;
import com.ladybugger.managerservice.payload.request.PhaseAssignmentRequest;
import com.ladybugger.managerservice.payload.response.MessageResponse;
import com.ladybugger.managerservice.repository.CaseRepository;
import com.ladybugger.managerservice.repository.EmployeeRepository;
import com.ladybugger.managerservice.repository.PMAssignmentRepository;
import com.ladybugger.managerservice.repository.PhaseAssignmentRepository;
import com.ladybugger.managerservice.repository.PhaseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

/**
 *
 * @author sergio
 */
@Service
public class PhaseAssignmentService {
    @Autowired
    PhaseRepository phaseRepository;
    @Autowired
    CaseRepository caseRepository;
    @Autowired
    PMAssignmentRepository pmaRepository;
    @Autowired
    EmployeeRepository employeeRepository;
    @Autowired
    PhaseAssignmentRepository phaseAssignmentRepository;

    
    
    public String assignPhase(Long userId,PhaseAssignmentRequest assignmentRequest){
        Employee em = employeeRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("Error: Employee not found"));
        Phase phase = phaseRepository.findById((long) assignmentRequest.getPhaseId())
                .orElseThrow(() -> new RuntimeException("Error: Phase not found"));

        Case caseM = caseRepository.findById((long) assignmentRequest.getCaseId())
                .orElseThrow(() -> new RuntimeException("Error: Case not found"));
        PMAssignment pma = pmaRepository.findLastManager(caseM.getProject().getId());
        if (!pma.getEmployee().getId().equals(em.getId())) {
            return "Error: You are not the project manager";
        }
        Employee dev = employeeRepository.findById((long) assignmentRequest.getDevId())
                .orElseThrow(() -> new RuntimeException("Error: Dev not found"));
        PhaseAssignment phaseAssignment = new PhaseAssignment(dev,
                phase,
                caseM,
                assignmentRequest.getDescription(),
                1,
                assignmentRequest.getStartDate(),
                assignmentRequest.getDueDate());

        phaseAssignmentRepository.save(phaseAssignment);
        return "{\"id\": \"" +phaseAssignment.getId() + "\"}";
    }
}
