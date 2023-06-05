package com.example.springbootcucumber.space.alien;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface AlienRepository extends JpaRepository<Alien, Long> {

    @Query("""
                    SELECT COUNT (T.id)  
                    FROM Alien T
                    WHERE 
                    T.type = :type
            """)
    int countWithType(@Param("type") String type);
}
