package com.example.springbootcucumber.space;

import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix = "space.ship.default")
public record SpaceShipDefaultProperties(
        Integer fuel,
        String name,
        Double maxSpeed
) {
}
