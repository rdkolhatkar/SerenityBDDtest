package com.api.test.stepDefinitions;

import com.api.test.setup.ApiSetup;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import java.io.IOException;

public class ApiStepDefinitions {

    ApiSetup apiSetup = new ApiSetup();

    @Given("Name {string} as {string}")
    public void nameAs(String arg0, String arg1) {
    }
    @And("The PhoneNumber {string} as {string}")
    public void thePhoneNumberAs(String arg0, String arg1) {
    }
    @And("The Address {string} as {string}")
    public void theAddressAs(String arg0, String arg1) {
    }
    @And("The Language {string} as {string}")
    public void theLanguageAs(String arg0, String arg1) {
    }
    @And("URL value of Website {string} as {string}")
    public void urlValueOfWebsiteAs(String arg0, String arg1) {
    }
    @When("API is invoked")
    public void apiIsInvoked() throws IOException {
        apiSetup.invokeAddPlaceApi();
    }
    @Then("Status response code is {string}")
    public void statusResponseCodeIs(String arg0) {
    }
}
