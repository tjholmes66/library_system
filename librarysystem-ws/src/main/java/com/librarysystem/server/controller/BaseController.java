package com.librarysystem.server.controller;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;

public class BaseController
{
    protected User authenticate()
    {
        // =============================================================================================
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        User user = null;
        if (principal instanceof User)
        {
            user = ((User) principal);
        }
        // =============================================================================================
        return user;
    }

    protected void invalidateUser()
    {
        // Removing the principal from context, so that user is loaded based on token for every request-temp
        if (SecurityContextHolder.getContext().getAuthentication() != null)
        {
            SecurityContextHolder.getContext().setAuthentication(null);
        }
    }
}
