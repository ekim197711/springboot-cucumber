package com.example.springbootcucumber.space.alien;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;
import java.util.Random;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class AlienControllerTest {

    @Autowired
    AlienController alienController;

    @Test
    void createAlien() throws InterruptedException {
        for (int i = 0; i < 500; i++) {
            new Thread(() -> {
                try {
                    Thread.sleep(Math.abs(new Random().nextInt() % 2000));
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                Alien alien = alienController.createAlien(Alien.builder()
                        .weight(200)
                        .height(100)
                        .type("Klingon")
                        .name("Adam")
                        .runSpeed(BigDecimal.TEN)
                        .build(), true);
                Assertions.assertThat(alien.getWeight()).isEqualTo(205);
            }).start();
            new Thread(() -> {
                try {
                    Thread.sleep(Math.abs(new Random().nextInt() % 2000));
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                Alien alienOther = alienController.createAlien(Alien.builder()
                        .weight(200)
                        .height(100)
                        .type("Klingon")
                        .name("Ole")
                        .runSpeed(BigDecimal.TEN)
                        .build(), false);
                Assertions.assertThat(alienOther.getWeight()).isEqualTo(200);
            }).start();
        }
        Thread.sleep(4000);
    }
}