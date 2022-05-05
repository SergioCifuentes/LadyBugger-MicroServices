/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package com.ladybugger.adminservice.service;

import com.ladybugger.adminservice.model.Case;
import com.ladybugger.adminservice.model.CaseType;
import com.ladybugger.adminservice.model.Project;
import com.ladybugger.adminservice.payload.response.CaseResponse;
import com.ladybugger.adminservice.repository.CaseRepository;
import java.sql.Date;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

/**
 *
 * @author mario
 */
public class CaseServiceTest {

    @Mock
    CaseRepository caseRepository;
    @InjectMocks
    CaseService caseService;

    public CaseServiceTest() {
    }

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    /**
     * Test of getProjectsPageable method, of class CaseService.
     */
    @Test
    public void testGetProjectsPageable() {
        System.out.println("getProjectsPageable");
        Pageable pageable = Pageable.ofSize(5);
        Page<Case> pr = Page.empty(pageable);
        Mockito.when(
                caseRepository.findAll(pageable)
        ).thenReturn(pr);
        List<CaseResponse> cases = new ArrayList<>();
        assertEquals(cases, caseService.getProjectsPageable(pageable));
    }
    
    @Test
    public void testGetCasesResponse() {
        System.out.println("getCasesResponse");
        Case casem = new Case("title", "desc", new CaseType(), 0, new Project(),
                Date.valueOf(LocalDate.now()), Date.valueOf(LocalDate.now()), 1);
        List<Case> cases = List.of(casem);
        List<CaseResponse> casesre = List.of(Mockito.mock(CaseResponse.class));
        assertEquals(casesre.size(), caseService.getCasesResponse(cases).size());
    }

}
