package com.example.springbootcucumber.space.alien;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import javax.persistence.*;
import java.math.BigDecimal;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Builder
@EntityListeners(value = {WeightIncreaseEntityListener.class})
@Slf4j
public class Alien {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String type;
    private String fullName;
    private int weight;
    private BigDecimal runSpeed;
    private int height;

    public String beamUp(String something) {
        String beaming = String.format("Woppa woppa woppa we are beaming up %s", something);
        log.info(beaming);
        return beaming;
    }
}
