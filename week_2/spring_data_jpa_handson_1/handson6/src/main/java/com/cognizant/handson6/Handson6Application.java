package com.cognizant.handson6;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.cognizant.handson6.exception.CountryNotFoundException;
import com.cognizant.handson6.model.Country;
import com.cognizant.handson6.service.CountryService;

@SpringBootApplication
public class Handson6Application {

    private static final Logger LOGGER =
            LoggerFactory.getLogger(Handson6Application.class);

    private static CountryService countryService;

    public static void main(String[] args) {

        ApplicationContext context =
                SpringApplication.run(Handson6Application.class, args);

        LOGGER.info("Start");

        countryService = context.getBean(CountryService.class);

        testFindCountryByCode();

        LOGGER.info("End");
    }

    private static void testFindCountryByCode() {

        try {

            Country country = countryService.findCountryByCode("IN");

            LOGGER.debug("Country: {}", country);

        } catch (CountryNotFoundException e) {

            LOGGER.error(e.getMessage());

        }

    }
}