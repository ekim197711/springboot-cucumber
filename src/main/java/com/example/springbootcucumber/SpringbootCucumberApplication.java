package com.example.springbootcucumber;

import com.example.springbootcucumber.space.SpaceShipDefaultProperties;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@SpringBootApplication
@EnableConfigurationProperties(value = {SpaceShipDefaultProperties.class})
public class SpringbootCucumberApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringbootCucumberApplication.class, args);
    }

}
