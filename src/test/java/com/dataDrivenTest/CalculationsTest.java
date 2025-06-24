package com.dataDrivenTest;

import net.serenitybdd.annotations.Managed;
import net.serenitybdd.junit.runners.SerenityParameterizedRunner;
import net.thucydides.junit.annotations.Concurrent;
import net.thucydides.junit.annotations.Qualifier;
import net.thucydides.junit.annotations.TestData;
import net.thucydides.junit.annotations.UseTestDataFrom;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.assertEquals;

@RunWith(SerenityParameterizedRunner.class)
@Concurrent
@UseTestDataFrom("data/calculation.csv") // @UseTestDataFrom is the serenity annotation used for passing the path of the datafile inside our test
public class CalculationsTest {

    private String a;
    private String b;
    private String total;


    // When Serenity Injects the data it uses the data driven interface of the serenity, So we have to remove the existing constructor
/*
    private final String a;
    private final String b;
    private final String total;

    @Managed(driver = "chrome", options = "--headless")
    WebDriver driver;

    public CalculationsTest(String a, String b, String total){
        this.a = a;
        this.b = b;
        this.total = total;
    }
*/

    @Managed(driver = "chrome", options = "--headless")
    WebDriver driver;
/*
    @TestData(columnNames = "A,B,Total")
    public static Collection<Object[]> testData(){
        return Arrays.asList(
                new Object[][]{
                        {"1","2","3"},
                        {"10","20","30"},
                        {"10","0","10"},
                        {"10","-5","5"},
                        {"10000","20000","30000"}
                }
        );
    }

 */

    @Qualifier
    public String qualifier() {
        return a + " + " + b + " Should Equal " + total;
    }

    @Test
    public void shouldAddStringNumbersCorrectly() {
        int sum = Integer.parseInt(a) + Integer.parseInt(b);
        String total = String.valueOf(sum);
        assertEquals("Sum mismatch!", total, total);
    }

}
