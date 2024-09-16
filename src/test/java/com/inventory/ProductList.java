package com.inventory;

import net.serenitybdd.core.pages.PageObject;
import org.openqa.selenium.By;

import java.util.List;

public class ProductList extends PageObject {

    public static By addToCartButtonFor(String itemName) {
        return By.xpath("//div[@class='inventory_item'][contains(.,'"+ itemName +"')]//button");
    }

    public String productName(){
        return $(".inventory_details_name").getText();
    }

    public List<String> titles() {
        //return findAll(new By.ByClassName("inventory_item_name")).textContents();

        // With Serenity we can use the CSS convention Shown Below
        return findAll(".inventory_item_name").textContents();
    }

    public String imageTextForProduct(String productName) {

        /*
        return find(By.xpath(("//div[@class='inventory_item'][contains(.,'" + productName + "')]//img")))
                .getAttribute("alt");
       */

        return $("//div[@class='inventory_item'][contains(.,'" + productName + "')]//img")
                .getAttribute("alt");
    }

    public static By productDetailsLinkFor(String itemName) {
        return By.linkText(itemName);
    }
}
