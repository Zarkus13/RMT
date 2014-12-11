/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.supinfo.rmt.converters;

import com.supinfo.rmt.models.Client;
import com.supinfo.rmt.services.ClientService;
import javax.ejb.EJB;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

/**
 *
 * @author alexis
 */
@FacesConverter("clientConverter")
public class ClientConverter implements Converter {
    
    @EJB
    private ClientService clientService;

    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {
        Long id = Long.parseLong(value);
        
        return clientService.findById(id);
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object value) {
        if(value instanceof Client)
            return ((Client) value).getId().toString();
        else
            return null;
    }
    
}
