package com.example.AutoWorkShop;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@EnableScheduling
@SpringBootApplication
public class AutoWorkShopApplication {

    public static void main(String[] args) {
        SpringApplication.run(AutoWorkShopApplication.class, args);
    }

}
