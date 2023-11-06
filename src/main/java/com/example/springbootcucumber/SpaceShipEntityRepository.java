package com.example.springbootcucumber;

import com.example.springbootcucumber.space.SpaceShipEntity;
import org.springframework.data.jpa.repository.JpaRepository;

@SuppressWarnings("unused")
public interface SpaceShipEntityRepository extends JpaRepository<SpaceShipEntity, Integer> {
}