package com.example.springbootcucumber.space.alien;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import javax.persistence.PrePersist;

@Component
@Slf4j
public class WeightIncreaseEntityListener {


    @PrePersist
    public void justBeforePersist(Object object) {
        log.info("Listened for object with type {}", object.getClass().getSimpleName());
        if (object instanceof Alien alien) {
            alien.setWeight(alien.getWeight() + 5);
            log.info("Added weight to alien. Alien now looks like this: {}", alien);
        }
    }

}
