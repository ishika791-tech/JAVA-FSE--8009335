package com.cognizant.handson6.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cognizant.handson6.model.Country;

public interface CountryRepository extends JpaRepository<Country, String> {

    Optional<Country> findByCode(String code);

    List<Country> findByNameContainingIgnoreCase(String name);

    // Query Method 1
    List<Country> findByNameContainingIgnoreCaseOrderByNameAsc(String name);

    // Query Method 2
    List<Country> findByNameStartingWith(String name);

}