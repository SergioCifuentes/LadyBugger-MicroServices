/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ladybugger.devservice.service;

import com.ladybugger.devservice.exception.EmployeeNotFound;
import com.ladybugger.devservice.exception.LogicalError;
import com.ladybugger.devservice.exception.ProjectNotFound;
import com.ladybugger.devservice.model.Employee;
import com.ladybugger.devservice.model.PhaseAssignment;
import com.ladybugger.devservice.model.Submission;
import com.ladybugger.devservice.payload.request.SubmissionRequest;
import com.ladybugger.devservice.payload.response.MessageResponse;
import com.ladybugger.devservice.repository.EmployeeRepository;
import com.ladybugger.devservice.repository.PhaseAssignmentRepository;
import com.ladybugger.devservice.repository.SubmissionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

/**
 *
 * @author sergio
 */
@Service
public class SubmissionService {

    @Autowired
    EmployeeRepository employeeRepository;
    @Autowired
    PhaseAssignmentRepository phaseAssignmentRepository;
    @Autowired
    SubmissionRepository submissionRepository;

    public String createSubmission(Long userId, SubmissionRequest submissionRequest) {
        Employee em = employeeRepository.findById(userId)
                .orElseThrow(() -> new EmployeeNotFound("Error: Employee not found"));
        PhaseAssignment phaseA = phaseAssignmentRepository
                .findById((long) submissionRequest.getPhaseAssignmentId())
                .orElseThrow(() -> new ProjectNotFound("Error: Project not found"));
        if (!phaseA.getDev().getId().equals(em.getId())) {
            throw new LogicalError("Error: You are not the developer of this phase");
        }
        Submission submission = new Submission(phaseA,
                submissionRequest.getComment(),
                submissionRequest.getHours(),
                submissionRequest.getCost(),
                submissionRequest.getDate());

        submissionRepository.save(submission);
        return "{\"id\": \"" + submission.getId() + "\"}";
    }

}
