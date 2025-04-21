package com.web.test.setup;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class SeleniumWaits {

    public static void main(String[] args) {

        // Set the path to the chromedriver executable
        System.setProperty("webdriver.chrome.driver", "path/to/chromedriver");

        // Create a new instance of ChromeDriver
        WebDriver driver = new ChromeDriver();

        // Maximize the browser window
        driver.manage().window().maximize();

        // ********* IMPLICIT WAIT DEMO *********
        // Set an implicit wait of 10 seconds
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        // Open the automation practice website
        driver.get("https://rahulshettyacademy.com/AutomationPractice/");

        // Find the element that is available instantly using implicit wait
        WebElement radioButton = driver.findElement(By.cssSelector("input[value='radio1']"));
        radioButton.click(); // Click the radio button

        // ********* EXPLICIT WAIT DEMO *********

        // Click the "Display" button to make a hidden element visible after a delay
        WebElement displayButton = driver.findElement(By.id("display-button"));
        displayButton.click();

        // Create an explicit wait object with a max timeout of 10 seconds
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        // Wait until the text box with id 'displayed-text' is visible
        WebElement textBox = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("displayed-text")));

        // Once it's visible, enter some text
        textBox.sendKeys("Hello, I waited for you!");

        // Optional: Pause to see the result
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // Close the browser
        driver.quit();
    }

}
