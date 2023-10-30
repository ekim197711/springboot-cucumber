package com.example.springbootcucumber.space.alien;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class AlienServiceTest {
    @Autowired
    AlienService alienService;

    @Test
    void aliensOfType() {
        try {
            alienService.aliensOfType("squid");
        } catch (AlienException e) {
            Assertions.assertThat(e.getMessage()).isEqualTo("No aliens where found with type squid");
        }
    }
}