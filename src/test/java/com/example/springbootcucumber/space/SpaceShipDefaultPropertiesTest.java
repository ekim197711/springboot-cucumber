package com.example.springbootcucumber.space;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class SpaceShipDefaultPropertiesTest {

    @Autowired
    SpaceShipDefaultProperties spaceShipDefaultValues;

    @Test
    public void showConfigValues() {
        System.out.println(spaceShipDefaultValues);
    }
}