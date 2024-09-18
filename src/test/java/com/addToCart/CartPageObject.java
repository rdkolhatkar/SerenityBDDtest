package com.addToCart;

import net.serenitybdd.annotations.DefaultUrl;
import net.serenitybdd.core.pages.PageObject;

import java.util.List;

// @DefaultUrl annotation in serenity will specify the URL that a page object should use when it's run in isolation.
@DefaultUrl("https://www.saucedemo.com/cart.html")
public class CartPageObject extends PageObject {
    public List<CartItems> items() {
        return null;
    }
}
