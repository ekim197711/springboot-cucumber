package com.example.springbootcucumber.space.alien;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.List;

class AlienAssertJTest {

    @Test
    @DisplayName("Test on aliens")
    void trySomething() {
        Alien mike = new Alien(null, "Human", "Mike", 123, BigDecimal.ZERO, 122);

        Alien mike1 = Alien.builder().fullName("Mike")
                .weight(75)
                .build();
        
        List<Alien> aliens = List.of(
                mike,
                new Alien(null, "Wookie", "Chewie", 1232, BigDecimal.ZERO, 1232),
                new Alien(null, "Squid", "Susan", 12, BigDecimal.ZERO, 12),
                new Alien(null, "Droid", "R2D2", 1223, BigDecimal.ZERO, 100),
                new Alien(null, "Droid", "C3PO", 90, BigDecimal.ZERO, 90)
        );

        Assertions.assertThat(aliens)
                .as("Test if the aliens have duplicates")
                .withFailMessage("Hey don't use duplicates dummy. List count " + aliens.size())
                .doesNotHaveDuplicates()
                .hasSize(5)
                .contains(mike);

        Alien alien = aliens.get(0);
        Assertions.assertThat(alien)
                .isIn(aliens)
                .satisfies(a ->
                        Assertions.assertThat(a.getFullName()).isEqualToIgnoringCase("mike")
                );

        Assertions.assertThat(alien.getType())
                .describedAs("Check this alien " + alien)
                .isNotBlank();

        Assertions.assertThat(aliens)
                .filteredOn("type", Assertions.in("Droid", "Human"))
                .hasSize(3);
    }

}
