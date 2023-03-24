package com.tsj.es;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringBootESApplication {
    public static void main(String[] args) {
        SpringApplication r = new SpringApplication(SpringBootESApplication.class);
        r.run(args);
    }
}
