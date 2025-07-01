package com.web.test.setup;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

public class HandlingBrokenLinks {
    @Test
    public void handlingBrokenLink() throws IOException {
        WebDriver driver = new ChromeDriver();
        driver.get("https://rahulshettyacademy.com/AutomationPractice");
        // Broken link means, a link present on the UI which gives Page Not Found Error when user clicks on it to navigate to that functionality.
        // There are some Java methods that will be calling all the existing routes present on the webpage which are linked with HTML Tag href, for Example: <a href="https://rahulshettyacademy.com/brokenlink">Broken Link</a>
        // Step-1: Get all urls tied up with link attribute href using selenium
        // If http status code of the url is greater than 400 then we call that link as broken
        String url = driver.findElement(By.cssSelector("a[href*='brokenlink']")).getAttribute("href");
        // Java method to invoke url or call any http link
        HttpURLConnection connection = (HttpURLConnection)new URL(url).openConnection();
        connection.setRequestMethod("HEAD"); //.setRequestMethod("HEAD") is used to post the http or https links with their endpoints
        connection.connect(); //.connect() method is used to invoke the route on the browser to establish the connection
        int httpResponseCode = connection.getResponseCode(); //.getResponseCode() method is used to check the http response of a route
        System.out.println(httpResponseCode);

    }

    @Test
    public void handlingMultipleLinksToSearchBrokenLink(){

    }
}
