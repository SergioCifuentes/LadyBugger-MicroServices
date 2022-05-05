/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ladybugger.adminservice.service;

import com.ladybugger.adminservice.model.Case;
import com.ladybugger.adminservice.payload.response.CaseResponse;
import com.ladybugger.adminservice.repository.CaseRepository;
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
public class CaseService {
    
    @Autowired
    CaseRepository caseRepository;
    
    public List<CaseResponse> getProjectsPageable(Pageable pageable) {
        Page<Case> pr = caseRepository.findAll(pageable);
        return getCasesResponse(pr.toList());
    }
    
    public List<CaseResponse> getCasesResponse(List<Case> pr) {
        List<CaseResponse> casesResponse = new ArrayList<CaseResponse>();
        for (Case caseM : pr) {
            casesResponse.add(new CaseResponse(caseM.getId(),
                    caseM.getDescription(),
                    caseM.getCasetype().getName(),
                    caseM.getStatus(),
                    caseM.getProject().getName(),
                    caseM.getProject().getId(),
                    caseM.getStartDate().toString(),
                    caseM.getDueDate().toString()));
        }
        return casesResponse;
    }
    
}
