package com.example.L08_spring_boot_demo;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class FlightSearchService {

    @Value("${indigo.url}")
    private String indigoUrl;

    public String callIndigoAPIForData(){

        /*
        API call to Indigo to get flight data
        1. Developer Machine: dev-testing-API
        2. Stage Env.: stage-API (Testing)
        3. live Env.: live-API (Production)
        4. Mock API: mockindigo.com (Mocking Indigo API for testing)
         */
        System.out.println(indigoUrl);
        return indigoUrl;
    }
}
