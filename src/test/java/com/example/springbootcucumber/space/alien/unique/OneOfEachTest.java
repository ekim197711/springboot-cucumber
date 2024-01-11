package com.example.springbootcucumber.space.alien.unique;

import com.example.springbootcucumber.space.alien.Alien;
import com.example.springbootcucumber.space.alien.AlienRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Map;
import java.util.stream.Collectors;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.NONE)
class OneOfEachTest {
    @Autowired
    AlienRepository alienRepository;

    private String key(Alien alien) {
        return "type:" + alien.getType() + "_name:" + alien.getFullName();
    }

    @Test
    void showOneOfEach() {
        Map<String, Alien> collect = alienRepository.findAll()
                .stream()
                .collect(
                        Collectors.toMap(this::key, a -> a, (a1, a2) -> a1)
                );
        System.out.println(collect);
        collect.forEach((key, value) -> {
            Assertions.assertThat(key).isNotNull();
            Assertions.assertThat(value).isNotNull();
            System.out.println("Key: " + key + ", Value: " + value);
        });

    }
}
