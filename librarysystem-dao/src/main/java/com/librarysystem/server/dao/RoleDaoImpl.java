package com.librarysystem.server.dao;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.librarysystem.server.domain.RoleEntity;


@Repository("roleDao")
public class RoleDaoImpl implements RoleDao
{
    @Autowired
    private SessionFactory sessionFactory;

    private static final Log logger = LogFactory.getLog(RoleDaoImpl.class);

    @Override
    public RoleEntity create(RoleEntity roleEntity)
    {
        this.sessionFactory.getCurrentSession().save(roleEntity);
        this.sessionFactory.getCurrentSession().flush();
        this.sessionFactory.getCurrentSession().refresh(roleEntity);
        return roleEntity;
    }

    @Override
    public RoleEntity update(RoleEntity roleEntity)
    {
        this.sessionFactory.getCurrentSession().update(roleEntity);
        this.sessionFactory.getCurrentSession().flush();
        this.sessionFactory.getCurrentSession().refresh(roleEntity);
        return roleEntity;
    }

    @Override
    public RoleEntity getById(long roleId)
    {
        return (RoleEntity) this.sessionFactory.getCurrentSession().get(RoleEntity.class, roleId);
    }

    @Override
    public RoleEntity getRoleEntityByCode(String roleCode)
    {
        Query query = this.sessionFactory.getCurrentSession().createQuery("from RoleEntity role where (role.roleCode = :roleCode)");
        query.setParameter("roleCode", roleCode);
        RoleEntity roleEntity = (RoleEntity) query.uniqueResult();
        return roleEntity;
    }

    @Override
    public List<RoleEntity> getAllRoleEntityList()
    {
        String queryString = "from RoleEntity";
        List<RoleEntity> list = this.sessionFactory.getCurrentSession().createQuery(queryString).list();
        return list;
    }

}
