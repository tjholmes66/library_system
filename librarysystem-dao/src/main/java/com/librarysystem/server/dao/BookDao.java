package com.librarysystem.server.dao;

import java.util.List;

import com.librarysystem.server.domain.BookEntity;

public interface BookDao
{
    // CREATE
    BookEntity create(BookEntity bookEntity);

    // RETRIEVE
    BookEntity getById(long bookId);

    List<BookEntity> getBooksByUser(long userId);

    List<BookEntity> getBooksByCategory(long categoryId);

    List<BookEntity> getBooksByAuthor(String author);

    // UPDATE
    BookEntity update(BookEntity bookEntity);

    // DELETE
}
