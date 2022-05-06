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
import com.ladybugger.managerservice.service.ProjectService;

@RestController
@RequestMapping("/manager")
public class ManagerController {

    @Autowired
    CaseTypeRepository caseTypeRepository;
    @Autowired
    ProjectRepository projectRepository;
    @Autowired
    CaseRepository caseRepository;
    @Autowired
    EmployeeRepository userRepository;
    @Autowired
    PMAssignmentRepository pmaRepository;
    @Autowired
    PhaseRepository phaseRepository;
    @Autowired
    PhaseAssignmentRepository phaseAssignmentRepository;
    @Autowired
    SubmissionRepository submissionRepository;
    @Autowired
    RevisionRepository revisionRepository;
    @Autowired
    CaseTypeService caseTypeService;
    @Autowired
    PhaseAssignmentService phaseAssignmentService;
    @Autowired
    ProjectService projectService;

    @PostMapping("/create-case")
    public ResponseEntity<?> registerCaseType(@RequestHeader("userId") String userId, @Valid @RequestBody CaseCreationRequest caseRequest) {
        Long longId = Long.parseLong(userId);
        return new ResponseEntity<String>(caseTypeService.registerCaseType(longId,
                caseRequest), HttpStatus.OK);
    }

    @PostMapping("/prueba")
    public ResponseEntity<?> prueba(@RequestHeader("userId") String userId) {
        Long longId = Long.parseLong(userId);
        System.out.println("Yes " + longId);
        return new ResponseEntity<String>("z", HttpStatus.OK);
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
    @PreAuthorize("hasRole('USER')")
    public ResponseEntity<?> revision(@Valid @RequestBody RevisionCreationRequest revisionCreationRequest) {
        UserDetails userDetails = (UserDetails) SecurityContextHolder.getContext().getAuthentication()
                .getPrincipal();
        Employee em = userRepository.findByEmail(userDetails.getUsername())
                .orElseThrow(() -> new RuntimeException("Error: Employee not found"));

        Submission submission = submissionRepository.findById((long) revisionCreationRequest.getSubmissionId())
                .orElseThrow(() -> new RuntimeException("Error: Submission not found"));
        PMAssignment pma = pmaRepository
                .findLastManager(submission.getPhaseAssignment().getCaseM().getProject().getId());
        if (!pma.getEmployee().getId().equals(em.getId())) {
            return ResponseEntity
                    .badRequest()
                    .body(new MessageResponse(
                            "Error: You are not the Project Manager of this phase"));
        }

        Revision revision = new Revision(revisionCreationRequest.isAccepted(),
                submission,
                revisionCreationRequest.getDate(),
                revisionCreationRequest.getRejectReason());

        revisionRepository.save(revision);
        return new ResponseEntity<String>("{\"id\": \"" + revision.getId() + "\"}", HttpStatus.OK);
    }

    @GetMapping("/get-project/{id}")
    public ResponseEntity<?> getProject(@PathVariable String id) {
        long id_long;
        try {
            id_long = Long.parseLong(id);
        } catch (Exception e) {
            return ResponseEntity
                    .badRequest()
                    .body(new MessageResponse("Wrong id"));
        }
        Project pr = projectRepository.findById(id_long)
                .orElseThrow(() -> new RuntimeException("Error: Project not found"));
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
        return ResponseEntity.ok(new ProjectView(pr.getId(),
                pr.getName(),
                pr.getDescription(),
                pma.getEmployee().getName() + " " + pma.getEmployee().getLastName(),
                pma.getEmployee().getId(),
                pr.getStartDate().toString(),
                pr.getDueDate().toString(),
                pr.getStatus(),
                cases));
    }

    @GetMapping("/get-phases/{id}")
    public ResponseEntity<?> getPhases(@PathVariable String id) {
        long id_long;
        try {
            id_long = Long.parseLong(id);
        } catch (Exception e) {
            return ResponseEntity
                    .badRequest()
                    .body(new MessageResponse("Wrong id"));
        }
        Case cas = caseRepository.findById(id_long).orElseThrow(() -> new RuntimeException("Error: Case not found"));
        List<PhaseView> phasesProcess = new ArrayList<>(),
                phasesCanceled = new ArrayList<>(),
                phasesFinished = new ArrayList<>(),
                phasesToDo = new ArrayList<>();
        Set<Phase> list = cas.getCasetype().getPhases();
        for (Phase phase : list) {
            PhaseAssignment pa = phaseAssignmentRepository.findDev(id_long, phase.getId());
            PhaseView pv;
            if (pa != null) {
                pv = new PhaseView(phase.getId(),
                        pa.getDev().getName() + " " + pa.getDev().getLastName(),
                        pa.getDev().getId(),
                        phase.getNumber(),
                        pa.getStatus(),
                        pa.getStartDate().toString(),
                        pa.getDueDate().toString());

            } else {
                pv = new PhaseView(phase.getId(),
                        "",
                        (long) -1,
                        phase.getNumber(),
                        0,
                        "",
                        "");
            }
            if (pv == null || pa.getStatus() == 1) {
                phasesToDo.add(pv);
            } else if (pa.getStatus() == 1) {
                phasesProcess.add(pv);
            } else if (pa.getStatus() == 2) {
                phasesFinished.add(pv);
            } else if (pa.getStatus() == 3) {
                phasesCanceled.add(pv);
            }
        }
        return ResponseEntity.ok(new ListPhasesView(phasesProcess, phasesCanceled, phasesFinished, phasesToDo));
    }

}
