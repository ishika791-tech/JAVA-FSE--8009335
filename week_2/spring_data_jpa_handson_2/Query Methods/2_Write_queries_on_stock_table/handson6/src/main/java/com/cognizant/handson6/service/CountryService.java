package com.cognizant.handson6.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cognizant.handson6.exception.CountryNotFoundException;
import com.cognizant.handson6.model.Country;
import com.cognizant.handson6.repository.CountryRepository;

@Service
public class CountryService {

    private final CountryRepository countryRepository;

    public CountryService(CountryRepository countryRepository) {
        this.countryRepository = countryRepository;
    }

    @Transactional(readOnly = true)
    public List<Country> getAllCountries() {
        return countryRepository.findAll();
    }

    @Transactional(readOnly = true)
    public Country findCountryByCode(String code) throws CountryNotFoundException {

        Country country = countryRepository.findByCode(code).orElse(null);

        if (country == null) {
            throw new CountryNotFoundException("Country not found");
        }

        return country;
    }

    @Transactional
    public Country addCountry(Country country) {
        return countryRepository.save(country);
    }

    @Transactional
    public Country updateCountry(Country country) {
        return countryRepository.save(country);
    }

    @Transactional
    public void deleteCountry(String code) {
        countryRepository.deleteById(code);
    }

    @Transactional(readOnly = true)
    public List<Country> findCountriesByPartialName(String name) {
        return countryRepository.findByNameContainingIgnoreCase(name);
    }

    @Transactional(readOnly = true)
    public List<Country> searchCountry(String text) {
        return countryRepository.findByNameContainingIgnoreCase(text);
    }

    @Transactional(readOnly = true)
    public List<Country> searchCountrySorted(String text) {
        return countryRepository.findByNameContainingIgnoreCaseOrderByNameAsc(text);
    }

    @Transactional(readOnly = true)
    public List<Country> getCountriesStartingWith(String alphabet) {
        return countryRepository.findByNameStartingWith(alphabet);
    }
}