package com.example.springbootcucumber.space.alien;

import lombok.RequiredArgsConstructor;

import java.util.List;

@RequiredArgsConstructor
public class WookieInListLogic {
    private final List<Alien> aliens;
    private static final String WOOKIE_TYPE = "wookie";

    public boolean containsWookiesOldFashion() {
        boolean wookie = false;
        for (Alien alien : aliens) {
            if (WOOKIE_TYPE.equalsIgnoreCase(alien.getType())) {
                wookie = true;
                break;
            }
        }
        return wookie;
    }

    public boolean containsWookie() {
        return aliens.stream()
                .map(WookieLogic::new)
                .anyMatch(WookieLogic::isWookie);
    }

}
