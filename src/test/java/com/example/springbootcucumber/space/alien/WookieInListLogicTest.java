package com.example.springbootcucumber.space.alien;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

class WookieInListLogicTest {
    final List<Alien> aliens = List.of(
            Alien.builder()
                    .type("Wookie")
                    .name("Mike")
                    .build(),
            Alien.builder()
                    .type("Wookie")
                    .name("Brian")
                    .build(),
            Alien.builder()
                    .type("Ewok")
                    .name("Paulina")
                    .build(),
            Alien.builder()
                    .type("Rancor")
                    .name("Poul")
                    .build()
    );

    @Test
    void containsWookiesOldFashion() {
        boolean containsWookiesOldFashion = new WookieInListLogic(aliens).containsWookiesOldFashion();
        Assertions.assertThat(containsWookiesOldFashion).isTrue();
    }

    @Test
    void containsWookie() {
        boolean containsWookie = new WookieInListLogic(aliens).containsWookie();
        Assertions.assertThat(containsWookie).isTrue();

        boolean wookie = new WookieLogic(null).isWookie();
        Assertions.assertThat(wookie).isFalse();
    }
}