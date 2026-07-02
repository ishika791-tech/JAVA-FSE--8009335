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

        testAddCountry();

        LOGGER.info("End");
    }

    private static void testAddCountry() {

        Country country = new Country();

        country.setCode("ZZ");
        country.setName("Test Country");

        countryService.addCountry(country);

        try {

            Country result = countryService.findCountryByCode("ZZ");

            LOGGER.debug("Country: {}", result);

        } catch (CountryNotFoundException e) {

            LOGGER.error(e.getMessage());

        }

    }
}