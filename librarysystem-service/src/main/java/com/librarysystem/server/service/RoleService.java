package com.librarysystem.server.service;

import java.util.List;

import com.librarysystem.server.domain.RoleEntity;

public interface RoleService
{
    // CREATE
    RoleEntity create(RoleEntity roleEntity);

    // RETRIEVE
    RoleEntity getById(long roleId);

    RoleEntity getRoleEntityByCode(String roleCode);

    List<RoleEntity> getAllRoleEntityList();

    // UPDATE
    RoleEntity update(RoleEntity roleEntity);

    // DELETE
}
