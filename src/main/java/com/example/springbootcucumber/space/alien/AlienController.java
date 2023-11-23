package com.example.springbootcucumber.space.alien;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController()
@RequestMapping("/alien")
@RequiredArgsConstructor
public class AlienController {
    private final AlienRepository alienRepository;
    private final WeightGainEnabledService weightGainEnabledService;

    @GetMapping("/")
    List<Alien> listAllAliens() {
        return alienRepository.findAll();
    }

    @PostMapping("/{enableWeightGain}")
    Alien createAlien(Alien newAlien, @PathVariable("enableWeightGain") boolean enableWeightGain) {
        if (enableWeightGain) {
            weightGainEnabledService.enableWeightGain();
        }
        Alien save = alienRepository.save(newAlien);
        return save;
    }


}
