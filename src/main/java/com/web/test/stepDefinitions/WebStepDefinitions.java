package com.web.test.stepDefinitions;

import com.web.test.setup.DropDownBoxSetup;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.annotations.Step;
import net.serenitybdd.annotations.Steps;

public class WebStepDefinitions {

    @Steps
    DropDownBoxSetup dropDownBoxSetup;

    @Given("Name of the Student {string} as {string}")
    public void nameOfTheStudentAs(String arg0, String arg1) {
    }
    @And("The Email Address of {string} as {string}")
    public void theEmailAddressOfAs(String arg0, String arg1) {
    }
    @And("The Mobile Phone Number of {string} as {string}")
    public void theMobilePhoneNumberOfAs(String arg0, String arg1) {
    }
    @And("The Student's date of birth {string} as {string}")
    public void theStudentSDateOfBirthAs(String arg0, String arg1) {
    }
    @And("The Elective Seleted {string} as {string}")
    public void theElectiveSeletedAs(String arg0, String arg1) {
    }
    @And("The Current Address of {string} as {string}")
    public void theCurrentAddressOfAs(String arg0, String arg1) {
    }
    @When("Gender, Hobby, State and City are selected successfully")
    public void genderHobbyStateAndCityAreSelectedSuccessfully() {
    }
    @Then("Click on Submit button")
    public void clickOnSubmitButton() {
    }
    @Given("User Navigates to {string}")
    public void userNavigatesTo(String appBaseUrl) throws InterruptedException {
        dropDownBoxSetup.selectStaticDropDownOfCurrency(appBaseUrl);
        Thread.sleep(5000L);
    }
    @When("User Clicks on Static Dropdown")
    public void userClicksOnStaticDropdown() throws InterruptedException {
        dropDownBoxSetup.selectStaticDropDownOfPassengers();
    }
    @Then("Static Dropdown Box Should display the Correct Value")
    public void staticDropdownBoxShouldDisplayTheCorrectValue() {
    }
}
