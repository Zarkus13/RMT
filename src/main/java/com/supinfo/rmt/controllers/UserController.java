/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.supinfo.rmt.controllers;

import com.supinfo.rmt.models.User;
import com.supinfo.rmt.services.UserService;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.ViewScoped;

/**
 *
 * @author alexis
 */
@ManagedBean
@ViewScoped
public class UserController implements Serializable {
    
    @EJB
    private UserService userService;
    
    private List<User> users;
    
    @PostConstruct
    private void init() {
        users = userService.findAll();
    }
    
    public void deleteUser(final User u) {
        System.out.println("u : " + u.getId());
    }

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }
    
}
