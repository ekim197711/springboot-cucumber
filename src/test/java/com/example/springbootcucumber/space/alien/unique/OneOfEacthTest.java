package com.example.springbootcucumber.space.alien.unique;

import com.example.springbootcucumber.space.alien.Alien;
import com.example.springbootcucumber.space.alien.AlienRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Map;
import java.util.stream.Collectors;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.NONE)
public class OneOfEacthTest {
    @Autowired
    AlienRepository alienRepository;

    private String key(Alien alien) {
        return "type:" + alien.getType() + "_name:" + alien.getName();
    }

    @Test
    void showOneOfEach() {
        Map<String, Alien> collect = alienRepository.findAll()
                .stream()
                .collect(
                        Collectors.toMap(this::key, a -> a,
                                (a1, a2) -> {
                                    if (a1.getWeight() < a2.getWeight())
                                        return a1;
                                    else
                                        return a2;
                                })
                );
        System.out.println(collect);
        collect.entrySet().forEach(
                es -> System.out.println("Key: " + es.getKey() + ", Value: " + es.getValue())
        );
    }
}
