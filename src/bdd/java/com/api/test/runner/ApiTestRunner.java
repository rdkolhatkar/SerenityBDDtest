package com.api.test.runner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = {"src/bdd/resources/feature/ApiTest.feature"},
        tags = "@Test",
        glue = {"com.api.test.stepDefinitions"}
)
public class ApiTestRunner {
}
