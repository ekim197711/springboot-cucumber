package com.example.springbootcucumber.cucumberglue;

import com.example.springbootcucumber.space.greeting.GreetingService;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.jupiter.api.Assertions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class GreetingStepdefs {
    private String name = "not set";
    private String greeting = "not set";

    @When("we introduce ourselves as {string}")
    public void introduceOurselves(String name) {
        this.name = name;
    }

    @When("we say we want greeting {string}")
    public void greeting(String greeting) {
        this.greeting = greeting;
    }

    @Autowired
    public GreetingService greetingService;

    @Then("please say {string}")
    public void assertGreeting(String message) {
        String greet = greetingService.greet(greeting, name);
        System.out.println(greet);
        Assertions.assertEquals(message, greet);
    }

}
