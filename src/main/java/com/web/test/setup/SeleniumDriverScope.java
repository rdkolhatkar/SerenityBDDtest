package com.web.test.setup;


import net.thucydides.core.annotations.findby.By;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class SeleniumDriverScope {

    @Test
    public void seleniumWebDriverScope(){
        //Calculate the total number of count of Links present in the webpage
        WebDriver driver = new ChromeDriver();
        driver.get("http://qaclickacademy.com/practice.php");
        driver.findElements(By.tagName("a")).size();
        System.out.println(driver.findElements(By.tagName("a")).size());
        //Calculate the number of links present in the footer section of web page
        // For this above requirement we have to create the driver sub sets or mini driver, having limited scope to footer only
        WebElement footerDriver = driver.findElement(By.id("gf-BIG")); // limiting webdriver scope
        footerDriver.findElements(By.tagName("a")).size();
        System.out.println(footerDriver.findElements(By.tagName("a")).size());
        //Calculate the number of links on the first column of the footer
        WebElement columnDriver = footerDriver.findElement(By.xpath("//table/tbody/tr/td[1]/ul"));
        columnDriver.findElements(By.tagName("a")).size();
        System.out.println(columnDriver.findElements(By.tagName("a")).size());
        //Click on each link in the first column and check if page is opening when we click on links
        for(int i=1; i<columnDriver.findElements(By.tagName("a")).size(); i++){
            columnDriver.findElements(By.tagName("a")).get(i).click();
        }

    }


}
