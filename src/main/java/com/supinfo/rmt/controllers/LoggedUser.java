/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.supinfo.rmt.controllers;

import com.supinfo.rmt.models.User;
import java.io.Serializable;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

/**
 *
 * @author alexis
 */
@ManagedBean
@SessionScoped
public class LoggedUser implements Serializable {
    private User user;    
    
    // GETTERS AND SETTERS

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
    
}
