package com.librarysystem.server.dao;

import java.util.List;

import com.librarysystem.server.domain.RoleEntity;

public interface RoleDao
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
