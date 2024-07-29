package com.inventory;


import com.actionSteps.LoginActions;
import com.userAuthentication.Users;
import net.serenitybdd.annotations.Managed;
import net.serenitybdd.annotations.Steps;
import net.serenitybdd.junit.runners.SerenityRunner;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SerenityRunner.class)
public class ViewProductList {
    @Managed
    WebDriver driver;
    @Steps
    LoginActions login;

    ProductListPageObject productList;
    @Test
    public void displayHighlightedProducts(){
        login.as(Users.STANDARD_USER);
        List<String> productsOnDisplay = productList.titles();

        assertThat(productsOnDisplay).hasSize(6).contains("Sauce Labs Backpack");
    }
}
