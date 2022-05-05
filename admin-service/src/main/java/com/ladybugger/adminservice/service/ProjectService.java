/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ladybugger.adminservice.service;

import com.ladybugger.adminservice.model.Case;
import com.ladybugger.adminservice.model.PMAssignment;
import com.ladybugger.adminservice.model.Project;
import com.ladybugger.adminservice.payload.response.ProjectCases;
import com.ladybugger.adminservice.payload.response.SimpleCase;
import com.ladybugger.adminservice.repository.PMAssignmentRepository;
import com.ladybugger.adminservice.repository.ProjectRepository;
import java.util.ArrayList;
import java.util.List;
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
    
}
