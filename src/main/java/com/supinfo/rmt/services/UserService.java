/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.supinfo.rmt.services;

import com.supinfo.rmt.models.User;
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
public class UserService implements Serializable {
    
    @PersistenceContext
    private EntityManager em;
    
    public User login(final String username, final String password) {
        System.out.println("UserService login");
        try {
            Query q = em.createNamedQuery("login")
                .setParameter("username", username)
                .setParameter("password", password);
            
            return (User) q.getSingleResult();
        }
        catch(Exception e) {
            System.out.println("Exception : " + e.getMessage());
            return null;
        }
    }
    
    public List<User> findAll() {
        return em.createNamedQuery("findAllUsers").getResultList();
    }
}
