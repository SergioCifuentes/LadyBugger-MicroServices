package com.ladybugger.managerservice.service;

import com.ladybugger.managerservice.exceptions.LogicalError;
import com.ladybugger.managerservice.exceptions.ProjectNotFound;
import com.ladybugger.managerservice.model.Case;
import com.ladybugger.managerservice.model.Employee;
import com.ladybugger.managerservice.model.PMAssignment;
import com.ladybugger.managerservice.model.Phase;
import com.ladybugger.managerservice.model.PhaseAssignment;
import com.ladybugger.managerservice.model.Project;
import com.ladybugger.managerservice.payload.request.PhaseAssignmentRequest;
import com.ladybugger.managerservice.payload.response.CaseView;
import com.ladybugger.managerservice.payload.response.MessageResponse;
import com.ladybugger.managerservice.payload.response.PhaseView;
import com.ladybugger.managerservice.payload.response.ProjectView;
import com.ladybugger.managerservice.payload.response.SimpleProject;
import com.ladybugger.managerservice.repository.EmployeeRepository;
import com.ladybugger.managerservice.repository.PMAssignmentRepository;
import com.ladybugger.managerservice.repository.PhaseAssignmentRepository;
import com.ladybugger.managerservice.repository.ProjectRepository;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
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
    @Autowired
    PhaseAssignmentRepository phaseAssignmentRepository;

    public List<SimpleProject> getAssignedProject(Long userId) {
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

    public ProjectView getProject(String projectId) {
        long id_long;
        try {
            id_long = Long.parseLong(projectId);
        } catch (Exception e) {
             throw new LogicalError("Wrong id");
           
        }
        Project pr = projectRepository.findById(id_long)
                .orElseThrow(() -> new ProjectNotFound("Error: Project not found"));
        PMAssignment pma = pmaRepository
                .findLastManager(pr.getId());
        List<CaseView> cases = new ArrayList<CaseView>();
        Set<Case> pr_cases = pr.getCases();
        List<Case> caseList = new ArrayList<>(pr_cases);
        for (int i = 0; i < caseList.size(); i++) {
            Case ca = caseList.get(i);
            List<PhaseView> phases = new ArrayList<PhaseView>();
            Set<Phase> pr_phase = ca.getCasetype().getPhases();
            List<Phase> phaseList = new ArrayList<>(pr_phase);
            for (int j = 0; j < phaseList.size(); j++) {
                Phase ph = phaseList.get(j);

                PhaseAssignment pa = phaseAssignmentRepository.findDev(ca.getId(), ph.getId());
                if (pa != null) {
                    phases.add(new PhaseView(ph.getId(),
                            pa.getDev().getName() + " " + pa.getDev().getLastName(),
                            pa.getDev().getId(),
                            ph.getNumber(),
                            pa.getStatus(),
                            pa.getStartDate().toString(),
                            pa.getDueDate().toString()));

                } else {
                    phases.add(new PhaseView(ph.getId(),
                            "",
                            (long) -1,
                            ph.getNumber(),
                            0,
                            "",
                            ""));
                }
            }
            cases.add(new CaseView(ca.getId(), ca.getTitle(), ca.getStartDate().toString(),
                    ca.getDueDate().toString(), ca.getDescription(), ca.getStatus(), phases, ca.getCurrent()));
        }
        ProjectView pv = new ProjectView(pr.getId(),
                pr.getName(),
                pr.getDescription(),
                pma.getEmployee().getName() + " " + pma.getEmployee().getLastName(),
                pma.getEmployee().getId(),
                pr.getStartDate().toString(),
                pr.getDueDate().toString(),
                pr.getStatus(),
                cases);
        return pv;

    }

}
