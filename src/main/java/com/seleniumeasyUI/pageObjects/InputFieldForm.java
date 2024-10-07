package com.seleniumeasyUI.pageObjects;

import org.openqa.selenium.By;

public class InputFieldForm extends SeleniumEasyForm{

    public void enterCredentials(String value) {
        $(By.id("name")).sendKeys(value);
//        $(By.id("name")).type(value);
    }
    public void radioButton() {

    }
}
