package com.example.springbootcucumber;

import com.example.springbootcucumber.space.SpaceShipEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SpaceShipEntityRepository extends JpaRepository<SpaceShipEntity, Integer> {
}