package com.example.springbootcucumber.space.alien;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum AlienType {
    WOOKIE("Wookie"),
    MARTIAN("Martian"),
    EWOK("Ewok");
    private final String type;
}
