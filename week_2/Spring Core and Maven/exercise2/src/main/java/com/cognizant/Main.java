package com.cognizant;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.cognizant.service.BookService;

public class Main {

    public static void main(String[] args) {

        ClassPathXmlApplicationContext context =
                new ClassPathXmlApplicationContext("applicationContext.xml");

        BookService service =
                context.getBean("bookService", BookService.class);

        service.display();
        
        context.close();
    }

}