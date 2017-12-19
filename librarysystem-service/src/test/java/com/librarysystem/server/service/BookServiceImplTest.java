package com.librarysystem.server.service;

import java.time.LocalDate;
import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.librarysystem.server.dao.BookDao;
import com.librarysystem.server.domain.BookEntity;
import com.librarysystem.server.domain.UserEntity;

public class BookServiceImplTest extends BaseServiceTests
{
    @Autowired
    private BookService bookService;

    protected void setUp() throws Exception
    {
        System.out.println("setup: Loading application context");
        System.out.println("setup: Done loading application context");
    }

    protected void tearDown() throws Exception
    {
        super.tearDown();
        System.out.println("tearDown: START");
        System.out.println("tearDown: FINISH");
    }

    @Autowired
    private BookDao bookDao;

    // List<BookEntity> getBooksByUserId(long userId);
    @Test
    public void testGetBooksByUserId()
    {
        long userId = 1;
        List<BookEntity> bookList = bookService.getBooksByUserId(userId);
        assertNotNull(bookList);
        assertEquals(1, bookList.size());
    }

    // List<BookEntity> getBooksByUsername(String username);
    @Test
    public void testGetBooksByUsername()
    {
        String username = "tholmes";
        List<BookEntity> bookList = bookService.getBooksByUsername(username);
        assertNotNull(bookList);
        assertEquals(1, bookList.size());
    }

    // List<BookEntity> getBooksByCategory(String categoryId);
    @Test
    public void testGetBooksByCategory()
    {
        long categoryId = 3;
        List<BookEntity> bookList = bookService.getBooksByCategory(categoryId);
        assertNotNull(bookList);
        assertEquals(2, bookList.size());
    }

    // List<BookEntity> getBooksByAuthor(String author);
    @Test
    public void testGetBooksByAuthor()
    {
        String author = "Tolk";
        List<BookEntity> bookList = bookService.getBooksByAuthor(author);
        assertNotNull(bookList);
        assertEquals(2, bookList.size());
    }

    // BookEntity update(BookEntity bookEntity);
    @Test
    public void testUpdate()
    {
        long bookId = 2;
        BookEntity book = bookService.getById(bookId);
        assertNotNull(book);
        assertEquals(bookId, book.getBookId());

        book.setCheckedOutDate(LocalDate.now());
        UserEntity user = new UserEntity();
        user.setUserId(2);
        book.setCheckedOutUser(user);

        book = bookService.update(book);
        assertNotNull(book);
        assertEquals(2, book.getCheckedOutUser().getUserId());
    }

    // public BookEntity renewBookById(long bookId);
    @Test
    public void testRenewBookById()
    {
        long bookId = 2;
        BookEntity book = bookService.renewBookById(bookId);
        assertNotNull(book);
        assertEquals(bookId, book.getBookId());
    }

}
