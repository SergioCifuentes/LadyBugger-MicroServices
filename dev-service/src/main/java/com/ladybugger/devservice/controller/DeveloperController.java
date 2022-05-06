package com.ladybugger.devservice.controller;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

import com.ladybugger.devservice.model.Employee;
import com.ladybugger.devservice.model.PhaseAssignment;
import com.ladybugger.devservice.model.Submission;
import com.ladybugger.devservice.payload.request.SubmissionRequest;
import com.ladybugger.devservice.payload.response.MessageResponse;
import com.ladybugger.devservice.payload.response.PhaseDevResponse;
import com.ladybugger.devservice.payload.response.PhaseResponse;
import com.ladybugger.devservice.payload.response.ProfileResponse;
import com.ladybugger.devservice.repository.EmployeeRepository;
import com.ladybugger.devservice.repository.PhaseAssignmentRepository;
import com.ladybugger.devservice.repository.PhaseRepository;
import com.ladybugger.devservice.repository.SubmissionRepository;
import com.ladybugger.devservice.service.PhaseService;
import com.ladybugger.devservice.service.SubmissionService;
import com.ladybugger.devservice.service.EmployeeService;

@RestController
@RequestMapping("/developer")
public class DeveloperController {


    @Autowired
    SubmissionService submissionService;
    @Autowired
    PhaseService phaseService;
    @Autowired
    EmployeeService employeeService;

    @PostMapping("/submit")
    public ResponseEntity<?> submit(@RequestHeader("userId") String userId,
            @Valid @RequestBody SubmissionRequest submissionRequest) {
        Long longId = Long.parseLong(userId);
        String rep = submissionService.createSubmission(longId, submissionRequest);
        return new ResponseEntity<String>(rep, HttpStatus.OK);
    }

    @GetMapping("/get-phase/{id}")
    public ResponseEntity<?> getPhase(@RequestHeader("userId") String userId,
            @PathVariable String id) {
        Long longId = Long.parseLong(userId);
        PhaseResponse pr = phaseService.getPhase(longId, id);
        return ResponseEntity.ok(pr);
    }

    @GetMapping("/get-phases")
    public ResponseEntity<?> getPhases(@RequestHeader("userId") String userId) {
        Long longId = Long.parseLong(userId);
        List<PhaseDevResponse> phasesResponse = phaseService.getPhases(longId);

        return ResponseEntity.ok(phasesResponse);
    }
    
    @GetMapping("/profile/{id}")
    public ResponseEntity<?> profile(@PathVariable String id) {
        
        ProfileResponse profileResponse = employeeService.getProfile(id);

        return ResponseEntity.ok(profileResponse);
    }
    
    @GetMapping("/phase-job/{phase_id}")
    public ResponseEntity<?> phaseJob(@RequestHeader("userId") String userId,
            @PathVariable String phase_id) {
        Long longId = Long.parseLong(userId);
        return new ResponseEntity<String>(phaseService.getPhaseJob(longId, phase_id),
                HttpStatus.OK); 
    
        
    }
    
    

}
