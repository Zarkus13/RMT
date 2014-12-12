/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.supinfo.rmt.controllers;

import com.supinfo.rmt.models.Employee;
import com.supinfo.rmt.models.User;
import com.supinfo.rmt.services.UserService;
import java.io.Serializable;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;

/**
 *
 * @author alexis
 */
@ManagedBean
@RequestScoped
public class AuthController implements Serializable {
    
    @EJB
    private UserService userService;
    
    @ManagedProperty("#{loggedUser}")
    private LoggedUser loggedUser;
    
    private String username;
    private String password;
    
    public String login() {
        User user = userService.login(username, password);
        
        loggedUser.setUser(user);
        
        if(user == null)
            return null;
        else
            return (user instanceof Employee ? "employee/employee?faces-redirect=true" : "manager/manager?faces-redirect=true");
    }
    
    public String logout() {
        loggedUser.setUser(null);
        
        return "/login?faces-redirect=true";
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public LoggedUser getLoggedUser() {
        return loggedUser;
    }

    public void setLoggedUser(LoggedUser loggedUser) {
        this.loggedUser = loggedUser;
    }
    
}
