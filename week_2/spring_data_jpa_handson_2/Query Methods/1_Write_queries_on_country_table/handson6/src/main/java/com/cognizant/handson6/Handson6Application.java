package com.cognizant.handson6;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

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

        testSearchCountry();
        testSearchCountrySorted();
        testCountriesStartingWith();

        LOGGER.info("End");
    }

    private static void testSearchCountry() {

        LOGGER.info("Countries containing 'ou'");

        List<Country> countries = countryService.searchCountry("ou");

        countries.forEach(country -> LOGGER.debug("{}", country));
    }

    private static void testSearchCountrySorted() {

        LOGGER.info("Countries containing 'ou' in ascending order");

        List<Country> countries = countryService.searchCountrySorted("ou");

        countries.forEach(country -> LOGGER.debug("{}", country));
    }

    private static void testCountriesStartingWith() {

        LOGGER.info("Countries starting with 'Z'");

        List<Country> countries = countryService.getCountriesStartingWith("Z");

        countries.forEach(country -> LOGGER.debug("{}", country));
    }
}