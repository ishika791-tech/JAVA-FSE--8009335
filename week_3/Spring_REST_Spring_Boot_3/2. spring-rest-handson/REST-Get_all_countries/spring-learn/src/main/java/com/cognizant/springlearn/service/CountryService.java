package com.cognizant.springlearn.service;

import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Service;

import com.cognizant.springlearn.model.Country;

@Service
public class CountryService {

    public Country getCountry(String code) {

        try (ClassPathXmlApplicationContext context =
                     new ClassPathXmlApplicationContext("country.xml")) {

            if ("IN".equalsIgnoreCase(code)) {
                return context.getBean("in", Country.class);
            } else if ("US".equalsIgnoreCase(code)) {
                return context.getBean("us", Country.class);
            }

            return null;
        }
    }
}