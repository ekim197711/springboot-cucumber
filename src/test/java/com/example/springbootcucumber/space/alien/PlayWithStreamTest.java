package com.example.springbootcucumber.space.alien;

import org.junit.jupiter.api.Test;

import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;


public class PlayWithStreamTest {

    @Test
    public void trySomethingWithStreams() {
        Map<String, String> map = Stream.of(
                        Alien.builder().type("Wookie").fullName("Fazle").build(),
                        Alien.builder().type("Wookie").fullName("Ben").build(),
                        Alien.builder().type("Wookie").fullName("Josh").build(),
                        Alien.builder().type("Wookie").fullName("Mike").build(),
                        Alien.builder().type("Wookie").fullName("Mike Nielsen").build(),
                        Alien.builder().type("Wookie").fullName("Mohsen").build()
                )
                .filter((a) -> a.getFullName().length() <= 14)
                .collect(Collectors.toMap(
                        Alien::getType,
                        Alien::getFullName
                        , (String alien1, String alien2) -> {
                            if (alien1.length() > alien2.length())
                                return alien1;
                            return alien2;
                        }));
        System.out.println(map);
    }

    private String convertAlienToString(Alien alien) {
        return "This is an Alien " + alien.getFullName() + " with name length "
                + alien.getFullName().length();
    }
}
