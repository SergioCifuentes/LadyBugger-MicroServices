/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package com.ladybugger.managerservice.payload.response;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author mario
 */
public class ProjectViewTest {
    
    private ProjectView projectView;
    
    public ProjectViewTest() {
    }
    
    @BeforeEach
    public void setUp() {
        projectView = new ProjectView(null, null, null,
                null, null, null, null, 0, null);
    }

    /**
     * Test of getId method, of class ProjectView.
     */
    @Test
    public void testGetId() {
        System.out.println("getId");
        ProjectView instance = projectView;
        Long expResult = 1l;
        instance.setId(expResult);
        Long result = instance.getId();
        assertEquals(expResult, result);
    }

    /**
     * Test of getName method, of class ProjectView.
     */
    @Test
    public void testGetName() {
        System.out.println("getName");
        ProjectView instance = projectView;
        String expResult = "name";
        instance.setName(expResult);
        String result = instance.getName();
        assertEquals(expResult, result);
    }

    /**
     * Test of getDescription method, of class ProjectView.
     */
    @Test
    public void testGetDescription() {
        System.out.println("getDescription");
        ProjectView instance = projectView;
        String expResult = "desc";
        instance.setDescription(expResult);
        String result = instance.getDescription();
        assertEquals(expResult, result);
    }

    /**
     * Test of getPm_name method, of class ProjectView.
     */
    @Test
    public void testGetPm_name() {
        System.out.println("getPm_name");
        ProjectView instance = projectView;
        String expResult = "pmName";
        instance.setPm_name(expResult);
        String result = instance.getPm_name();
        assertEquals(expResult, result);
    }

    /**
     * Test of getProject_manager_id method, of class ProjectView.
     */
    @Test
    public void testGetProject_manager_id() {
        System.out.println("getProject_manager_id");
        ProjectView instance = projectView;
        Long expResult = 1l;
        instance.setProject_manager_id(expResult);
        Long result = instance.getProject_manager_id();
        assertEquals(expResult, result);
    }

    /**
     * Test of getStart_date method, of class ProjectView.
     */
    @Test
    public void testGetStart_date() {
        System.out.println("getStart_date");
        ProjectView instance = projectView;
        String expResult = "10-10-2022";
        instance.setStart_date(expResult);
        String result = instance.getStart_date();
        assertEquals(expResult, result);
    }

    /**
     * Test of getDue_date method, of class ProjectView.
     */
    @Test
    public void testGetDue_date() {
        System.out.println("getDue_date");
        ProjectView instance = projectView;
        String expResult = "10-10-2022";
        instance.setDue_date(expResult);
        String result = instance.getDue_date();
        assertEquals(expResult, result);
    }

    /**
     * Test of getStatus method, of class ProjectView.
     */
    @Test
    public void testGetStatus() {
        System.out.println("getStatus");
        ProjectView instance = projectView;
        int expResult = 1;
        instance.setStatus(expResult);
        int result = instance.getStatus();
        assertEquals(expResult, result);
    }

    /**
     * Test of getCases method, of class ProjectView.
     */
    @Test
    public void testGetCases() {
        System.out.println("getCases");
        ProjectView instance = projectView;
        List<CaseView> expResult = new ArrayList<>();
        instance.setCases(expResult);
        List<CaseView> result = instance.getCases();
        assertEquals(expResult, result);
    }
    
}
