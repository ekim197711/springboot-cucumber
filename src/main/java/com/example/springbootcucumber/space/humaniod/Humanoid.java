package com.example.springbootcucumber.space.humaniod;

import com.example.springbootcucumber.space.alien.Alien;

import java.math.BigDecimal;

public class Humanoid extends Alien {

    public Humanoid(Long id, String type, String name, int weight, BigDecimal runSpeed, int height) {
        super(id, type, name, weight, runSpeed, height);
    }

    public Humanoid() {
        super();
    }

    public String saySomething(String topic) {
        if ("electronics".equalsIgnoreCase(topic)) {
            return "I need stuff with galaxy light in it... Like my keyboard!";
        }
        return "Nice weather today!";
    }

    public String grapStuff(String item) {
        return "Holding an " + item;
    }

    public String lightThoughts(String topic) {
        return "Having light thoughts about " + topic;
    }
}
