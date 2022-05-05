/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package com.ladybugger.adminservice.service;

import com.ladybugger.adminservice.model.CaseType;
import com.ladybugger.adminservice.payload.request.CaseTypeCreationRequest;
import com.ladybugger.adminservice.repository.CaseTypeRepository;
import com.ladybugger.adminservice.repository.PhaseRepository;
import java.util.Set;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

/**
 *
 * @author mario
 */
public class CaseTypeServiceTest {
    
    @Mock
    private CaseTypeRepository caseTypeRepository;
    @Mock
    private PhaseRepository phaseRepository;
    @InjectMocks
    private CaseTypeService caseTypeService;
    
    public CaseTypeServiceTest() {
    }

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    /**
     * Test of createCaseTypeService method, of class CaseTypeService.
     */
    @Test
    public void testCreateCaseTypeService() {
        System.out.println("createCaseTypeService");
        CaseTypeCreationRequest caseRequest = new CaseTypeCreationRequest();
        caseRequest.setDescription("desc");
        caseRequest.setName("name");
        caseRequest.setPhases(Set.of("phase1", "phase2"));
        CaseType caseType = new CaseType(caseRequest.getName(),
                caseRequest.getDescription(),
                1);
        Mockito.when(caseTypeRepository.save(caseType)).thenReturn(caseType);
        Mockito.when(phaseRepository.saveAll(Mockito.mock(Set.class))).thenReturn(null);
        String expResult = "{\"id\": \"" + caseType.getId() + "\"}";
        String result = caseTypeService.createCaseTypeService(caseRequest);
        assertEquals(expResult, result);
    }
    
}
