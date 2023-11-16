package com.example.springbootcucumber.space.alien;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;
import java.util.List;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.NONE)
class AlienDefaultDataTest {

    @Autowired
    AlienRepository alienRepository;


    @Test
    void weightSumStream() {
        List<Alien> all = alienRepository.findAll();
        Integer reducedValue = all.stream().mapToInt(Alien::getWeight).sum();
        System.out.printf("Sum value %s", reducedValue);
        Assertions.assertThat(reducedValue).isNotNull();
    }

    @Test
    void weightSumReduce() {
        List<Alien> all = alienRepository.findAll();

        BigDecimal precise = all.stream().map(Alien::getRunSpeed).reduce(BigDecimal.ZERO, BigDecimal::add);
        Assertions.assertThat(precise).isEqualTo(new BigDecimal("658.27"));
        System.out.printf("Sum value %s", precise);
    }

    @Test
    void createDefaultAliens() {
        List<Alien> all = alienRepository.findAll();
        int limit = 1500;
        int summedWeight = 0;
        for (Alien alien : all) {
            summedWeight += alien.getWeight();
        }
        System.out.printf("Summed weight = %s limit %s%n", summedWeight, limit);
        Assertions.assertThat(summedWeight).isPositive();
    }

    @Test
    void testCreateDefaultAliens() {
        Alien susan = alienRepository
                .findAll()
                .stream()
                .filter(a -> a.getName().equalsIgnoreCase("Susan"))
                .findFirst().orElseThrow();
        System.out.println("Susan: " + susan);
        Assertions.assertThat(susan.getName()).isEqualToIgnoringCase("Susan");
        Assertions.assertThat(susan.getWeight()).isEqualTo(75);
    }
}