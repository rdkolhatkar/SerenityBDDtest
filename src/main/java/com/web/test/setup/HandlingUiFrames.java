package com.web.test.setup;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class HandlingUiFrames {

    @Test
    public void handlingUiFrames(){
        WebDriver driver = new ChromeDriver();
        driver.get("http://jqueryui.com/droppable/");
        // Frames are sub-windows or sections within a single browser window. Frames are the part of the website which is not an Integral part of Web Element but they are hosted in our website as a part of external service.
        // To handle frames in the selenium below syntax is used
        driver.switchTo().frame(1);
    }
}
