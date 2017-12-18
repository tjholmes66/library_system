package com.librarysystem.server.dao;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.librarysystem.server.domain.UserEntity;


@Repository("userDao")
public class UserDaoImpl implements UserDao
{
    private static final Log logger = LogFactory.getLog(UserDaoImpl.class);

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public UserEntity create(UserEntity userEntity)
    {
        this.sessionFactory.getCurrentSession().save(userEntity);
        this.sessionFactory.getCurrentSession().flush();
        this.sessionFactory.getCurrentSession().refresh(userEntity);
        return userEntity;
    }

    @Override
    public UserEntity update(UserEntity userEntity)
    {
        this.sessionFactory.getCurrentSession().update(userEntity);
        this.sessionFactory.getCurrentSession().flush();
        this.sessionFactory.getCurrentSession().refresh(userEntity);
        return userEntity;
    }

    @Override
    public UserEntity getById(long userId)
    {
        return (UserEntity) this.sessionFactory.getCurrentSession().get(UserEntity.class, userId);
    }

    @Override
    public UserEntity getUserEntityByUsername(String username)
    {
        Query query = this.sessionFactory.getCurrentSession().createQuery("from UserEntity u where (u.username = :username)");
        query.setParameter("username", username);
        UserEntity userEntity = (UserEntity) query.uniqueResult();
        return userEntity;
    }

    @Override
    public List<UserEntity> getAllUserEntityList()
    {
        String queryString = "from UserEntity";
        List<UserEntity> list = this.sessionFactory.getCurrentSession().createQuery(queryString).list();
        return list;
    }

    @Override
    public UserEntity getUserByUsernameAndPassword(String username, String password)
    {
        Query query = this.sessionFactory.getCurrentSession().createQuery("from UserEntity u where (u.username = :username) AND (u.password = :password)");
        query.setParameter("username", username);
        query.setParameter("password", password);
        UserEntity userEntity = (UserEntity) query.uniqueResult();
        return userEntity;
    }

    @Override
    public UserEntity getUserByResetKey(String resetKey)
    {
        Query query = this.sessionFactory.getCurrentSession().createQuery("from UserEntity u where (u.resetKey = :resetKey)");
        query.setParameter("resetKey", resetKey);
        UserEntity userEntity = (UserEntity) query.uniqueResult();
        return userEntity;
    }

    @Override
    public UserEntity getUserByEmailAddress(String emailAddress)
    {
        Query query = this.sessionFactory.getCurrentSession().createQuery("from UserEntity u where (u.emailAddress = :emailAddress)");
        query.setParameter("emailAddress", emailAddress);
        UserEntity userEntity = (UserEntity) query.uniqueResult();
        return userEntity;
    }

   

}
