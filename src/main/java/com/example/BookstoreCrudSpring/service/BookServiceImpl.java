package com.example.BookstoreCrudSpring.service;

import com.example.BookstoreCrudSpring.model.Book;
import com.example.BookstoreCrudSpring.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookServiceImpl implements BookService {

    @Autowired
    private BookRepository bookRepository;

    @Override
    public List<Book> getAllBooks() {
        return bookRepository.findAll();
    }

    @Override
    public void addBook(Book book) {
        bookRepository.save(book);
    }

    @Override
    public Book getBookById(long id) {
        Optional<Book> optionalBook = bookRepository.findById(id);
        Book book = null;
        if (optionalBook.isPresent()) {
            book = optionalBook.get();
        } else
            throw new RuntimeException("Not found id = " + id);
        return book;
    }


    @Override
    public void deleteBook(long id) {
        bookRepository.deleteById(id);
    }


}
