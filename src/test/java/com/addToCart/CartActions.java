package com.addToCart;

import com.inventory.ProductList;
import net.serenitybdd.annotations.Step;
import net.serenitybdd.core.steps.UIInteractionSteps;

import java.util.List;

public class CartActions extends UIInteractionSteps {

    @Step("Add {0} to the cart")
    public void addItem(String itemName) {
        $(ProductList.addToCartButtonFor(itemName)).click();
    }

    @Step("Add {0} to the cart")
    public void additems(List<String> items) {
        items.forEach(this::addItem);
    }

    @Step("Open the shopping cart page")
    public void openCart() {
        $(DisplayShoppingCart.shoppingCartIconLink()).click();
    }

    public List<String> displayedItems() {
        return findAll(".inventory_item_name").texts();
    }
}

