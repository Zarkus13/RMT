/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.supinfo.rmt.controllers;

import com.supinfo.rmt.models.Employee;
import com.supinfo.rmt.models.Manager;
import com.supinfo.rmt.services.EmployeeService;
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
public class EmployeeController implements Serializable {
    
    @EJB
    private EmployeeService employeeService;
    
    @ManagedProperty("#{loggedUser}")
    private LoggedUser loggedUser;
    
    private Employee employeeToAdd;
    
    @PostConstruct
    private void init() {
        employeeToAdd = new Employee();
    }
    
    public void addEmployee() {
        System.out.println("add employee");
        employeeToAdd.setManager((Manager) loggedUser.getUser());
        employeeService.add(employeeToAdd);
    }
    
    public List<Employee> employeesFromCurrentManager() {
        return employeeService.findByManager((Manager) loggedUser.getUser());
    }
    
    
    // GETTERS AND SETTERS

    public Employee getEmployeeToAdd() {
        return employeeToAdd;
    }

    public void setEmployeeToAdd(Employee employeeToAdd) {
        this.employeeToAdd = employeeToAdd;
    }

    public LoggedUser getLoggedUser() {
        return loggedUser;
    }

    public void setLoggedUser(LoggedUser loggedUser) {
        this.loggedUser = loggedUser;
    }
    
}
