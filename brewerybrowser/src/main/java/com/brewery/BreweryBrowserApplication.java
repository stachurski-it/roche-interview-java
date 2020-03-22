package com.brewery;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;

@SpringBootApplication
@ServletComponentScan
public class BreweryBrowserApplication {
    public static void main(String[] args) {
        SpringApplication.run(BreweryBrowserApplication.class, args);
    }
}
