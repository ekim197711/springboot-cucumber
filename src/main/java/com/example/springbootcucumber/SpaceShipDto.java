package com.example.springbootcucumber;

import java.io.Serializable;

/**
 * A DTO for the {@link com.example.springbootcucumber.space.SpaceShipEntity} entity
 */
public record SpaceShipDto(Integer id, String shipName, Integer fuel, Double maxSpeed) implements Serializable {
}