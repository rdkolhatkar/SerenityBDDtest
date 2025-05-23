package com.web.test.setup;

import net.thucydides.core.annotations.findby.By;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.Iterator;
import java.util.Set;

public class WindowHandle {

    @Test
    public void handlingChildWindows(){
        WebDriver driver = new ChromeDriver();
        driver.get("https://rahulshettyacademy.com/loginpagePractise/#");
        // Window Handle concept
        driver.findElement(By.cssSelector(".blinkingText")).click();
        Set<String> windows = driver.getWindowHandles(); // this method will return the list of Windows Opened in the browser
        Iterator<String> iterator = windows.iterator(); // With this method we can Iterate the Set returned by the getWindowHandles() method
        String parenrId = iterator.next(); // Now control is on parent window ID that is Zero Index. Now to select the child window we have perform iterator.next() one more time
        String childId = iterator.next();
        driver.switchTo().window(childId);
        System.out.println(driver.findElement(By.cssSelector(".im-para.red")).getText());
    }
}
