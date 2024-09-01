package com.actionSteps;

import com.inventory.ProductList;
import com.inventory.ProductListPageObject;
import net.serenitybdd.annotations.Step;
import net.serenitybdd.core.steps.UIInteractionSteps;

public class ViewProductDetailsAction extends UIInteractionSteps {
    // This is our Action class

    ProductListPageObject productList;

    @Step("View Product Details for Product '{0}'")
    public void forProductWithName(String firstItemName) {
        $(ProductList.productDetailsLinkFor(firstItemName)).click();
    }
}
