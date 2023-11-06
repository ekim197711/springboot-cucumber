package com.example.springbootcucumber.space.alien;

import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@SuppressWarnings({"UnusedReturnValue", "unused"})
@Service
@RequiredArgsConstructor
@Slf4j
public class AlienService {
    private final AlienRepository alienRepository;

    public long countAliens() {
        return alienRepository.count();
    }

    public long countAliensWithType(String type) {
        return alienRepository.countWithType(type);
    }

    @SneakyThrows
    public Alien createAlien(String name, String type, int weight, int height) {
        Alien alien = new Alien(null, type, name, weight, BigDecimal.ZERO, height);
        Thread.sleep(150);
        Alien save = alienRepository.save(alien);
        log.info("An alien has been created! {}", save);
        return save;
    }

    public void terminateAllAliens() {
        log.info("Delete all aliens");
        alienRepository.deleteAll();
    }

    public List<Alien> aliensOfType(String type) throws AlienException {
        List<Alien> alienList = alienRepository.aliensOfType(type);
        if (alienList.isEmpty()) {
            throw new AlienException(AlienServiceErrorMessage.ALIEN_NO_TYPE.oneArgument(type));
        }
        return alienList;
    }
}
