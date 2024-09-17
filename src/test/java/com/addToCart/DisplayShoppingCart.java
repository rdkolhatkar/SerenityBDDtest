package com.addToCart;

import net.serenitybdd.core.pages.PageObject;
import org.openqa.selenium.By;

public class DisplayShoppingCart extends PageObject {
    public String badgeCount(){
        return $(".shopping_cart_link").getText();
    }
    public static By shoppingCartIconLink(){
        return By.cssSelector(".shopping_cart_link");
    }
}
