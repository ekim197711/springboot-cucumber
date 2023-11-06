package com.example.springbootcucumber.space.alien;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

class CollectorsTest {
    final Alien mike = Alien.builder()
            .type("Wookie")
            .name("Mike")
            .height(12)
            .weight(120)
            .build();
    final Alien rancor = Alien.builder()
            .type("Rancor")
            .name("Poul")
            .height(289)
            .weight(5000)
            .build();


    final Alien brian = Alien.builder()
            .type("Wookie")
            .name("Brian")
            .height(14)
            .weight(124)
            .build();
    final List<Alien> aliens = List.of(
            mike,
            brian,
            Alien.builder()
                    .type("Ewok")
                    .name("Paulina")
                    .height(4)
                    .weight(33)
                    .build(),
            rancor
    );

    @Test
    @DisplayName("Collectors test")
    void collectorsTest() {
        Integer stackedOnTopOfEachOther = aliens.stream().mapToInt(Alien::getHeight).sum();

        Integer stackedSecond = aliens.stream().mapToInt(Alien::getHeight).sum();

        final int EXPECTED_VALUE = 319;

        Assertions.assertThat(stackedOnTopOfEachOther)
                .as("Stacked first one")
                .isEqualTo(EXPECTED_VALUE);

        Assertions.
                assertThat(stackedSecond)
                .as("Second assertions")
                .isEqualTo(EXPECTED_VALUE);


    }

    @Test
    @DisplayName("Collectors joining string")
    void collectorsJoiningTest() {
        String namesPutTogether = aliens.stream()
                .map(Alien::getName)
                .collect(Collectors.joining(" - "));
        Assertions.assertThat(namesPutTogether)
                .isEqualTo("Mike - Brian - Paulina - Poul");
    }

    @Test
    @DisplayName("Collectors Grouping")
    void collectorsGroupTest() {
        Map<String, List<Alien>> collect =
                aliens.stream().collect(Collectors.groupingBy(Alien::getType));

        Assertions.assertThat(collect.get("Wookie"))
                .contains(mike)
                .contains(brian);
        collect.forEach((key, value) -> System.out.println(key + " - " + value));
    }

    @Test
    @DisplayName("Collectors Partioning")
    void collectorsPartionTest() {
        Map<Boolean, List<Alien>> collect = aliens.stream()
                .collect(Collectors.partitioningBy(a -> mike.getWeight() > 100));

        Assertions.assertThat(collect.get(true))
                .contains(mike)
                .contains(brian)
                .contains(rancor);

        collect.forEach((key, value) -> System.out.println(key + " - " + value));
    }
}