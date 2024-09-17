package com.inventory;

import com.actionSteps.LoginActions;
import com.addToCart.CartActions;
import com.addToCart.CartActions;
import com.addToCart.DisplayShoppingCart;
import com.addToCart.DisplayShoppingCart;
import com.userAuthentication.Users;
import net.serenitybdd.annotations.Managed;
import net.serenitybdd.annotations.Steps;
import net.serenitybdd.core.Serenity;
import net.serenitybdd.junit.runners.SerenityRunner;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;

import java.util.List;

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

    DisplayShoppingCart displayedBadgeCountOnShoppingCart;

    @Steps
    CartActions cartActions;
    @Test
    public void theCorrectItemCountShouldBeDisplayed(){
        // Check that the shopping cart badge is empty
        Serenity.reportThat("The Shopping cart badge should be empty",
                () -> assertThat(displayedBadgeCountOnShoppingCart.badgeCount()).isEmpty()
        );
        // Add one item to the cart
        cartActions.addItem("Sauce Labs Backpack");

        // The shopping cart badge should be displayed as "1"
        Serenity.reportThat("The Shopping cart badge should be displaying number as '1'",
                () -> assertThat(displayedBadgeCountOnShoppingCart.badgeCount()).isEqualTo("1")
        );    }

    ProductList productList;
    @Test
    public void allTheItemsShouldAppearInTheCart(){
        // Add several items to the cart
        List<String> selectedItemsFromShoppingInventoryPage = firstThreeProductTitlesDisplayedOnInventoryPage();

        // Open the cart page
        cartActions.additems(selectedItemsFromShoppingInventoryPage);

        String cartBadgeCount = Integer.toString(selectedItemsFromShoppingInventoryPage.size());

        Serenity.reportThat("The Shopping cart badge should now be" + cartBadgeCount,
                () -> assertThat(displayedBadgeCountOnShoppingCart.badgeCount()).isEqualTo(cartBadgeCount)
        );
        cartActions.openCart();

        Serenity.reportThat("The Shopping cart badge should now be" + cartBadgeCount,
                () -> assertThat(cartActions.displayedItems()).isEqualTo(selectedItemsFromShoppingInventoryPage)
        );


    }

    private List<String> firstThreeProductTitlesDisplayedOnInventoryPage() {
        return productList.titles().subList(0, 3);
    }
}
