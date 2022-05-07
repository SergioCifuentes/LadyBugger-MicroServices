/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ladybugger.devservice.service;

import com.ladybugger.devservice.exception.EmployeeNotFound;
import com.ladybugger.devservice.exception.LogicalError;
import com.ladybugger.devservice.model.Employee;
import com.ladybugger.devservice.model.PMAssignment;
import com.ladybugger.devservice.model.PhaseAssignment;
import com.ladybugger.devservice.payload.response.PhaseDevResponse;
import com.ladybugger.devservice.payload.response.PhaseResponse;
import com.ladybugger.devservice.repository.EmployeeRepository;
import com.ladybugger.devservice.repository.PMAssignmentRepository;
import com.ladybugger.devservice.repository.PhaseAssignmentRepository;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

/**
 *
 * @author sergio
 */
@Service
public class PhaseService {

    @Autowired
    PhaseAssignmentRepository phaseAssignmentRepository;
    @Autowired
    EmployeeRepository employeeRepository;
    @Autowired
    PMAssignmentRepository pmaRepository;

    public PhaseResponse getPhase(Long userId, String projectId) {
        Employee em = employeeRepository.findById(userId)
                .orElseThrow(() -> new EmployeeNotFound("Error: Employee not found"));

        long id_long;
        try {
            id_long = Long.parseLong(projectId);
        } catch (Exception e) {
            throw new LogicalError("Wrong id");
        }
        PhaseAssignment phaseAssignment = phaseAssignmentRepository.findById(id_long)
                .orElseThrow(() -> new RuntimeException("Error: Phase not found"));
        if (!phaseAssignment.getDev().getId().equals(em.getId())) {
            throw new LogicalError("Error: You are not the developer of this phase");

        }
        return new PhaseResponse(phaseAssignment.getPhase().getName(),
                phaseAssignment.getDev().getName() + " " + phaseAssignment.getDev().getLastName(),
                phaseAssignment.getStartDate().toString(),
                phaseAssignment.getDueDate().toString(),
                phaseAssignment.getCaseM().getProject().getId(),
                phaseAssignment.getCaseM().getProject().getName(),
                phaseAssignment.getCaseM().getId(),
                phaseAssignment.getCaseM().getTitle(),
                phaseAssignment.getCaseM().getDescription());
    }

    public List<PhaseDevResponse> getPhases(Long userId) {
        Employee em = employeeRepository.findById(userId)
                .orElseThrow(() -> new EmployeeNotFound("Error: Employee not found"));

        List<PhaseDevResponse> phasesResponse = new ArrayList<PhaseDevResponse>();
        List<PhaseAssignment> phaseAssignments = phaseAssignmentRepository.findPhasesByDev(em.getId());
        for (PhaseAssignment phaseAs : phaseAssignments) {
            phasesResponse.add(new PhaseDevResponse(phaseAs.getPhase().getId(),
                    phaseAs.getPhase().getName(),
                    phaseAs.getCaseM().getProject().getName(),
                    phaseAs.getCaseM().getTitle(),
                    em.getName() + " " + em.getLastName(),
                    phaseAs.getStartDate().toString(),
                    phaseAs.getDueDate().toString(),
                    phaseAs.getStatus()));
        }
        return phasesResponse;

    }

    public String getPhaseJob(Long userId, String phase_id) {
        Employee em = employeeRepository.findById(userId)
                .orElseThrow(() -> new EmployeeNotFound("Error: Employee not found"));
        long id_long;
        try {
            id_long = Long.parseLong(phase_id);
        } catch (Exception e) {
            return "Wrong id";
        }
        PhaseAssignment pa = phaseAssignmentRepository.findById(id_long)
                .orElseThrow(() -> new RuntimeException("Error: Phase Assignment not found"));;
        PMAssignment pma = pmaRepository.findLastManager(pa.getCaseM().getProject().getId());

        if (pma.getEmployee().getId().equals(em.getId())) {
            return "PM";
        } else if (pa.getDev().getId().equals(em.getId())) {
            return "DEV";
        } else {
            return "None";
        }
    }

}
