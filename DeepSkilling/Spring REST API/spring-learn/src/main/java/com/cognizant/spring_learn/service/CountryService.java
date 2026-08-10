package com.cognizant.spring_learn.service;

import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Service;

import com.cognizant.spring_learn.Country;

@Service
public class CountryService {

    List<Country> countries = Arrays.asList(
            createCountry("IN", "India"),
            createCountry("US", "United States"),
            createCountry("JP", "Japan")
    );

    private Country createCountry(String code, String name) {
        Country c = new Country();
        c.setCode(code);
        c.setName(name);
        return c;
    }

    public Country getCountry(String code) {

        for (Country c : countries) {
            if (c.getCode().equalsIgnoreCase(code)) {
                return c;
            }
        }

        return null;
    }
}