package com.example.petclinic_using_spring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScans;
import org.springframework.context.annotation.PropertySource;


@SpringBootApplication
//@PropertySource(value= {"classpath:application.properties"})
public class PetClinicUsingSpringApplication {

    public static void main(String[] args) {
        SpringApplication.run(PetClinicUsingSpringApplication.class, args);
    }

}
