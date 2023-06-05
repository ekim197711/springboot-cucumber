package com.example.springbootcucumber.cucumberglue;

import com.example.springbootcucumber.space.alien.AlienService;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import lombok.RequiredArgsConstructor;
import org.junit.jupiter.api.Assertions;

import java.util.Random;


@RequiredArgsConstructor
public class CucumberAlienSteps {
    private final AlienService alienService;

    @Given("No aliens exists")
    public void noAliens() {
        alienService.terminateAllAliens();
    }

    @When("Create {int} alien with name {string} and type {string}")
    public void whenClientCalls(int number, String name, String type) {
        for (int i = 0; i < number; i++) {
            alienService.createAlien(name, type,
                    Math.abs(new Random().nextInt() % 100)
                    , Math.abs(new Random().nextInt() % 100));
        }
    }

    @Then("Total number of aliens should be {int}")
    public void thenStatusCodee(int expected) {
        Assertions.assertEquals(expected, alienService.countAliens());
    }

    @Then("Total number of aliens with type {string} should be {int}")
    public void totalNumberOfAliensWithTypeShouldBe(String type, int expected) {
        Assertions.assertEquals(expected, alienService.countAliensWithType(type));
    }
}
