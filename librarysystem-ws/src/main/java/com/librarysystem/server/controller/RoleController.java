package com.librarysystem.server.controller;

import java.util.ArrayList;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.librarysystem.server.domain.RoleEntity;
import com.librarysystem.server.service.RoleService;

@Controller
@RequestMapping("/roles")
public class RoleController
{
    private static final Log logger = LogFactory.getLog(RoleController.class);

    @Autowired
    private RoleService service;

    @RequestMapping(value = "", method = RequestMethod.GET, headers = "Accept=application/json")
    public @ResponseBody ArrayList<RoleEntity> getRoleList1()
    {
        // =============================================================================================
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        User user = null;
        if (principal instanceof User)
        {
            user = ((User) principal);
        }
        // =============================================================================================
        ArrayList<RoleEntity> roleEntityList = (ArrayList<RoleEntity>) service.getAllRoleEntityList();
        return roleEntityList;
    }

    @RequestMapping(value = "/", method = RequestMethod.GET, headers = "Accept=application/json")
    public @ResponseBody ArrayList<RoleEntity> getRoleList2()
    {
        // =============================================================================================
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        User user = null;
        if (principal instanceof User)
        {
            user = ((User) principal);
        }
        // =============================================================================================
        ArrayList<RoleEntity> roleEntityList = (ArrayList<RoleEntity>) service.getAllRoleEntityList();
        return roleEntityList;
    }

    @RequestMapping(value = "/create", method = RequestMethod.POST, produces = "application/json", headers = "content-type=application/json")
    public @ResponseBody RoleEntity createRole(@RequestBody RoleEntity role)
    {
        // =============================================================================================
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        User user = null;
        if (principal instanceof User)
        {
            user = ((User) principal);
        }
        // =============================================================================================
        RoleEntity roleEntity = service.create(role);
        return roleEntity;
    }

    @RequestMapping(value = "/update", method = RequestMethod.PUT, produces = "application/json", headers = "content-type=application/json")
    public @ResponseBody RoleEntity updateRole(@RequestBody RoleEntity role)
    {
        // =============================================================================================
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        User user = null;
        if (principal instanceof User)
        {
            user = ((User) principal);
        }
        // =============================================================================================
        RoleEntity roleEntity = service.update(role);
        return roleEntity;
    }
}
