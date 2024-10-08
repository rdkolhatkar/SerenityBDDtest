package com.inventory;


import com.actionSteps.LoginActions;
import com.actionSteps.ViewProductDetailsAction;
import com.userAuthentication.Users;
import net.serenitybdd.annotations.Managed;
import net.serenitybdd.annotations.Steps;
import net.serenitybdd.core.Serenity;
import net.serenitybdd.junit.runners.SerenityRunner;
import org.assertj.core.api.SoftAssertions;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SerenityRunner.class)
public class ViewProductList {
    @Managed(driver = "chrome") // This line of code is to specify type of driver, No need to add driver.exe file separately. Serenity provides inbuilt driver settings
    WebDriver driver;
    @Steps
    LoginActions login;
    ProductListPageObject productListPageObject;
    ProductDetailsPageObject productDetailsPageObject;

    @Steps
    ViewProductDetailsAction viewProductDetails;

    ProductList productItemList;

    ProductListPageObject productList;
    @Test
    public void displayHighlightedProducts(){
        login.as(Users.STANDARD_USER);
        List<String> productsOnDisplay = productList.titles();

        assertThat(productsOnDisplay).hasSize(6).contains("Sauce Labs Backpack");
    }
    @Test
    public void displayCorrectProductDetailsPage(){
        login.as(Users.STANDARD_USER);
        String firstItemName = productList.titles().get(0);
        productList.openProductDetailsFor(firstItemName);

        assertThat(productDetailsPageObject.productName()).isEqualTo(firstItemName);

        productDetailsPageObject.productImageWithValueOf(firstItemName).shouldBeVisible();

    }

    @Test
    public void CorrespondingImageDisplayForHighlightedProduct(){
        login.as(Users.STANDARD_USER);
        List<String> productsOnDisplay = productList.titles();

        // Serenity Provides the soft Assertions method and it helps in rectifying the code breakdown in loop.
        SoftAssertions softAssertions = new SoftAssertions();

        productsOnDisplay.forEach(
                productName -> softAssertions.assertThat(productList.imageTextForProduct(productName)).isEqualTo(productName)
        );
        softAssertions.assertAll();
    }


    @Test
    public void shouldDisplayCorrectProductDetailsPage(){
        login.as(Users.STANDARD_USER);
        String firstItemName = productItemList.titles().get(0);
        //productList.openProductDetailsFor(firstItemName);

        viewProductDetails.forProductWithName(firstItemName);

        // Serenity.reportThat() is an inbuilt feature of serenity for documenting our assertions in serenity report

        Serenity.reportThat("The Product Name should be Correctly Displayed",
                () ->  assertThat(productItemList.productName()).isEqualTo(firstItemName)
        );

        Serenity.reportThat("The Product image should have the correct alt text",
                () -> productDetailsPageObject.productImageWithValueOf(firstItemName).shouldBeVisible()
        );

    }
}
