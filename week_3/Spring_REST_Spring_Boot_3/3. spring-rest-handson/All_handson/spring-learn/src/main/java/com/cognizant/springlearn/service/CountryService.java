package com.cognizant.springlearn.service;

import java.util.ArrayList;
import java.util.List;

import com.cognizant.springlearn.model.Country;

public class CountryService {

    public List<Country> getAllCountries() {

        List<Country> list = new ArrayList<>();

        list.add(new Country("IN", "India"));
        list.add(new Country("US", "United States"));
        list.add(new Country("JP", "Japan"));

        return list;
    }

}