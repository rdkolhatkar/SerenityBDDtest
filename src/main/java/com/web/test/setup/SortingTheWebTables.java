package com.web.test.setup;

import net.thucydides.core.annotations.findby.By;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;
import java.util.stream.Collectors;

public class SortingTheWebTables {
    @Test
    public void sortWebTable() {
        WebDriver driver = new ChromeDriver();
        driver.get("https://rahulshettyacademy.com/seleniumPractise/#/offers");
        // Click on the column to sort the existing Web table
        driver.findElement(By.xpath("//tr//th[1]")).click();
        // Select the elements from the 1st row of the table and get the text value of all the elements in the 1st Row
        List<WebElement> elementsList = driver.findElements(By.xpath("//tr//td[1]"));
        // Now we will convert the elementList into a Java Stream
        List<String> originalList = elementsList.stream().map(s -> s.getText()).collect(Collectors.toList());
        // Now we will again apply Java Stream to the originalList and Sort it in order and compare the newOriginalList with previous originalList
        List<String> newSortedOriginalList = originalList.stream().sorted().collect(Collectors.toList());
        Assert.assertTrue(originalList.equals(newSortedOriginalList));
        driver.quit();
    }
    @Test
    public void getPriceOfProductFromSortedWebTable() {
        WebDriver driver = new ChromeDriver();
        driver.get("https://rahulshettyacademy.com/seleniumPractise/#/offers");
        // Click on the column to sort the existing Web table
        driver.findElement(By.xpath("//tr//th[1]")).click();
        // Select the elements from the 1st row of the table and get the text value of all the elements in the 1st Row
        List<WebElement> elementsList = driver.findElements(By.xpath("//tr//td[1]"));
        // Now we will convert the elementList into a Java Stream
        List<String> originalList = elementsList.stream().map(s -> s.getText()).collect(Collectors.toList());
        // Now we will again apply Java Stream to the originalList and Sort it in order and compare the newOriginalList with previous originalList
        List<String> newSortedOriginalList = originalList.stream().sorted().collect(Collectors.toList());
        // Scan the name column with get text & once you encounter Beans then you should print the price of the item
        List<String> itemPrice = elementsList.stream().filter(b -> b.getText().contains("Beans")).map(i -> getPriceOfItem(i)).collect(Collectors.toList());
        itemPrice.forEach(k -> System.out.println(k));
        driver.close();
    }
    private String getPriceOfItem(WebElement i) {
        String priceValue = i.findElement(By.xpath("following-sibling::td[1]")).getText();
        return priceValue;
    }
}
