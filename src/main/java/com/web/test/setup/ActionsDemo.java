package com.web.test.setup;

import net.thucydides.core.annotations.findby.By;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class ActionsDemo {

    @Test
    public void mouseActions(){
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.amazon.com");
        Actions actions = new Actions(driver); // in selenium Actions class is used for mouse actions
        actions.moveToElement(driver.findElement(By.cssSelector("a[id='nav-link-accountList']"))).build().perform();

    }
}
