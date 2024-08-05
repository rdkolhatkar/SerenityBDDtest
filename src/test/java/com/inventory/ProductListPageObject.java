package com.inventory;

import net.serenitybdd.core.pages.PageObject;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class ProductListPageObject extends PageObject {
    public List<String> titles() {
       //return findAll(new By.ByClassName("inventory_item_name")).textContents();

       // With Serenity we can use the CSS convention Shown Below
        return findAll(".inventory_item_name").textContents();
    }

    public void openProductDetailsFor(String itemName) {
        find(By.linkText(itemName)).click();
    }
}
