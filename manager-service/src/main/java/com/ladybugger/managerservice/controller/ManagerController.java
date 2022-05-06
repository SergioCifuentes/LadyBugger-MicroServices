package com.ladybugger.managerservice.controller;


import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.ladybugger.managerservice.payload.request.CaseCreationRequest;
import com.ladybugger.managerservice.payload.request.PhaseAssignmentRequest;
import com.ladybugger.managerservice.payload.request.RevisionCreationRequest;
import com.ladybugger.managerservice.payload.response.ListPhasesView;
import com.ladybugger.managerservice.payload.response.ProjectView;
import com.ladybugger.managerservice.service.CaseTypeService;
import com.ladybugger.managerservice.service.PhaseAssignmentService;
import com.ladybugger.managerservice.service.PhaseService;
import com.ladybugger.managerservice.service.ProjectService;
import com.ladybugger.managerservice.service.RevisionService;

@RestController
@RequestMapping("/manager")
public class ManagerController {

    @Autowired
    CaseTypeService caseTypeService;
    @Autowired
    PhaseAssignmentService phaseAssignmentService;
    @Autowired
    ProjectService projectService;
    @Autowired
    RevisionService revisionService;
    @Autowired
    PhaseService phaseService;

    @PostMapping("/create-case")
    public ResponseEntity<?> registerCaseType(@RequestHeader("userId") String userId, @Valid @RequestBody CaseCreationRequest caseRequest) {
        Long longId = Long.parseLong(userId);
        return new ResponseEntity<String>(caseTypeService.registerCaseType(longId,
                caseRequest), HttpStatus.OK);
    }


    @PostMapping("/assign-phase")
    public ResponseEntity<?> assignPhase(@RequestHeader("userId") String userId, @Valid @RequestBody PhaseAssignmentRequest assignmentRequest) {
        Long longId = Long.parseLong(userId);
        return new ResponseEntity<String>(phaseAssignmentService.assignPhase(longId,
                assignmentRequest), HttpStatus.OK);
    }

    @GetMapping("/get-assigned-projects")
    public ResponseEntity<?> getAssignedProject(@RequestHeader("userId") String userId) {
        Long longId = Long.parseLong(userId);

        return ResponseEntity.ok(projectService.getAssignedProject(longId));
    }

    @PostMapping("/revision")
    public ResponseEntity<?> revision(@RequestHeader("userId") String userId,
            @Valid @RequestBody RevisionCreationRequest revisionCreationRequest) {
        Long longId = Long.parseLong(userId);

        String rep= revisionService.createRevision(longId, revisionCreationRequest);
        return new ResponseEntity<String>(rep, HttpStatus.OK);
    }

    @GetMapping("/get-project/{id}")
    public ResponseEntity<?> getProject(@PathVariable String id) {
        ProjectView pv=projectService.getProject(id);
        return ResponseEntity.ok(pv);
    }

    @GetMapping("/get-phases/{id}")
    public ResponseEntity<?> getPhases(@PathVariable String id) {
        ListPhasesView lpv= phaseService.getPhase(id);
        return ResponseEntity.ok(lpv);
    }
    
    @PutMapping("/cancel-phase-assignment/{phase_id}")
    public ResponseEntity<?> cancelPhaseAssignment(@RequestHeader("userId") String userId,
            @PathVariable String phase_id) {
        Long longId = Long.parseLong(userId);
        return ResponseEntity.ok(phaseAssignmentService.cancelPhaseAssignment(longId, phase_id)); 
    
        
    }

}
