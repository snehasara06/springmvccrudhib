package com.kgisl.springcrudsample.Dao;

import java.util.List;

import com.kgisl.springcrudsample.Model.Book;

public interface BookDao {
    void saveBook(Book book);

    List<Book> listBooks();

    void deleteBook(Long id);

    void updateBook(Book book);

    Book getBookById(Long id);
}
