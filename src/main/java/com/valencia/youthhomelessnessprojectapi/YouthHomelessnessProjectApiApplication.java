package com.valencia.youthhomelessnessprojectapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

@SpringBootApplication(exclude = SecurityAutoConfiguration.class)
public class YouthHomelessnessProjectApiApplication {

    public static void main(String[] args) {
        SpringApplication.run(YouthHomelessnessProjectApiApplication.class, args);
    }

}