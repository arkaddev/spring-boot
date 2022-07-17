package com.example.BookstoreCrudSpring.service;

import com.example.BookstoreCrudSpring.model.Book;

import java.util.List;

public interface BookService {

    List<Book> getAllBooks();
    void addBook(Book book);

    Book getBookById(long id);


    void deleteBook(long id);
}
