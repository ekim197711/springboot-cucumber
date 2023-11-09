package com.example.springbootcucumber.space;

import com.example.springbootcucumber.SpaceShipDto;
import com.example.springbootcucumber.SpaceShipDtoList;
import com.example.springbootcucumber.SpaceShipEntityRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/ship")
@RequiredArgsConstructor
public class SpaceShipController {
    private final SpaceShipEntityRepository repository;

    @GetMapping("/{id}")
    public SpaceShipDto getShip(@PathVariable Integer id) {
        Optional<SpaceShipEntity> byId = repository.findById(id);
        SpaceShipEntity spaceShipEntity = byId.orElseThrow();
        return new SpaceShipDto(spaceShipEntity.getId(),
                spaceShipEntity.getShipName(),
                spaceShipEntity.getFuel(),
                spaceShipEntity.getMaxSpeed());
    }

    @GetMapping("/")
    public SpaceShipDtoList getShips() {
        List<SpaceShipEntity> all = repository.findAll();
        return SpaceShipDtoList
                .builder()
                .ships(
                        all.stream().map(spaceShipEntity -> new SpaceShipDto(spaceShipEntity.getId(),
                                spaceShipEntity.getShipName(),
                                spaceShipEntity.getFuel(),
                                spaceShipEntity.getMaxSpeed())).toList()
                )
                .build();
    }

    @PostMapping("/")
    public SpaceShipDto getShip(@RequestBody SpaceShipDto spaceShipDto) {
        SpaceShipEntity entity = SpaceShipEntity.builder()
                .fuel(spaceShipDto.fuel())
                .shipName(spaceShipDto.shipName())
                .maxSpeed(spaceShipDto.maxSpeed())
                .build();
        SpaceShipEntity save = repository.save(entity);
        return getShip(save.getId());
    }
}
