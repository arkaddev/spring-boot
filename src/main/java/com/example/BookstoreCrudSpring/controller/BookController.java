package com.example.BookstoreCrudSpring.controller;

import com.example.BookstoreCrudSpring.model.Book;
import com.example.BookstoreCrudSpring.repository.BookRepository;
import com.example.BookstoreCrudSpring.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

import java.util.Optional;

@Controller
public class BookController {

    @Autowired
    private BookService bookService;

    @Autowired
    private BookRepository bookRepository;

    @GetMapping("")
    public String showBooks(Model model) {
        bookService.getAllBooks();
        model.addAttribute("booksValue", bookService.getAllBooks());
        return "index";
    }

    @GetMapping("/showNewBookForm")
    public String showNewBookForm(Model model) {
        Book book = new Book();
        model.addAttribute("bookValue", book);
        return "new_book";
    }

    @PostMapping("/saveBook")
    public String saveBook(Book book) {
        bookService.addBook(book);
        return "redirect:/";
    }

    @GetMapping("/showFormForUpdate/{id}")
    public String showFormForUpdate(@PathVariable long id, Model model) {
        bookService.getBookById(id);
        model.addAttribute("oneBookValue", bookService.getBookById(id));
        return "update_book";
    }


    @GetMapping("/deleteBook/{id}")
    public String deleteBook(@PathVariable long id) {
        bookService.deleteBook(id);
        return "redirect:/";
    }


}
