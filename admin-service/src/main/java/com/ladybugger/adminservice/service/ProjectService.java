/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ladybugger.adminservice.service;

import com.ladybugger.adminservice.exception.EmployeeNotFound;
import com.ladybugger.adminservice.model.Case;
import com.ladybugger.adminservice.model.Employee;
import com.ladybugger.adminservice.model.PMAssignment;
import com.ladybugger.adminservice.model.Project;
import com.ladybugger.adminservice.payload.request.ProjectCreationRequest;
import com.ladybugger.adminservice.payload.response.ProjectCases;
import com.ladybugger.adminservice.payload.response.SimpleCase;
import com.ladybugger.adminservice.repository.EmployeeRepository;
import com.ladybugger.adminservice.repository.PMAssignmentRepository;
import com.ladybugger.adminservice.repository.ProjectRepository;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

/**
 *
 * @author mario
 */
@Service
public class ProjectService {

    @Autowired
    PMAssignmentRepository pmaRepository;
    @Autowired
    ProjectRepository projectRepository;
    @Autowired
    EmployeeRepository employeeRepository;

    public List<ProjectCases> getProjectsPageable(Pageable pageable) {

        Page<Project> pr = projectRepository.findAll(pageable);

        List<ProjectCases> projectsResponse = new ArrayList<ProjectCases>();
        for (Project project : pr) {
            List<SimpleCase> casesResponse = new ArrayList<SimpleCase>();
            for (Case cases : project.getCases()) {
                casesResponse.add(new SimpleCase(cases.getId(),
                        cases.getTitle(),
                        cases.getDescription()));
            }
            PMAssignment pma = pmaRepository
                    .findLastManager(project.getId());
            projectsResponse.add(new ProjectCases(project.getId(),
                    project.getName(),
                    pma.getEmployee().getName() + " " + pma.getEmployee().getLastName(),
                    project.getStatus(),
                    project.getStartDate().toString(),
                    project.getDueDate().toString(),
                    casesResponse));
        }
        return projectsResponse;
    }

    public String registerProject(Long userId, ProjectCreationRequest projectCreationRequest) {
        Employee em = employeeRepository.findById(userId)
                .orElseThrow(() -> new EmployeeNotFound("Error: Employee not found"));

        Project project = new Project(projectCreationRequest.getName(),
                projectCreationRequest.getDescription(),
                1,
                projectCreationRequest.getStartDate(),
                projectCreationRequest.getDueDate(),
                em);
        Employee pm = employeeRepository.findById((long) projectCreationRequest.getPmId())
                .orElseThrow(() -> new EmployeeNotFound("Error: PM not found"));
        java.sql.Timestamp timestamp1 = new java.sql.Timestamp(System.currentTimeMillis());
        Set<PMAssignment> pmas = new HashSet<>();
        PMAssignment apm = new PMAssignment(pm, project, timestamp1);
        pmas.add(apm);

        pm.setProjects(pmas);
        project.setPms(pmas);
        projectRepository.save(project);
        pmaRepository.save(apm);
        return "{\"id\": \"" + project.getId() + "\"}";
    }

}
