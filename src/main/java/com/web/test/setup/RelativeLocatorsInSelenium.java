package com.web.test.setup;

import net.thucydides.core.annotations.findby.By;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import static org.openqa.selenium.support.locators.RelativeLocator.*;

public class RelativeLocatorsInSelenium {

    @Test
    public void relativeLocatorsInSeleniumFour(){
        WebDriver driver = new ChromeDriver();
        driver.get("https://rahulshettyacademy.com/angularpractice/");
        WebElement nameEditBox = driver.findElement(By.cssSelector("[name='name']"));
        // Finding element with relative locator
        // To use relative locators in our project we have to manually import one static package called {import static org.openqa.selenium.support.locators.RelativeLocator.*;}
        String elementName = driver.findElement(with(By.tagName("label")).above(nameEditBox)).getText();
        System.out.println(elementName);
        driver.close();
    }
}
