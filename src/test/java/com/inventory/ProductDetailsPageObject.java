package com.inventory;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementState;
import net.thucydides.core.annotations.findby.By;

public class ProductDetailsPageObject extends PageObject {
    public String productName(){
        return $(".inventory_details_name").getText();
    }


    /*The WebElementState class in Serenity is used to define the state of a web element within a test.
     It provides a way to describe the expected state of a web element, allowing you to write more descriptive and readable tests.
     */
    public WebElementState productImageWithValueOf(String firstItemName) {
    // return find(By.cssSelector(".inventory_details_container img[alt='Sauce Labs Backpack']"));
        return find(By.cssSelector(".inventory_details_container img[alt='" + firstItemName + "']"));
    }
}
