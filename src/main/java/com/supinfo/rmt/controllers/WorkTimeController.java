/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.supinfo.rmt.controllers;

import com.supinfo.rmt.models.Employee;
import com.supinfo.rmt.models.WorkTime;
import com.supinfo.rmt.services.WorkTimeService;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;

/**
 *
 * @author alexis
 */
@ManagedBean
@ViewScoped
public class WorkTimeController implements Serializable {
    
    @EJB
    private WorkTimeService workTimeService;
    
    @ManagedProperty("#{loggedUser}")
    private LoggedUser loggedUser;
    
    private WorkTime workTimeToAdd;
    
    @PostConstruct
    private void init() {
        workTimeToAdd = new WorkTime();
    }
    
    public void addWorkTime() {
        final Employee employee = (Employee) loggedUser.getUser();
        workTimeToAdd.setEmployee(employee);
        
        workTimeService.add(workTimeToAdd);
    }
    
    public List<WorkTime> workTimesFromCurrentEmployee() {
        final Employee employee = (Employee) loggedUser.getUser();
        
        return workTimeService.findByEmployee(employee);
    }
    
    
    // GETTERS AND SETTERS

    public LoggedUser getLoggedUser() {
        return loggedUser;
    }

    public void setLoggedUser(LoggedUser loggedUser) {
        this.loggedUser = loggedUser;
    }

    public WorkTime getWorkTimeToAdd() {
        return workTimeToAdd;
    }

    public void setWorkTimeToAdd(WorkTime workTimeToAdd) {
        this.workTimeToAdd = workTimeToAdd;
    }
}
