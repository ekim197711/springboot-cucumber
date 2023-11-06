package com.example.springbootcucumber.cucumberglue;

import com.example.springbootcucumber.SpaceShipDto;
import com.example.springbootcucumber.SpaceShipDtoList;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.spring.CucumberContextConfiguration;
import org.junit.jupiter.api.Assertions;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Map;
import java.util.Objects;

import static org.hamcrest.MatcherAssert.assertThat;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@CucumberContextConfiguration
public class CucumberMySteps {
    @LocalServerPort
    String port;
    ResponseEntity<String> lastResponse;


    @When("the client calls endpoint {string}")
    public void whenClientCalls(String url) {
        try {
            lastResponse = new RestTemplate().exchange("http://localhost:" + port + url, HttpMethod.GET, null,
                    String.class);
        } catch (HttpClientErrorException httpClientErrorException) {
            httpClientErrorException.printStackTrace();
        }
    }

    @Then("response status code is {int}")
    public void thenStatusCodee(int expected) {
        Assertions.assertNotNull(lastResponse);
        Assertions.assertNotNull(lastResponse.getStatusCode());
        assertThat("status code is" + expected,
                lastResponse.getStatusCodeValue() == expected);
    }

    @Then("response status code is not present")
    public void thenStatusCodeeIsNotPresent() {
        Assertions.assertNull(lastResponse);
    }

    @Then("returned string should be {string}")
    public void thenStringIs(String expected) {
        Assertions.assertEquals(expected, lastResponse.getBody());
    }

    private List<Map<String, String>> ships;
    final RestTemplate restTemplate = new RestTemplate();

    @Given("We have gaffa taped the following spaceships together")
    public void weHaveGaffaTapedTheFollowingSpaceshipsTogether(DataTable shipsGaffaTaped) {
        List<Map<String, String>> maps = shipsGaffaTaped.asMaps();
        System.out.println(shipsGaffaTaped);
        System.out.println(maps);
        ships = maps;
    }


    @When("send ships to rest controller")
    public void sendShipsToRestController() {
        String url = "http://localhost:" + port + "/ship/";
        ships.forEach(ship -> {

                    SpaceShipDto spaceShipDto = restTemplate.postForObject(
                            url, ship, SpaceShipDto.class);
                    System.out.println("Response from post " + spaceShipDto);
                }
        );
    }

    @Then("all ships should now have an id")
    public void shipsShouldHaveIds(DataTable expectedShips) {
        String url = "http://localhost:" + port + "/ship/";
        SpaceShipDtoList shipsFromDb = restTemplate.getForObject(url, SpaceShipDtoList.class);
        Objects.requireNonNull(shipsFromDb).getShips().forEach(shipFromDb -> Assertions.assertNotNull(shipFromDb.id()));
        List<Map<String, String>> maps = expectedShips.asMaps();
        for (Map<String, String> shiprow : maps) {
            boolean foundByName = shipsFromDb.getShips().stream()
                    .anyMatch(ship -> ship.shipName().equals(shiprow.get("shipName")));
            Assertions.assertTrue(foundByName, shiprow.get("shipName") + " was not found in db");
        }
    }

}
