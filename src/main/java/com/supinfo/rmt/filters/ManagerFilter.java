/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.supinfo.rmt.filters;

import com.supinfo.rmt.controllers.LoggedUser;
import com.supinfo.rmt.models.Manager;
import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;

/**
 *
 * @author alexis
 */
@WebFilter(urlPatterns = "/manager/*")
public class ManagerFilter implements Filter {
    
    @Override
    public void init(FilterConfig filterConfig) throws ServletException { }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) request;
        LoggedUser loggedUser = (LoggedUser) req.getSession().getAttribute("loggedUser");
        
        if(loggedUser != null && loggedUser.getUser() != null && loggedUser.getUser() instanceof Manager)
            chain.doFilter(request, response);
        else
            req.getRequestDispatcher("/login.xhtml").forward(request, response);
    }

    @Override
    public void destroy() {}
}
