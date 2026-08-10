package com.cognizant.spring_learn.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AuthenticationController {

    @GetMapping("/authenticate")
    public Map<String,String> authenticate() {

        Map<String,String> response = new HashMap<>();

        response.put(
                "token",
                "eyJhbGciOiJIUzI1NiJ9.demo.jwt.token");

        return response;
    }
}