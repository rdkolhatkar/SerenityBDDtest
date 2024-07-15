package com.userAuthentication;

import net.serenitybdd.annotations.Managed;
import net.serenitybdd.junit.runners.SerenityRunner;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static org.assertj.core.api.Java6Assertions.assertThat;

@RunWith(SerenityRunner.class)
public class UserLogin {

    @Managed
    WebDriver driver;
    @Test
    public void userLoginPage(){

        // Login with Standard user
        driver.get("https://www.saucedemo.com");
        driver.findElement(By.cssSelector("[data-test='username']")).sendKeys("standard_user");
        driver.findElement(By.cssSelector("[data-test='password']")).sendKeys("secret_sauce");
        driver.findElement(By.cssSelector("[data-test='login-button']")).click();
        // Validation by checking the title of product catalog
        assertThat(driver.findElement(By.cssSelector(".product-lable")).getText()).isEqualToIgnoringCase("products");

    }

}
