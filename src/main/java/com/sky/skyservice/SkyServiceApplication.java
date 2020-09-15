package com.sky.skyservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@EnableConfigurationProperties
@SpringBootApplication(scanBasePackages = "com.sky")
public class SkyServiceApplication {
    public static void main(String[] args) {
        SpringApplication.run(SkyServiceApplication.class, args);
    }

}
