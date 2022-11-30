package com.danshin.calculatorLaw;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class CalculatorLawApplication { //extends SpringBootServletInitializer {
    public static void main(String[] args) {
        SpringApplication.run(CalculatorLawApplication.class, args);
    }

    /*@Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(CalculatorLawApplication.class);
    }*/
}
