package com.timeouts;

import net.serenitybdd.annotations.DefaultUrl;
import net.serenitybdd.annotations.Managed;
import net.serenitybdd.core.Serenity;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;

import static org.assertj.core.api.Assertions.assertThat;


public class SerenityTimeoutsWebPageLoading {

    @Managed(driver = "chrome") // This line of code is to specify type of driver, No need to add driver.exe file separately. Serenity provides inbuilt driver settings
    WebDriver driver;
    String webHostUrl = Serenity.environmentVariables().getProperty("app.base.url");
    DynamicallyLoadingPage dynamicallyLoadingPage;
    @Test
    public void waitForAnElementToAppear(){
        driver.get(webHostUrl);
        dynamicallyLoadingPage.start();

        assertThat(dynamicallyLoadingPage.result()).isEqualTo("Hello World!");

    }


}
