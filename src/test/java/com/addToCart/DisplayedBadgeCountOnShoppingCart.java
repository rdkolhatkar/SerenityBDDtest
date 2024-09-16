package com.addToCart;

import net.serenitybdd.core.pages.PageObject;

public class DisplayedBadgeCountOnShoppingCart extends PageObject {
    public String count(){
        return $(".shopping_cart_link").getText();
    }
}
