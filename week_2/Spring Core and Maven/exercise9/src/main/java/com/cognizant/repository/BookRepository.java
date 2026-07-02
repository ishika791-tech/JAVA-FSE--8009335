package com.cognizant.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.cognizant.entity.Book;

public interface BookRepository extends JpaRepository<Book,Integer> {

}