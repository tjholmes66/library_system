package com.librarysystem.server.service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.librarysystem.server.dao.BookDao;
import com.librarysystem.server.domain.BookEntity;

@Transactional
@Service("bookService")
public class BookServiceImpl implements BookService
{

    private static final int RENEW_DAYS = 14;

    private static final Log logger = LogFactory.getLog(BookServiceImpl.class);

    @Autowired
    private BookDao bookDao;

    @Override
    public BookEntity create(BookEntity bookEntity)
    {
        BookEntity book = bookDao.create(bookEntity);
        return book;
    }

    @Override
    public BookEntity getById(long bookId)
    {
        BookEntity book = bookDao.getById(bookId);
        return book;
    }

    @Override
    public List<BookEntity> getBooksByUserId(long userId)
    {
        List<BookEntity> bookList = bookDao.getBooksByUserId(userId);
        return bookList;
    }

    @Override
    public List<BookEntity> getBooksByUsername(String username)
    {
        List<BookEntity> bookList = bookDao.getBooksByUsername(username);
        return bookList;
    }

    @Override
    public List<BookEntity> getBooksByCategory(long categoryId)
    {
        List<BookEntity> bookList = bookDao.getBooksByCategory(categoryId);
        return bookList;
    }

    @Override
    public List<BookEntity> getBooksByAuthor(String author)
    {
        List<BookEntity> bookList = bookDao.getBooksByAuthor(author);
        return bookList;
    }

    @Override
    public BookEntity update(BookEntity bookEntity)
    {
        BookEntity book = bookDao.update(bookEntity);
        return book;
    }

    @Override
    public BookEntity renewBookById(long bookId)
    {
        BookEntity book = bookDao.getById(bookId);
        LocalDate today = LocalDate.now();
        LocalDate checkedOutDate = today.plusDays(RENEW_DAYS);
        book.setCheckedOutDate(checkedOutDate);
        book = bookDao.update(book);
        return book;
    }

    @Override
    public List<BookEntity> searchBooks(String author, Long categoryId)
    {
        List<BookEntity> bookList = new ArrayList<BookEntity>();
        if (author != null && categoryId != null)
        {
            bookList = bookDao.searchBooks(author, categoryId);
        }
        else if (author == null && categoryId != null)
        {
            bookList = bookDao.getBooksByCategory(categoryId);
        }
        else if (author != null && categoryId == null)
        {
            bookList = bookDao.getBooksByAuthor(author);
        }
        return bookList;
    }

}
