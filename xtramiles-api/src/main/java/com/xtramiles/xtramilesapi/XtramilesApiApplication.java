package com.xtramiles.xtramilesapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(exclude = {
        org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration.class})
public class XtramilesApiApplication {

    public static void main(String[] args) {
        SpringApplication.run(XtramilesApiApplication.class, args);
    }

}
