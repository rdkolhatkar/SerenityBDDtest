package com.seleniumeasyUI;

import com.seleniumeasyUI.pageObjects.InputFieldForm;
import net.serenitybdd.annotations.Managed;
import net.serenitybdd.junit.runners.SerenityRunner;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;

import java.util.List;

import static java.util.Arrays.asList;

@RunWith(SerenityRunner.class)
public class WhenInteractingWithInputForms {

    @Managed(driver = "chrome", uniqueSession = true) // uniqueSession = true -> this line of code is used to open only single browser window during test run
    WebDriver driver;
    /**
     * Basic form fields:
     * Enter a message and check that the message is correctly displayed
     * https://www.techlistic.com/p/selenium-practice-form.html
     * https://www.tutorialspoint.com/selenium/practice/selenium_automation_practice.php
     */

    InputFieldForm inputFieldForm;
    @Test
    public void basicForms() {
        inputFieldForm.open();
        inputFieldForm.enterCredentials("Ratnakar");
        inputFieldForm.radioButton();

    }

    /**
     * Basic form fields (part 2)
     * Enter two values and calculate the result
     * https://www.seleniumeasy.com/test/basic-first-form-demo.html
     */

    @Test
    public void basicFormsWithMultipleFields() {
    }

    /**
     * Checkboxes
     * Check that a message appears when you click the checkbox
     * https://www.seleniumeasy.com/test/basic-checkbox-demo.html
     */
    @Test
    public void singleCheckbox() {
    }

    @Test
    public void multipleCheckboxes() {
    }

    /**
     * Radio buttons
     * Check that a message appears when you click the radio button
     * https://www.seleniumeasy.com/test/basic-radiobutton-demo.html
     */
    @Test
    public void radioButtons() {
    }

    @Test
    public void multipleRadioButtons() {
    }

    /**
     * Dropdown lists
     * https://www.seleniumeasy.com/test/basic-select-dropdown-demo.html
     */
    @Test
    public void selectList() {
    }

    /**
     * Multi-Select Dropdown lists
     * https://www.seleniumeasy.com/test/basic-select-dropdown-demo.html
     */
    @Test
    public void multiSelectList() {
    }
}
