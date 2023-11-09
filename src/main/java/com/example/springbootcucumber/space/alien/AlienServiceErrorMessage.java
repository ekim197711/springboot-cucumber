package com.example.springbootcucumber.space.alien;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
@SuppressWarnings("java:S6548")
public enum AlienServiceErrorMessage {
    ALIEN_NO_TYPE("No aliens where found with type %s");
    private final String message;

    public String oneArgument(String argument) {
        return String.format(message, argument);
    }
}
