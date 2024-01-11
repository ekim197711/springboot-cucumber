package com.example.springbootcucumber.space.humaniod;


import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

/**
 * KAN-3 jira
 * https://codeinvestigator.atlassian.net/browse/KAN-3
 */
//@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.NONE)

class HumainiodTest {

    Humanoid humanoid = new Humanoid(null, "Human", "Mike", 100, new BigDecimal("200"),
            120);

    @DisplayName("A Humanoid type need to to do all the same same things as the Alien type")
    @Test
    void doSameAsAlien() {
        String result = humanoid.beamUp("apple");
        org.assertj.core.api.Assertions.assertThat(result)
                .isEqualToIgnoringCase("Woppa woppa woppa we are beaming up apple");
    }

    @DisplayName("The Humanoid is able to speak")
    @Test
    void speak() {
        final String result = humanoid.saySomething("electronics");
        Assertions.assertThat(result)
                .isEqualToIgnoringCase("I need stuff with galaxy light in it... Like my keyboard!");
        final String weather = humanoid.saySomething("weather");
        Assertions.assertThat(weather).isEqualToIgnoringCase("Nice weather today!");
    }

    @DisplayName("KAN-3 The Humanoid is able to grab and hold stuff")
    @Test
    void grabAndHold() {
        Assertions.assertThat(
                humanoid.grapStuff("Apple")
        ).isEqualToIgnoringCase("Holding an Apple");
    }

    @DisplayName("KAN-3 The Humanoid should be able to think deep thoughts.")
    @Test
    void deepThoughts() {
        Assertions.assertThat(
                humanoid.lightThoughts("Apple")
        ).isEqualToIgnoringCase("Having deep thoughts about Apple");
    }

}
