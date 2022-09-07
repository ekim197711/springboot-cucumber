package com.example.springbootcucumber.space;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/launch")
public class SpaceShipLaunchController {

    @GetMapping("/counter/{lastCount}")
    public String countDown(@PathVariable  int lastCount)
    {
        int nextCount = lastCount-1;
        return nextCount > 0 ? "T-" + nextCount : "Launch! Go go go!";
    }
}
