package com.example.springbootconditional;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;


@SpringBootApplication
@ComponentScan(basePackages = {"com.example"})
public class SpringBootConditionalApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringBootConditionalApplication.class, args);
    }

}

