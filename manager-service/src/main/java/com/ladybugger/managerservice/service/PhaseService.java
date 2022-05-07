/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ladybugger.managerservice.service;

import com.ladybugger.managerservice.exceptions.CaseNotFound;
import com.ladybugger.managerservice.exceptions.EmployeeNotFound;
import com.ladybugger.managerservice.exceptions.LogicalError;
import com.ladybugger.managerservice.model.Case;
import com.ladybugger.managerservice.model.Employee;
import com.ladybugger.managerservice.model.Phase;
import com.ladybugger.managerservice.model.PhaseAssignment;
import com.ladybugger.managerservice.payload.response.ListPhasesView;
import com.ladybugger.managerservice.payload.response.MessageResponse;
import com.ladybugger.managerservice.payload.response.PhaseView;
import com.ladybugger.managerservice.repository.CaseRepository;
import com.ladybugger.managerservice.repository.EmployeeRepository;
import com.ladybugger.managerservice.repository.PhaseAssignmentRepository;
import com.ladybugger.managerservice.repository.PhaseRepository;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

/**
 *
 * @author sergio
 */
@Service
public class PhaseService {

    @Autowired
    CaseRepository caseRepository;
    @Autowired
    PhaseAssignmentRepository phaseAssignmentRepository;
    @Autowired
    EmployeeRepository employeeRepository;
    @Autowired
    PhaseRepository phaseRepository;

    public ListPhasesView getPhase(String projectId) {
        long id_long;
        try {
            id_long = Long.parseLong(projectId);
        } catch (Exception e) {
            throw new LogicalError("Wrong id");
        }
        Case cas = caseRepository.findById(id_long)
                .orElseThrow(() -> new CaseNotFound("Error: Case not found"));
        List<PhaseView> phasesProcess = new ArrayList<>(),
                phasesCanceled = new ArrayList<>(),
                phasesFinished = new ArrayList<>(),
                phasesToDo = new ArrayList<>();
        Set<Phase> list = cas.getCasetype().getPhases();
        for (Phase phase : list) {
            PhaseAssignment pa = phaseAssignmentRepository.findDev(id_long, phase.getId());
            PhaseView pv = getPv(pa, phase);
            addToList(phasesProcess, phasesCanceled, phasesFinished, phasesToDo, pa, pv);
        }
        return new ListPhasesView(phasesProcess, phasesCanceled, phasesFinished, phasesToDo);
    }

    public PhaseView getPv(PhaseAssignment pa, Phase phase) {
        if (pa != null) {
            return new PhaseView(phase.getId(),
                    pa.getDev().getName() + " " + pa.getDev().getLastName(),
                    pa.getDev().getId(),
                    phase.getNumber(),
                    pa.getStatus(),
                    pa.getStartDate().toString(),
                    pa.getDueDate().toString());

        } else {
            return new PhaseView(phase.getId(), "", (long) -1, phase.getNumber(), 0, "", "");
        }
    }
    
    public boolean addToList(List<PhaseView> phasesProcess, List<PhaseView> phasesCanceled,
            List<PhaseView> phasesFinished, List<PhaseView> phasesToDo,
            PhaseAssignment pa, PhaseView pv) {
            if (pa == null || pa.getStatus() == 0) {
                return phasesToDo.add(pv);
            } else if (pa.getStatus() == 1) {
                return phasesProcess.add(pv);
            } else if (pa.getStatus() == 2) {
                return phasesFinished.add(pv);
            } else if (pa.getStatus() == 3) {
                return phasesCanceled.add(pv);
            }
            return false;
    }

}
