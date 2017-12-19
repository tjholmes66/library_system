package com.librarysystem.server.controller;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;

public class BaseController
{
    protected User authenticate()
    {
        UserDetails userDetails = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        User user = null;
        if (userDetails instanceof User)
        {
            user = ((User) userDetails);
        }
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
