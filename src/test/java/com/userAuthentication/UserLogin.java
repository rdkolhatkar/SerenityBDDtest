package com.userAuthentication;

import net.serenitybdd.annotations.Managed;
import net.serenitybdd.core.steps.UIInteractionSteps;
import net.serenitybdd.junit.runners.SerenityRunner;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static org.assertj.core.api.Java6Assertions.assertThat;

@RunWith(SerenityRunner.class)
public class UserLogin extends UIInteractionSteps {
    /*
    1. UIInteractionSteps is an in-built library that defines reusable steps with some in-built custom methods that can be used throughout your test
     */
    @Managed
    WebDriver driver;
    @Test
    public void userLoginPage() throws InterruptedException {


        /*
        // driver Methods from WebDriver
        // Login with Standard user
        driver.get("https://www.saucedemo.com");
        driver.findElement(By.cssSelector("[data-test='username']")).sendKeys("standard_user");
        driver.findElement(By.cssSelector("[data-test='password']")).sendKeys("secret_sauce");
        driver.findElement(By.cssSelector("[data-test='login-button']")).click();
        // Validation by checking the title of product catalog
        assertThat(driver.findElement(By.cssSelector(".title")).getText()).isEqualToIgnoringCase("products");
        */

        // Serenity Methods from UIInteractionSteps
        // Login with Standard user
        openUrl("https://www.saucedemo.com");
        find("[data-test='username']").sendKeys("standard_user");
        find("[data-test='password']").sendKeys("secret_sauce");
        find("[data-test='login-button']").click();
        // Validation by checking the title of product catalog
        assertThat(find(".title").getText()).isEqualToIgnoringCase("products");

        /*
        // Another Serenity optimization with annotation symbols
        // replacing find method with $ annotation
        // Login with Standard user
        openUrl("https://www.saucedemo.com");
        $("[data-test='username']").sendKeys("standard_user");
        $("[data-test='password']").sendKeys("secret_sauce");
        $("[data-test='login-button']").click();
        // Validation by checking the title of product catalog
        assertThat($(".title").getText()).isEqualToIgnoringCase("products");
        */





    }

}
