package com.cognizant.service;

import com.cognizant.repository.BookRepository;

public class BookService {

    private BookRepository bookRepository;

    public BookService() {
        System.out.println("Book Service Created");
    }

    public void setBookRepository(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public void display() {
        if (bookRepository != null) {
            System.out.println("Book Repository Injected Successfully");
        }
    }

}