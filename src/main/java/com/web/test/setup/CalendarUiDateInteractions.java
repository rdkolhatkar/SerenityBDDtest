package com.web.test.setup;

import net.thucydides.core.annotations.findby.By;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class CalendarUiDateInteractions {

    @Test
    public void calendarUiDateAssertion(){
        String monthNumber = "6";
        String date = "15";
        String year = "2027";

        WebDriver driver = new ChromeDriver();
        driver.get("https://rahulshettyacademy.com/seleniumPractise/#/offers");
        driver.findElement(By.cssSelector(".react-date-picker__inputGroup")).click();
        driver.findElement(By.cssSelector(".react-calendar__navigation__label")).click();
        driver.findElement(By.cssSelector(".react-calendar__navigation__label")).click();
        driver.findElement(By.xpath("//button[text()='"+ year +"']")).click();
        // In the calendar Months are displayed as January, February, March, .... , December. But in our case we are receiving input in the number format like Month number is 6 and we have to configure Month Number with Month name like 6 == June
        driver.findElements(By.cssSelector(".react-calendar__year-view__months__month")).get(Integer.parseInt(monthNumber)- 1).click();
        driver.findElement(By.xpath("//abbr[text()='"+date+"']")).click();

    }
}
