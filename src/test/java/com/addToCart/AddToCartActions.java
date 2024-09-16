package com.addToCart;

import com.inventory.ProductList;
import net.serenitybdd.annotations.Step;
import net.serenitybdd.core.steps.UIInteractionSteps;

public class AddToCartActions extends UIInteractionSteps {
    @Step("Add {0} to the cart")
    public void item(String itemName) {
        $(ProductList.addToCartButtonFor(itemName)).click();
    }
}
