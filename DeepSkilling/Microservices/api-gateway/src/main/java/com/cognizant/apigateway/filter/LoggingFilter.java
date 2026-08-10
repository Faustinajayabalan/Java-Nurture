package com.cognizant.apigateway.filter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.gateway.server.mvc.filter.BeforeFilterFunctions;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class LoggingFilter {

    private static final Logger logger =
            LoggerFactory.getLogger(LoggingFilter.class);

    @Bean
    public BeforeFilterFunctions.BeforeFilterFunction logRequest() {
        return request -> {
            logger.info("Incoming Request: {}", request.uri());
            return request;
        };
    }
}