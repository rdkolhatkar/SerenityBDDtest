package com.web.test.runner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = {"src/main/resources/feature/StudentApplicationForm.feature"},
        tags = "@Test",
        glue = {"com.web.test.stepDefinitions"}
)
public class WebTestRunner {
}
