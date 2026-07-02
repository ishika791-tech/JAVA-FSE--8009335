package com.cognizant.handson5;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.cognizant.handson5.model.Country;
import com.cognizant.handson5.service.CountryService;

@SpringBootApplication
public class Handson5Application {

    private static final Logger LOGGER =
            LoggerFactory.getLogger(Handson5Application.class);

    private static CountryService countryService;

    public static void main(String[] args) {

        ApplicationContext context =
                SpringApplication.run(Handson5Application.class, args);

        countryService = context.getBean(CountryService.class);

        LOGGER.info("Start");

        testGetAllCountries();
        testFindCountryByCode();
        testAddCountry();
        testUpdateCountry();
        testDeleteCountry();
        testFindCountriesByPartialName();

        LOGGER.info("End");
    }

    private static void testGetAllCountries() {
        List<Country> countries = countryService.getAllCountries();
        LOGGER.info("Countries: {}", countries);
    }

    private static void testFindCountryByCode() {
        Country country = countryService.findCountryByCode("IN");
        LOGGER.info("Country: {}", country);
    }

    private static void testAddCountry() {
        Country country = new Country();
        country.setCode("ZZ");
        country.setName("Test Country");
        countryService.addCountry(country);
        LOGGER.info("Country Added");
    }

    private static void testUpdateCountry() {
        Country country = new Country();
        country.setCode("ZZ");
        country.setName("Updated Country");
        countryService.updateCountry(country);
        LOGGER.info("Country Updated");
    }

    private static void testDeleteCountry() {
        countryService.deleteCountry("ZZ");
        LOGGER.info("Country Deleted");
    }

    private static void testFindCountriesByPartialName() {
        List<Country> countries =
                countryService.findCountriesByPartialName("Uni");
        LOGGER.info("Matching Countries: {}", countries);
    }
}