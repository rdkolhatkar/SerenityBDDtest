package com.actionSteps;

import com.userAuthentication.Users;
import net.serenitybdd.annotations.Step;
import net.serenitybdd.core.steps.UIInteractionSteps;
import net.thucydides.core.annotations.findby.By;

import static org.assertj.core.api.Java6Assertions.assertThat;

public class LoginActions extends UIInteractionSteps {

    @Step("Login as a Standard user")
    public void asAStandardUser(){
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
    }

    @Step("Login as {0}")
    public void usingCredentials(String username, String password){
        openUrl("https://www.saucedemo.com");
        find("[data-test='username']").sendKeys(username);
        find("[data-test='password']").sendKeys(password);
        find("[data-test='login-button']").click();
        // Validation by checking the title of product catalog
        assertThat(find(".title").getText()).isEqualToIgnoringCase("products");
    }

    @Step("Login as {0}")
    public void as(Users users){
        openUrl("https://www.saucedemo.com");
        /*
        find("[data-test='username']").sendKeys(users.getUsername());
        find("[data-test='password']").sendKeys(users.getPassword());
        find(By.id("user-name")).sendKeys(users.getUsername());
        find(By.id("password")).sendKeys(users.getPassword());
        */
        /*
        find(By.name("user-name")).sendKeys(users.getUsername());
        find(By.name("password")).sendKeys(users.getUsername());
        */


        // Serenity can replace find(By.name()) with below annotation symbols like $ and #
        /*
        $("[name=user-name]").sendKeys(users.getUsername());
        $("[name=password]").sendKeys(users.getPassword());
        */

        /*
        // Serenity can replace find(By.id()) with below annotation symbols like $ and #
        $("#user-name").sendKeys(users.getUsername());
        $("#password").sendKeys(users.getPassword());
        */
        /*
        find("[data-test='login-button']").click();
        // Validation by checking the title of product catalog
        assertThat(find(".title").getText()).isEqualToIgnoringCase("products");
        */

        // Implementation of Serenity Action class called LoginForm
        find(LoginForm.USER_NAME).sendKeys(users.getUsername());
        find(LoginForm.PASSWORD).sendKeys(users.getPassword());
        find(LoginForm.LOGIN_BUTTON).click();
    }





}
