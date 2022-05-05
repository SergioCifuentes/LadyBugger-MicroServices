/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ladybugger.adminservice.service;

import com.ladybugger.adminservice.model.CaseType;
import com.ladybugger.adminservice.model.Phase;
import com.ladybugger.adminservice.payload.request.CaseTypeCreationRequest;
import com.ladybugger.adminservice.repository.CaseTypeRepository;
import com.ladybugger.adminservice.repository.PhaseRepository;
import java.util.HashSet;
import java.util.Set;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author mario
 */
@Service
public class CaseTypeService {
    
    @Autowired
    CaseTypeRepository caseTypeRepository;
    @Autowired
    PhaseRepository phaseRepository;
    
    public String createCaseTypeService(CaseTypeCreationRequest caseRequest) {
        CaseType caseType = new CaseType(caseRequest.getName(),
                caseRequest.getDescription(),
                1);
        Set<String> strphases = caseRequest.getPhases();
        Set<Phase> phases = new HashSet<>();
        System.out.println(strphases);
        String[] arrphases = strphases.toArray(new String[strphases.size()]);

        for (int i = 0; i < arrphases.length; i++) {
            Phase phase = new Phase(arrphases[i], i + 1, caseType);
            phases.add(phase);
        }
        caseTypeRepository.save(caseType);
        phaseRepository.saveAll(phases);
        return "{\"id\": \"" + caseType.getId() + "\"}";
    }
    
}
