package com.cognizant.handson1.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.cognizant.handson1.model.Country;

public interface CountryRepository extends JpaRepository<Country, String> {

}