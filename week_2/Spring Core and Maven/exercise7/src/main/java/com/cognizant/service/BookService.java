package com.cognizant.service;

import com.cognizant.repository.BookRepository;

public class BookService {

    private String libraryName;
    private BookRepository bookRepository;

    // Constructor Injection
    public BookService(String libraryName) {
        this.libraryName = libraryName;
    }

    // Setter Injection
    public void setBookRepository(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public void display() {

        System.out.println("Library Name : " + this.libraryName);

        if (bookRepository != null) {
            System.out.println("Book Repository Injected Successfully");
        }
    }
}