package com.librarysystem.server.service;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.librarysystem.server.dao.RoleDao;
import com.librarysystem.server.domain.RoleEntity;

@Transactional
@Service("roleService")
public class RoleServiceImpl implements RoleService
{
    private static final Log logger = LogFactory.getLog(RoleServiceImpl.class);

    @Autowired
    private RoleDao roleDao;

    @Override
    public RoleEntity create(RoleEntity roleEntity)
    {
        RoleEntity role = roleDao.create(roleEntity);
        return role;
    }

    @Override
    public RoleEntity update(RoleEntity roleEntity)
    {
        RoleEntity role = roleDao.update(roleEntity);
        return role;
    }

    @Override
    public RoleEntity getById(long roleId)
    {
        RoleEntity role = roleDao.getById(roleId);
        return role;
    }

    @Override
    public List<RoleEntity> getAllRoleEntityList()
    {
        List<RoleEntity> list = roleDao.getAllRoleEntityList();
        return list;
    }

    @Override
    public RoleEntity getRoleEntityByCode(String roleCode)
    {
        RoleEntity role = roleDao.getRoleEntityByCode(roleCode);
        return role;
    }

}
