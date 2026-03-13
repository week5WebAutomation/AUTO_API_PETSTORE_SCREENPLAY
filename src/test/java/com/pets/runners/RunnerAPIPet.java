package com.pets.runners;

import io.cucumber.junit.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(
    features = "src/test/resources/features",
    glue = {"com.pets.stepdefinitions", "com.pets.stepdefinitions.hooks"},
    plugin = {"pretty"}
)
public class RunnerAPIPet {

}
