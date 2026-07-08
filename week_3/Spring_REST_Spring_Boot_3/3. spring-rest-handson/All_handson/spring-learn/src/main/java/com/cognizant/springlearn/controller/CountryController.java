package com.cognizant.springlearn.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cognizant.springlearn.model.Country;
import com.cognizant.springlearn.service.CountryService;

@RestController
public class CountryController {

    private CountryService service = new CountryService();

    @GetMapping("/countries")
    public List<Country> getAllCountries() {
        return service.getAllCountries();
    }

}