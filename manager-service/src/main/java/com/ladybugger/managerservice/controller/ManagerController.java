package com.ladybugger.managerservice.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

import com.ladybugger.managerservice.model.Employee;
import com.ladybugger.managerservice.model.PMAssignment;
import com.ladybugger.managerservice.model.Phase;
import com.ladybugger.managerservice.model.PhaseAssignment;
import com.ladybugger.managerservice.model.Project;
import com.ladybugger.managerservice.model.Revision;
import com.ladybugger.managerservice.model.Submission;
import com.ladybugger.managerservice.model.Case;
import com.ladybugger.managerservice.payload.request.CaseCreationRequest;
import com.ladybugger.managerservice.payload.request.PhaseAssignmentRequest;
import com.ladybugger.managerservice.payload.request.RevisionCreationRequest;
import com.ladybugger.managerservice.payload.response.CaseView;
import com.ladybugger.managerservice.payload.response.ListPhasesView;
import com.ladybugger.managerservice.payload.response.MessageResponse;
import com.ladybugger.managerservice.payload.response.PhaseView;
import com.ladybugger.managerservice.payload.response.ProjectView;
import com.ladybugger.managerservice.repository.CaseRepository;
import com.ladybugger.managerservice.repository.CaseTypeRepository;
import com.ladybugger.managerservice.repository.EmployeeRepository;
import com.ladybugger.managerservice.repository.PMAssignmentRepository;
import com.ladybugger.managerservice.repository.PhaseAssignmentRepository;
import com.ladybugger.managerservice.repository.PhaseRepository;
import com.ladybugger.managerservice.repository.ProjectRepository;
import com.ladybugger.managerservice.repository.RevisionRepository;
import com.ladybugger.managerservice.repository.SubmissionRepository;
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

}
