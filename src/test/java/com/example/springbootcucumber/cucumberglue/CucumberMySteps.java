package com.example.springbootcucumber.cucumberglue;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.jupiter.api.Assertions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;
import static org.hamcrest.MatcherAssert.assertThat;



public class CucumberMySteps {

    @LocalServerPort
    String port;
    ResponseEntity<String> lastResponse;

    @When("the client calls endpoint {string}")
    public void whenClientCalls(String url){
        lastResponse = new RestTemplate().exchange("http://localhost:" + port + url, HttpMethod.GET,null,
                String.class);
    }

    @Then("response status code is {int}")
    public void thenStatusCodee(int expected){
        assertThat("status code is" + expected,
                lastResponse.getStatusCodeValue() == expected);
    }
    @Then("returned string should be {string}")
    public void thenStringIs(String expected){
        Assertions.assertEquals(expected,lastResponse.getBody());
//        assertThat("Returned string is " + expected,
//                expected.equalsIgnoreCase(lastResponse.getBody()));
    }
}
