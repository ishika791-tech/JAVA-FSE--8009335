package com.cognizant.springlearn.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AuthenticationController {

    @GetMapping("/")
    public String home() {
        return "Welcome to Spring Learn REST API";
    }

    @GetMapping("/authenticate")
    public String authenticate() {
        return "Authentication Successful";
    }

}