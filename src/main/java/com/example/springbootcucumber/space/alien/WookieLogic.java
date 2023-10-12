package com.example.springbootcucumber.space.alien;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class WookieLogic {
    private final Alien alien;
    private static final String WOOKIE_TYPE = "wookie";

    public boolean isWookie() {
        if (alien == null)
            return false;
        return WOOKIE_TYPE.equalsIgnoreCase(alien.getType());
    }
}
