/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ladybugger.managerservice.service;

import com.ladybugger.managerservice.exceptions.CaseNotFound;
import com.ladybugger.managerservice.exceptions.LogicalError;
import com.ladybugger.managerservice.model.Case;
import com.ladybugger.managerservice.model.Phase;
import com.ladybugger.managerservice.model.PhaseAssignment;
import com.ladybugger.managerservice.payload.response.ListPhasesView;
import com.ladybugger.managerservice.payload.response.MessageResponse;
import com.ladybugger.managerservice.payload.response.PhaseView;
import com.ladybugger.managerservice.repository.CaseRepository;
import com.ladybugger.managerservice.repository.PhaseAssignmentRepository;
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
    
    public ListPhasesView getPhase(String projectId){
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
                pv = new PhaseView(phase.getId(),"",(long) -1,phase.getNumber(),0,"","");
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
    return new ListPhasesView(phasesProcess, phasesCanceled, phasesFinished, phasesToDo);
    }
    
}
