package com.web.test.setup;

import net.thucydides.core.annotations.findby.By;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.Arrays;
import java.util.List;

public class EndToEndAutomationGreenKart {
    @Test
    public void greenKartTestAutomation() throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.get("https://rahulshettyacademy.com/seleniumPractise/");
        /*
        Use the below method when there are multiple elements with same class name, id and css text name present in the Web Page
        And among them you want to retrieve the unique element for UI Validation
        */
        // Retrive the multiple products

       String[] itemsNeeded = {"Cucumber", "Brocolli", "Beetroot", "Brinjal", "Tomato"};
       List<WebElement> products = driver.findElements(By.cssSelector("h4.product-name"));
       for(int i=0; i< products.size(); i++){
           // Logic to remove the extra string from the name displayed in the webpage like converting "Brocolli - 1Kg" to "Brocolli"
           // String name = products.get(i).getText();
           // name[0] = "Brocolli" & name[1] = "1kg"
           //remove all the spaces after "Brocolli"
           String[] name = products.get(i).getText().split("-");
           String formattedName = name[0].trim();
           List vegetables = Arrays.asList(itemsNeeded);
           int j =0;
           if(vegetables.contains(formattedName)){
               j++;
               driver.findElements(By.xpath("//button[text()='ADD TO CART']")).get(i).click();
               System.out.println(j);
               if(j == Arrays.stream(itemsNeeded).count()){
                   break;
               }
           }

       }
       Thread.sleep(5000);
       driver.close();
    }
}
