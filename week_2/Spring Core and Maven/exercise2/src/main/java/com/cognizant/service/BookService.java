package com.cognizant.service;

import com.cognizant.repository.BookRepository;

public class BookService {

    private BookRepository bookRepository;

    public void setBookRepository(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public void display() {

        System.out.println("Book Service Created");

        bookRepository.display();

    }

}