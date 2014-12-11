/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.supinfo.rmt.models;

import java.util.List;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;

/**
 *
 * @author alexis
 */
@Entity
@DiscriminatorValue("EMPLOYEE")
@NamedQueries({
    @NamedQuery(name = "findEmployeesByManager", query = "SELECT e FROM Employee e WHERE e.manager = :manager")
})
public class Employee extends User {
    
    @ManyToOne
    @JoinColumn(name = "MANAGER_FK")
    private Manager manager;
    
    @OneToMany(mappedBy = "employee")
    private List<WorkTime> workTimes;
    
    
    // GETTERS AND SETTERS

    public Manager getManager() {
        return manager;
    }

    public void setManager(Manager manager) {
        this.manager = manager;
    }

    public List<WorkTime> getWorkTimes() {
        return workTimes;
    }

    public void setWorkTimes(List<WorkTime> workTimes) {
        this.workTimes = workTimes;
    }
    
}
