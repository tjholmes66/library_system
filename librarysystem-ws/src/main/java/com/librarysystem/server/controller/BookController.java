package com.librarysystem.server.controller;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.librarysystem.server.domain.BookEntity;
import com.librarysystem.server.service.BookService;

@Controller
@RequestMapping("/books")
public class BookController extends BaseController
{
    private static final Log logger = LogFactory.getLog(BookController.class);

    @Autowired
    private BookService service;

    // BookEntity getById(long bookId);

    // List<BookEntity> getBooksByUser(long userId);

    // List<BookEntity> getBooksByCategory(long categoryId);

    // List<BookEntity> getBooksByAuthor(String author);

    @RequestMapping(value = "/{bookId}", method = RequestMethod.GET, headers = "Accept=application/json")
    public @ResponseBody BookEntity getBookById(@PathVariable("bookId") long bookId)
    {
        logger.debug("LocationController: START: getBookById: bookId=" + bookId);
        User user = authenticate();
        BookEntity bookEntity = service.getById(bookId);
        logger.debug("LocationController: FINISH: getBookById: bookEntity=" + bookEntity);
        invalidateUser();
        return bookEntity;
    }

    @RequestMapping(value = "/categoryId/{categoryId}", method = RequestMethod.GET, headers = "Accept=application/json")
    public @ResponseBody List<BookEntity> getBookListByCategory(@PathVariable("categoryId") long categoryId)
    {
        logger.debug("LocationController: START: getBookListByCategory: categoryId=" + categoryId);
        User user = authenticate();
        List<BookEntity> bookList = service.getBooksByCategory(categoryId);
        logger.debug("LocationController: FINISH: getBookListByCategory: bookList=" + bookList.size());
        invalidateUser();
        return bookList;
    }

    @RequestMapping(value = "/author/{author}", method = RequestMethod.GET, headers = "Accept=application/json")
    public @ResponseBody List<BookEntity> getBookListByAuthor(@PathVariable("author") String author)
    {
        logger.debug("LocationController: START: getBookListByAuthor: author=" + author);
        User user = authenticate();
        List<BookEntity> bookList = service.getBooksByAuthor(author);
        logger.debug("LocationController: FINISH: getBookListByAuthor: bookList=" + bookList.size());
        invalidateUser();
        return bookList;
    }

}
