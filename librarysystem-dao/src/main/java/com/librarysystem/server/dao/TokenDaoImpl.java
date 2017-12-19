package com.librarysystem.server.dao;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.librarysystem.server.domain.TokenEntity;

@Repository("tokenDao")
public class TokenDaoImpl implements TokenDao
{
    @Autowired
    private SessionFactory sessionFactory;

    private static final Log logger = LogFactory.getLog(TokenDaoImpl.class);

    @Override
    public TokenEntity create(TokenEntity tokenEntity)
    {
        this.sessionFactory.getCurrentSession().save(tokenEntity);
        this.sessionFactory.getCurrentSession().flush();
        this.sessionFactory.getCurrentSession().refresh(tokenEntity);
        return tokenEntity;
    }

    @Override
    public TokenEntity update(TokenEntity tokenEntity)
    {
        this.sessionFactory.getCurrentSession().update(tokenEntity);
        this.sessionFactory.getCurrentSession().flush();
        this.sessionFactory.getCurrentSession().refresh(tokenEntity);
        return tokenEntity;
    }

    @Override
    public TokenEntity getById(long tokenId)
    {
        return (TokenEntity) this.sessionFactory.getCurrentSession().get(TokenEntity.class, tokenId);
    }

    @Override
    public TokenEntity getTokenEntityByToken(String token)
    {
        Query query = this.sessionFactory.getCurrentSession().createQuery("from TokenEntity t where (t.token = :token) and (token.user.enabled = true)");
        query.setParameter("token", token);
        TokenEntity tokenEntity = (TokenEntity) query.uniqueResult();
        return tokenEntity;
    }

    @Override
    public TokenEntity getTokenEntityByUsername(String username)
    {
        Query query = this.sessionFactory.getCurrentSession().createQuery("from TokenEntity token where (token.user.username = :username) order by token.created DESC");
        query.setParameter("username", username);
        query.setMaxResults(1);
        TokenEntity tokenEntity = (TokenEntity) query.uniqueResult();
        return tokenEntity;
    }

    @Override
    public TokenEntity getTokenEntityByUserId(long userId)
    {
        Query query = this.sessionFactory.getCurrentSession().createQuery("from TokenEntity token where (token.user.userId = :userId) order by token.created DESC");
        query.setParameter("userId", userId);
        query.setMaxResults(1);
        TokenEntity tokenEntity = (TokenEntity) query.uniqueResult();
        return tokenEntity;
    }

    @Override
    public List<TokenEntity> getAllTokenEntityList()
    {
        String queryString = "from TokenEntity";
        List<TokenEntity> list = this.sessionFactory.getCurrentSession().createQuery(queryString).list();
        return list;
    }

}
