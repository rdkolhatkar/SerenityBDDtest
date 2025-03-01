package com.timeouts;

import net.serenitybdd.core.pages.PageObject;
import net.thucydides.core.annotations.findby.By;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.time.Duration;

public class DynamicallyLoadingPage extends PageObject {

    public void start(){
        $("#start button").click();

        // This is a Inbuilt serenity function used for waiting for an element by using expected conditions like in our case we have a loading bar.
        // Our code will wait till that loading bar disappears from UI
        //waitFor(ExpectedConditions.invisibilityOfElementLocated(By.id("loading")));

        /*
        This ExpectedConditions.visibilityOfElementLocated method from waitFor() will be holding our code execution till finish element is visible.
         */
        withTimeoutOf(Duration.ofSeconds(10));
        waitFor(ExpectedConditions.visibilityOfElementLocated(By.id("finish")));
    }
    public String result(){
        return $("#finish").getText();
    }
}
