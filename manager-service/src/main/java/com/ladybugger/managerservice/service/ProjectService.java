package com.ladybugger.managerservice.service;

import com.ladybugger.managerservice.model.Employee;
import com.ladybugger.managerservice.model.Project;
import com.ladybugger.managerservice.payload.request.PhaseAssignmentRequest;
import com.ladybugger.managerservice.payload.response.SimpleProject;
import com.ladybugger.managerservice.repository.EmployeeRepository;
import com.ladybugger.managerservice.repository.PMAssignmentRepository;
import com.ladybugger.managerservice.repository.ProjectRepository;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author sergio
 */
@Service
public class ProjectService {
    @Autowired
    EmployeeRepository employeeRepository;
    @Autowired
    ProjectRepository projectRepository;
    @Autowired
    PMAssignmentRepository pmaRepository;
    
    public List<SimpleProject> getAssignedProject(Long userId){
        Employee em = employeeRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("Error: Employee not found"));
        
        List<Long> projectIds = pmaRepository.findProjects(em.getId());
        List<SimpleProject> projects = new ArrayList<SimpleProject>();
        for (Long id : projectIds) {
            Project pr = projectRepository.findById(id)
                    .orElseThrow(() -> new RuntimeException("Error: Project not found"));

            projects.add(new SimpleProject((long) id,
                    em.getName() + " " + em.getLastName(),
                    pr.getName(),
                    pr.getDueDate().toString(),
                    pr.getStatus()));
        }
        return projects;
    
    }
    
    
}
