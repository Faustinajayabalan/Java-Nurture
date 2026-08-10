package com.cognizant.ormlearn.service;

import java.util.List;
import java.util.Optional;
import com.cognizant.ormlearn.service.exception.CountryNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cognizant.ormlearn.model.Country;
import com.cognizant.ormlearn.repository.CountryRepository;

import jakarta.transaction.Transactional;

@Service
public class CountryService {

    @Autowired
    private CountryRepository repository;

    @Transactional
    public List<Country> getAllCountries() {

        return repository.findAll();

    }

    @Transactional
    public Country getCountry(String code) {

        return repository.findByCode(code).orElse(null);

    }

    @Transactional
    public void addCountry(Country country) {

        repository.save(country);

    }

    @Transactional
    public void updateCountry(String code, String name)
            throws CountryNotFoundException {

        Country country = findCountryByCode(code);

        country.setName(name);

        repository.save(country);

    }

    @Transactional
    public void deleteCountry(String code) {

        repository.deleteById(code);

    }
    

    @Transactional
    public List<Country> searchCountry(String text) {

    	return repository.findByNameContainingOrderByNameAsc(text);
    }
    
    
    @Transactional
    public List<Country> getCountriesStartingWith(String alphabet) {

        return repository.findByNameStartingWith(alphabet);

    }
    
    @Transactional
    public Country findCountryByCode(String countryCode)
            throws CountryNotFoundException {

        Optional<Country> result =
                repository.findById(countryCode);

        if (!result.isPresent()) {

            throw new CountryNotFoundException(
                    "Country with code "
                            + countryCode
                            + " not found");

        }

        return result.get();

    }

}