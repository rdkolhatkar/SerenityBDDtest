package com.userAuthentication;

import com.actionSteps.LoginActions;
import com.inventory.InventoryPage;
import net.serenitybdd.annotations.Managed;
import net.serenitybdd.annotations.Steps;
import net.serenitybdd.core.Serenity;
import net.serenitybdd.core.steps.UIInteractionSteps;
import net.serenitybdd.junit.runners.SerenityRunner;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;

import static com.userAuthentication.Users.STANDARD_USER;
import static org.assertj.core.api.Java6Assertions.assertThat;

@RunWith(SerenityRunner.class)
public class UserLoginActions {
    /*
    1. UIInteractionSteps is an in-built library that defines reusable steps with some in-built custom methods that can be used throughout your test
     */
    @Managed
    WebDriver driver;
    @Steps
    LoginActions login;
    InventoryPage inventoryPage;
    @Test
    public void userLoginPage() throws InterruptedException {

        // Serenity Methods from UIInteractionSteps
        // Login with Standard user
        //login.asAStandardUser();
        //login.usingCredentials("standard_user", "secret_sauce");
        login.as(STANDARD_USER); // Created Enum for Security Purpose with Users Class
        // Validation by checking the title of product catalog
        //assertThat(inventoryPage.getHeading()).isEqualToIgnoringCase("products");

        // in-built serenity method with lambada expression for Asserting
        Serenity.reportThat("The inventory page should be displayed with correct title",
                () -> assertThat(inventoryPage.getHeading()).isEqualToIgnoringCase("products")
        );


    }

}
