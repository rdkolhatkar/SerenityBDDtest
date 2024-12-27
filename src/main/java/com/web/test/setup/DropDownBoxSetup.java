package com.web.test.setup;

import net.serenitybdd.annotations.Step;
import net.thucydides.core.annotations.findby.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class DropDownBoxSetup {
    WebDriver driver = new ChromeDriver();
    WebElement staticDropDown;
    @Step
    public void selectStaticDropDownOfCurrency(String appBaseUrl){
        driver.get(appBaseUrl);
        staticDropDown = driver.findElement(By.id("ctl00_mainContent_DropDownListCurrency"));
        Select dropdown = new Select(staticDropDown);
        //Select By INDEX
        dropdown.selectByIndex(3);
        //Select By Visible Text
        dropdown.selectByVisibleText("AED");
        System.out.println(dropdown.getFirstSelectedOption().getText());
    }
    @Step
    public void selectStaticDropDownOfPassengers() throws InterruptedException {
        driver.findElement(By.id("divpaxinfo")).click();
        Thread.sleep(2000L);
        System.out.println("Initial Value of Passengers = "+driver.findElement(By.id("divpaxinfo")).getText());
        int i =1;
        while(i<5){
            driver.findElement(By.id("hrefIncAdt")).click();
            i++;
        }
        driver.findElement(By.id("btnclosepaxoption")).click();
        System.out.println("Final Value of Passengers = "+driver.findElement(By.id("divpaxinfo")).getText());
        driver.close();
    }



}
