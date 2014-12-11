/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.supinfo.rmt.models;

import java.util.List;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.OneToMany;

/**
 *
 * @author alexis
 */
@Entity
@DiscriminatorValue("MANAGER")
public class Manager extends User {
    
    @OneToMany(mappedBy = "manager")
    private List<Employee> employees;
    
    
    // GETTERS AND SETTERS

    public List<Employee> getEmployees() {
        return employees;
    }

    public void setEmployees(List<Employee> employees) {
        this.employees = employees;
    }
}
