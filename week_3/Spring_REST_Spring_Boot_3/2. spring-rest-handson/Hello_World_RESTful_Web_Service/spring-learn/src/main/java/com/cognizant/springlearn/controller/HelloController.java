package com.cognizant.springlearn.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @GetMapping("/hello")
    public String sayHello() {

        System.out.println("Start");

        String message = "Hello World!!";

        System.out.println("End");

        return message;
    }
}