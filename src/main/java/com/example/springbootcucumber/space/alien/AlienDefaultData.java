package com.example.springbootcucumber.space.alien;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.math.BigDecimal;
import java.util.List;

@Component
@RequiredArgsConstructor
public class AlienDefaultData {
    private final AlienRepository alienRepository;
    private static final String ALIEN_MARTIAN = AlienType.MARTIAN.getType();

    @PostConstruct
    public void createDefaultAliens() {
        alienRepository.saveAll(
                List.of(
                        new Alien(null, AlienType.MARTIAN.getType(), "Susan", 70, new BigDecimal("70.34"), 190),
                        new Alien(null, AlienType.WOOKIE.getType(), "Paulina", 60, new BigDecimal("60.676"), 190),
                        new Alien(null, AlienType.MARTIAN.getType(), "Lillian", 90, new BigDecimal("91.123"), 190),
                        new Alien(null, AlienType.WOOKIE.getType(), "Isabella", 75, new BigDecimal("74.76"), 190),
                        new Alien(null, AlienType.MARTIAN.getType(), "Brian", 100, new BigDecimal("100.01"), 190),
                        new Alien(null, AlienType.EWOK.getType(), "Mike", 115, new BigDecimal("116.123"), 190),
                        new Alien(null, AlienType.MARTIAN.getType(), "Poul", 70, new BigDecimal("74.123"), 190),
                        new Alien(null, AlienType.MARTIAN.getType(), "Adam", 72, new BigDecimal("71.123123"), 190)
                )
        );
    }
}
