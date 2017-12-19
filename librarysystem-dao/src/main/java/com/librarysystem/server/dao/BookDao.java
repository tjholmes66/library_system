package com.librarysystem.server.dao;

import java.util.List;

import com.librarysystem.server.domain.BookEntity;

public interface BookDao
{
    // CREATE
    BookEntity create(BookEntity bookEntity);

    // RETRIEVE
    BookEntity getById(long bookId);

    List<BookEntity> getBooksByUserId(long userId);

    List<BookEntity> getBooksByUsername(String username);

    List<BookEntity> getBooksByCategory(long categoryId);

    List<BookEntity> getBooksByAuthor(String author);

    List<BookEntity> searchBooks(String author, Long categoryId);

    // UPDATE
    BookEntity update(BookEntity bookEntity);

    // DELETE
}
