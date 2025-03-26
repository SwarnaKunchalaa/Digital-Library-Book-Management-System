package com.ajackus.library;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class DigitalLibraryBookManagementSystemApplication {

    public  static ConfigurableApplicationContext context;

    public static void main(String[] args) {
        context = SpringApplication.run(DigitalLibraryBookManagementSystemApplication.class, args);
    }

}
