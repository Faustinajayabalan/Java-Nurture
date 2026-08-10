package com.cognizant.ormlearn;

import java.util.List;
import com.cognizant.ormlearn.service.exception.CountryNotFoundException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import org.springframework.context.ApplicationContext;

import com.cognizant.ormlearn.model.Country;
import com.cognizant.ormlearn.service.CountryService;
import com.cognizant.ormlearn.repository.StockRepository;

@SpringBootApplication
public class OrmLearnApplication {

    private static final Logger LOGGER = LoggerFactory.getLogger(OrmLearnApplication.class);

    private static CountryService countryService;
    
    private static StockRepository stockRepository;

    public static void main(String[] args) {

        ApplicationContext context = SpringApplication.run(OrmLearnApplication.class, args);

        countryService = context.getBean(CountryService.class);

        LOGGER.info("Inside Main");

        // Uncomment ONE method at a time

        //testGetCountry();

        //testAddCountry();

        //testUpdateCountry();

        //testDeleteCountry();

        //testSearchCountry();
        
        //testFindCountryByCode();
        
        testGetCountriesStartingWith();

    }

    private static void testGetAllCountries() {

        LOGGER.info("Start");

        List<Country> countries = countryService.getAllCountries();

        LOGGER.debug("Countries={}", countries);

        LOGGER.info("End");

    }
    
    private static void testGetCountry() {

        LOGGER.info("Start");

        Country country = countryService.getCountry("IN");

        LOGGER.debug("Country={}", country);

        LOGGER.info("End");

    }
    
    private static void testAddCountry() {

        LOGGER.info("Start");

        Country country = new Country();

        country.setCode("NP");

        country.setName("Nepal");

        countryService.addCountry(country);

        try {

            Country result = countryService.findCountryByCode("NP");

            LOGGER.debug("Country={}", result);

        } catch (CountryNotFoundException e) {

            LOGGER.error(e.getMessage());

        }

        LOGGER.info("End");

    }
    
    private static void testUpdateCountry() {

        LOGGER.info("Start");

        try {

            countryService.updateCountry(
                    "NP",
                    "Updated CTS Country");

            Country country =
                    countryService.findCountryByCode("NP");

            LOGGER.debug("Country={}", country);

        } catch (CountryNotFoundException e) {

            LOGGER.error(e.getMessage());

        }

        LOGGER.info("End");

    }
    
    private static void testDeleteCountry() {

        LOGGER.info("Start");

        countryService.deleteCountry("NP");

        LOGGER.info("Country Deleted");

        LOGGER.info("End");

    }
    
    private static void testSearchCountry() {

        LOGGER.info("Start");

        LOGGER.debug("Countries={}", countryService.searchCountry("ou"));

        LOGGER.info("End");

    }
    
    private static void testFindCountryByCode() {

        LOGGER.info("Start");

        try {

            Country country =
                    countryService.findCountryByCode("IN");

            LOGGER.debug("Country={}", country);

        } catch (CountryNotFoundException e) {

            LOGGER.error(e.getMessage());

        }

        LOGGER.info("End");

    }
    
    private static void testGetCountriesStartingWith() {

        LOGGER.info("Start");

        List<Country> countries =
                countryService.getCountriesStartingWith("Z");

        LOGGER.debug("Countries={}", countries);

        LOGGER.info("End");

    }
    
    private static void testFacebookStocks() {

        LOGGER.info("Start");

        List<Stock> stocks=
                stockRepository.findByCodeAndDateBetween(

                        "FB",

                        LocalDate.of(2019,9,1),

                        LocalDate.of(2019,9,30));

        LOGGER.debug("Stocks={}",stocks);

        LOGGER.info("End");

    }
}