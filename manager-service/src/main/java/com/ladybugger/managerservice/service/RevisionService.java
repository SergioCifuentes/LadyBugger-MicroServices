/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ladybugger.managerservice.service;

import com.ladybugger.managerservice.exceptions.EmployeeNotFound;
import com.ladybugger.managerservice.exceptions.LogicalError;
import com.ladybugger.managerservice.model.Employee;
import com.ladybugger.managerservice.model.PMAssignment;
import com.ladybugger.managerservice.model.Revision;
import com.ladybugger.managerservice.model.Submission;
import com.ladybugger.managerservice.payload.request.RevisionCreationRequest;
import com.ladybugger.managerservice.repository.EmployeeRepository;
import com.ladybugger.managerservice.repository.PMAssignmentRepository;
import com.ladybugger.managerservice.repository.RevisionRepository;
import com.ladybugger.managerservice.repository.SubmissionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author sergio
 */
@Service
public class RevisionService {
    @Autowired
    EmployeeRepository employeeRepository;
    @Autowired
    PMAssignmentRepository pmaRepository;
    @Autowired
    SubmissionRepository submissionRepository;
    @Autowired
    RevisionRepository revisionRepository;
    
    
    public String createRevision(Long userId, RevisionCreationRequest revisionCreationRequest){
        Employee em = employeeRepository.findById(userId)
                .orElseThrow(() -> new EmployeeNotFound("Error: Employee not found"));
        Submission submission = submissionRepository.findById((long) revisionCreationRequest.getSubmissionId())
                .orElseThrow(() -> new EmployeeNotFound("Error: Submission not found"));
        PMAssignment pma = pmaRepository
                .findLastManager(submission.getPhaseAssignment().getCaseM().getProject().getId());
        if (!pma.getEmployee().getId().equals(em.getId())) {
            throw new LogicalError("You are not the Project's Manager");
        }

        Revision revision = new Revision(revisionCreationRequest.isAccepted(),
                submission,
                revisionCreationRequest.getDate(),
                revisionCreationRequest.getRejectReason());

        revisionRepository.save(revision);
        return "{\"id\": \"" + revision.getId() + "\"}";
        
    }
}
