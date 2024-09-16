package com.inventory;

import com.actionSteps.LoginActions;
import com.addToCart.AddToCartActions;
import com.addToCart.DisplayedBadgeCountOnShoppingCart;
import com.userAuthentication.Users;
import net.serenitybdd.annotations.Managed;
import net.serenitybdd.annotations.Steps;
import net.serenitybdd.core.Serenity;
import net.serenitybdd.junit.runners.SerenityRunner;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;

import static com.userAuthentication.Users.*;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;


/*
"@RunWith(SerenityRunner.class)" -> This will activate the serenity for all the tests
So that we will get our Driver managed for us through the SerenityRunner.class
*/
@RunWith(SerenityRunner.class)
public class AddItemInTheCart {

    @Managed(driver = "chrome")
    WebDriver driver;

    @Steps
    LoginActions loginActions;

    @Before // This annotation will execute our Login Action before each step
    public void login(){
        loginActions.as(STANDARD_USER);
    }

    DisplayedBadgeCountOnShoppingCart displayedBadgeCountOnShoppingCart;

    @Steps
    AddToCartActions addToCartActions;
    @Test
    public void theCorrectItemCountShouldBeDisplayed(){
        // Check that the shopping cart badge is empty
        Serenity.reportThat("The Shopping cart badge should be empty",
                () -> assertThat(displayedBadgeCountOnShoppingCart.count()).isEmpty()
        );
        // Add one item to the cart
        addToCartActions.item("Sauce Labs Backpack");

        // The shopping cart badge should be displayed as "1"
        Serenity.reportThat("The Shopping cart badge should be displaying number as '1'",
                () -> assertThat(displayedBadgeCountOnShoppingCart.count()).isEqualTo("1")
        );    }

    @Test
    public void allTheItemsShouldAppearInTheCart(){

    }
}
