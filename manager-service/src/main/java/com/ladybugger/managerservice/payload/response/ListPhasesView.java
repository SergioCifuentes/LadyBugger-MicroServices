/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ladybugger.managerservice.payload.response;

import java.util.List;

/**
 *
 * @author mario
 */
public class ListPhasesView {
    
    private List<PhaseView> inProcess;
    private List<PhaseView> canceled;
    private List<PhaseView> finished;
    private List<PhaseView> toDo;

    public ListPhasesView(List<PhaseView> phasesProcess, List<PhaseView> phasesCanceled, List<PhaseView> phasesFinished, List<PhaseView> phasesToDo) {
        this.inProcess = phasesProcess;
        this.canceled = phasesCanceled;
        this.finished = phasesFinished;
        this.toDo = phasesToDo;
    }

    public List<PhaseView> getPhasesProcess() {
        return inProcess;
    }

    public void setPhasesProcess(List<PhaseView> phasesProcess) {
        this.inProcess = phasesProcess;
    }

    public List<PhaseView> getPhasesCanceled() {
        return canceled;
    }

    public void setPhasesCanceled(List<PhaseView> phasesCanceled) {
        this.canceled = phasesCanceled;
    }

    public List<PhaseView> getPhasesFinished() {
        return finished;
    }

    public void setPhasesFinished(List<PhaseView> phasesFinished) {
        this.finished = phasesFinished;
    }

    public List<PhaseView> getPhasesToDo() {
        return toDo;
    }

    public void setPhasesToDo(List<PhaseView> phasesToDo) {
        this.toDo = phasesToDo;
    }
    
    
    
}
