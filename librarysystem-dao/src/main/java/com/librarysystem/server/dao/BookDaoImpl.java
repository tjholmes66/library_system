package com.librarysystem.server.dao;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.librarysystem.server.domain.BookEntity;

@Repository("bookDao")
public class BookDaoImpl implements BookDao
{

    private static final Log logger = LogFactory.getLog(UserDaoImpl.class);

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public BookEntity create(BookEntity bookEntity)
    {
        this.sessionFactory.getCurrentSession().save(bookEntity);
        this.sessionFactory.getCurrentSession().flush();
        this.sessionFactory.getCurrentSession().refresh(bookEntity);
        return bookEntity;
    }

    @Override
    public BookEntity getById(long bookId)
    {
        return (BookEntity) this.sessionFactory.getCurrentSession().get(BookEntity.class, bookId);
    }

    @Override
    public List<BookEntity> getBooksByUser(long userId)
    {
        Query query = this.sessionFactory.getCurrentSession().createQuery("from BookEntity b where (b.checkedOutUser.userId = :userId)");
        query.setParameter("userId", userId);
        List<BookEntity> bookList = query.getResultList();
        return bookList;
    }

    @Override
    public List<BookEntity> getBooksByAuthor(String author)
    {
        Query query = this.sessionFactory.getCurrentSession().createQuery("from BookEntity b where (upper(b.bookAuthor) LIKE :author)");
        query.setParameter("author", "%" + author.toUpperCase() + "%");
        List<BookEntity> bookList = query.getResultList();
        return bookList;
    }

    @Override
    public List<BookEntity> getBooksByCategory(long categoryId)
    {
        Query query = this.sessionFactory.getCurrentSession().createQuery("from BookEntity b where (b.category.categoryId = :categoryId)");
        query.setParameter("categoryId", categoryId);
        List<BookEntity> bookList = query.getResultList();
        return bookList;
    }

    @Override
    public BookEntity update(BookEntity bookEntity)
    {
        this.sessionFactory.getCurrentSession().update(bookEntity);
        this.sessionFactory.getCurrentSession().flush();
        this.sessionFactory.getCurrentSession().refresh(bookEntity);
        return bookEntity;
    }

}
