package com.addToCart;

import net.serenitybdd.annotations.DefaultUrl;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.ArrayList;
import java.util.List;

// @DefaultUrl annotation in serenity will specify the URL that a page object should use when it's run in isolation.
@DefaultUrl("https://www.saucedemo.com/cart.html")
public class CartPageObject extends PageObject {

//    @FindBy(id = "checkout")
    @FindBy(css = "[data-test=checkout]")
//    WebElement checkOutButton; // WebElement is a Selenium class
    WebElementFacade checkOutButton; // This is a serenity class which gives us more flexibility on interacting with web elements.
    @FindBy(css = ".title")
    WebElementFacade title;

    @FindBy(className = "cart_item")
    List<WebElementFacade> cartItems;
    public void checkout(){
        checkOutButton.click();
    }

    public String getTitleText(){
        return title.getText();
    }
    public List<CartItems> items() {
        List<CartItems> cartItemsList = new ArrayList<>();
        for(WebElementFacade cartItemElement : cartItems){
            String name = cartItemElement.findBy(".inventory_item_name").getText();
            String description = cartItemElement.findBy(".inventory_item_desc").getText();
            Double price = priceFrom(cartItemElement.findBy(".inventory_item_price").getText());
            cartItemsList.add(new CartItems(name, description, price));
        }
        return null;
    }

    private Double priceFrom(String textValue) {
        return Double.parseDouble(textValue.replace("$", " "));
    }
}
