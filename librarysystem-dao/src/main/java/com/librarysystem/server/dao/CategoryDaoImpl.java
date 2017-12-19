package com.librarysystem.server.dao;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.librarysystem.server.domain.CategoryEntity;

@Repository("categoryDao")
public class CategoryDaoImpl implements CategoryDao
{
    @Autowired
    private SessionFactory sessionFactory;

    private static final Log logger = LogFactory.getLog(CategoryDaoImpl.class);

    @Override
    public CategoryEntity create(CategoryEntity categoryEntity)
    {
        this.sessionFactory.getCurrentSession().save(categoryEntity);
        this.sessionFactory.getCurrentSession().flush();
        this.sessionFactory.getCurrentSession().refresh(categoryEntity);
        return categoryEntity;
    }

    @Override
    public CategoryEntity update(CategoryEntity categoryEntity)
    {
        this.sessionFactory.getCurrentSession().update(categoryEntity);
        this.sessionFactory.getCurrentSession().flush();
        this.sessionFactory.getCurrentSession().refresh(categoryEntity);
        return categoryEntity;
    }

    @Override
    public CategoryEntity getById(long categoryId)
    {
        return (CategoryEntity) this.sessionFactory.getCurrentSession().get(CategoryEntity.class, categoryId);
    }

    @Override
    public CategoryEntity getCategoryEntityByCode(String categoryCode)
    {
        Query query = this.sessionFactory.getCurrentSession().createQuery("from CategoryEntity category where (category.categoryCode = :categoryCode)");
        query.setParameter("categoryCode", categoryCode);
        CategoryEntity categoryEntity = (CategoryEntity) query.uniqueResult();
        return categoryEntity;
    }

    @Override
    public List<CategoryEntity> getAllCategoryEntityList()
    {
        String queryString = "from CategoryEntity";
        List<CategoryEntity> list = this.sessionFactory.getCurrentSession().createQuery(queryString).list();
        return list;
    }

}
