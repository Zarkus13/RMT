/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.supinfo.rmt.services;

import com.supinfo.rmt.models.Employee;
import com.supinfo.rmt.models.WorkTime;
import java.io.Serializable;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author alexis
 */
@Stateless
public class WorkTimeService implements Serializable {
    
    @PersistenceContext
    private EntityManager em;
    
    public void add(final WorkTime workTime) {
        em.persist(workTime);
    }
    
    public List<WorkTime> findByEmployee(final Employee employee) {
        Query q = em.createNamedQuery("findWorkTimesByEmployee")
            .setParameter("employee", employee);
        
        return q.getResultList();
    }
}
