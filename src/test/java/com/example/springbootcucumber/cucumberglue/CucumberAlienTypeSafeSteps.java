package com.example.springbootcucumber.cucumberglue;

import com.example.springbootcucumber.space.alien.Alien;
import com.example.springbootcucumber.space.alien.AlienService;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.DataTableType;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import lombok.RequiredArgsConstructor;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;


@RequiredArgsConstructor
public class CucumberAlienTypeSafeSteps {
    private final AlienService alienService;
    private List<Alien> listOfAliens;

    @DataTableType
    public Alien alienTransformer(Map<String, String> row) {
        return new Alien(
                Long.parseLong(row.get("id")),
                row.get("type"),
                row.get("fullName"),
                Integer.parseInt(row.get("weight")),
                new BigDecimal(row.get("runSpeed")),
                Integer.parseInt(row.get("height"))
        );
    }

    @When("These aliens are created")
    public void aliensAreCreated(List<Alien> aliens) {
        listOfAliens = aliens;
    }

    @When("These aliens are created with datatable")
    public void aliensAreCreated(DataTable dataTable) {
        listOfAliens = dataTable.asList(Alien.class);
        List<String> row = dataTable.row(1);
        System.out.println("extra field: " + row.get(5));
        
    }

    @Then("We want them printed out")
    public void aliensPrintout() {
        listOfAliens.forEach(System.out::println);
    }


}
