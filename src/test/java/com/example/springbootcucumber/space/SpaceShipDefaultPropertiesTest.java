package com.example.springbootcucumber.space;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class SpaceShipDefaultPropertiesTest {

    @Autowired
    SpaceShipDefaultProperties spaceShipDefaultValues;

    @Test
    void showConfigValues() {
        System.out.println(spaceShipDefaultValues);
        Assertions.assertThat(spaceShipDefaultValues).isNotNull();
    }
}