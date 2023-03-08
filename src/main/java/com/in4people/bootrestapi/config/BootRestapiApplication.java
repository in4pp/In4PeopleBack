package com.in4people.bootrestapi.config;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;


@SpringBootApplication
@ComponentScan("com.in4people.bootrestapi")
public class BootRestapiApplication {

    public static void main(String[] args) {
        SpringApplication.run(BootRestapiApplication.class, args);
    }

}
