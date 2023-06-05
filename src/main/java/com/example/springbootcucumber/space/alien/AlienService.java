package com.example.springbootcucumber.space.alien;

import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

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
        Alien alien = new Alien(null, type, name, weight, height);
        Thread.sleep(150);
        Alien save = alienRepository.save(alien);
        log.info("An alien has been created! {}", save);
        return save;
    }

    public void terminateAllAliens() {
        log.info("Delete all aliens");
        alienRepository.deleteAll();
    }
}