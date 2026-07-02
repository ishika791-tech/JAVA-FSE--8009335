package com.cognizant.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.cognizant.entity.Book;
import com.cognizant.repository.BookRepository;

@RestController
@RequestMapping("/books")
public class BookController {

    @Autowired
    BookRepository repository;

    @GetMapping
    public List<Book> getBooks() {
        return repository.findAll();
    }

    @PostMapping
    public Book saveBook(@RequestBody Book book) {
        return repository.save(book);
    }
}