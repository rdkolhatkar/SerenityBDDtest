package com.web.test.runner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = {"src/main/resources/feature/PracticeSoftwareTestingWeb.feature"},
        tags = "@CheckStaticDropDown",
        glue = {"com.web.test.stepDefinitions"}
)
public class WebTestRunner {
}
