package me.mdzs.apartmentbooking.app.spring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("me.mdzs.apartmentbooking.app.spring.controller")
public class MySpringBootApplication {

    public MySpringBootApplication() {
    }

    public static void main(String[] args) {
        SpringApplication.run(MySpringBootApplication.class, args);
    }
}
