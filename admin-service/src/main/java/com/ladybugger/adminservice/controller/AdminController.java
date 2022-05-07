package com.ladybugger.adminservice.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ladybugger.adminservice.exceptions.*;
import com.ladybugger.adminservice.model.Employee;
import com.ladybugger.adminservice.payload.request.CaseTypeCreationRequest;
import com.ladybugger.adminservice.payload.request.PMAssignmentRequest;
import com.ladybugger.adminservice.payload.request.ProjectCreationRequest;
import com.ladybugger.adminservice.service.CaseService;
import com.ladybugger.adminservice.service.CaseTypeService;
import com.ladybugger.adminservice.service.DevsService;
import com.ladybugger.adminservice.service.EmployeeService;
import com.ladybugger.adminservice.service.ProjectService;
import org.springframework.web.bind.annotation.RequestHeader;

@RestController
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    DevsService devsService;
    @Autowired
    CaseTypeService caseTypeService;
    @Autowired
    ProjectService projectService;
    @Autowired
    CaseService caseService;
    @Autowired
    EmployeeService employeeService;

    @PostMapping("/create-project")
    public ResponseEntity<?> registerProject(@RequestHeader("userId") String userId,
            @Valid @RequestBody ProjectCreationRequest projectCreationRequest) {
        Long longId = Long.parseLong(userId);
        String output=projectService.registerProject(longId,
                projectCreationRequest);
        
        return new ResponseEntity<String>(output, HttpStatus.OK);
    }

    @GetMapping("/devs-list")
    public List<Object[]> getDevs() {
        return devsService.getDevsByRole();
    }

    @PostMapping("/create-casetype")
    public ResponseEntity<?> registerCaseType(@Valid @RequestBody CaseTypeCreationRequest caseRequest) {
        return new ResponseEntity<String>(caseTypeService.createCaseTypeService(caseRequest), HttpStatus.OK);
    }

    @PostMapping("/assign-project")
    public ResponseEntity<?> assignProject(@Valid @RequestBody PMAssignmentRequest pmAssignmentRequest) {
        return new ResponseEntity<String>(devsService.assignProject(pmAssignmentRequest), HttpStatus.OK);
    }

    @GetMapping(value = "/get-projects")
    public ResponseEntity<?> getProjects(Pageable pageable) {
        return ResponseEntity.ok(projectService.getProjectsPageable(pageable));
    }

    @PutMapping("/delete-employee/{id}")
    public ResponseEntity<?> softDeleteEmployee(@RequestHeader("userId") String userId,
            @PathVariable(value = "id") Long employeeId)
            throws ResourceNotFoundException {
        Long longId = Long.parseLong(userId);
        Employee updatedEmployee = employeeService.deleteEmployee(longId, employeeId);
        return ResponseEntity.ok(updatedEmployee);
    }

    @GetMapping(value = "/get-cases")
    public ResponseEntity<?> getCases(Pageable pageable) {
        return ResponseEntity.ok(caseService.getProjectsPageable(pageable));
    }

    @GetMapping(value = "/get-users")
    public ResponseEntity<?> getUsers(Pageable pageable) {
        return ResponseEntity.ok(devsService.getUsers(pageable));
    }
    
        @PutMapping("/cancel-project/{project_id}")
    public ResponseEntity<?> cancelPhaseAssignment(@PathVariable String project_id) {
       
        return ResponseEntity.ok(projectService.cancelProject(project_id)); 
    
        
    }

}
