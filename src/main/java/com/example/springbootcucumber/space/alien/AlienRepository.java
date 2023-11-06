package com.example.springbootcucumber.space.alien;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

@SuppressWarnings("unused")
public interface AlienRepository extends JpaRepository<Alien, Long> {

    @Query("""
                    SELECT COUNT (T.id)
                    FROM Alien T
                    WHERE
                    T.type = :type
            """)
    int countWithType(@Param("type") String type);


    @Query("""
                                SELECT A
                                FROM Alien A
                                WHERE
                                A.type = :type
            """
    )
    List<Alien> aliensOfType(@Param("type") String type);
}
