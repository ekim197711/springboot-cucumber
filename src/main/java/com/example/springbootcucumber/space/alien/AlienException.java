package com.example.springbootcucumber.space.alien;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

@RequiredArgsConstructor
@Getter
@ToString
public class AlienException extends Exception {
    private final String message;
}
