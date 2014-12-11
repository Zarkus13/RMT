/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.supinfo.rmt.controllers;

import com.supinfo.rmt.models.Client;
import com.supinfo.rmt.services.ClientService;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

/**
 *
 * @author alexis
 */
@ManagedBean
@ViewScoped
public class ClientController implements Serializable {
    
    @EJB
    private ClientService clientService;
    
    private Client clientToAdd;
    
    @PostConstruct
    private void init() {
        clientToAdd = new Client();
    }
    
    public List<Client> findAllClients() {
        return clientService.findAll();
    }
    
    public void addClient() {
        clientService.add(clientToAdd);
    }

    
    // GETTERS AND SETTERS

    public Client getClientToAdd() {
        return clientToAdd;
    }

    public void setClientToAdd(Client clientToAdd) {
        this.clientToAdd = clientToAdd;
    }
}
