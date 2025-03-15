package com.dataDrivenTest;

import net.serenitybdd.annotations.Managed;
import net.serenitybdd.junit.runners.SerenityParameterizedRunner;
import net.thucydides.junit.annotations.Qualifier;
import net.thucydides.junit.annotations.TestData;
import org.junit.jupiter.api.Test;

import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;

import java.util.Arrays;
import java.util.Collection;

@RunWith(SerenityParameterizedRunner.class)
public class DataDrivenTesting {

    @Managed(driver = "chrome", options = "--headless")
    WebDriver driver;

    private final String a;
    private final String b;

    public DataDrivenTesting(String a, String b) {
        this.a = a;
        this.b = b;

    }
    @TestData(columnNames = "A,B,Total")
    public static Collection<Object[]> testData(){
        return Arrays.asList(
          new Object[][]{
                  {"1","2","3"},
                  {"2","3","4"},
                  {"10","20","30"},
                  {"10","-7","-3"}
          }
        );
    }

    @Qualifier
    public String qualifier(){return a + " + " + b + " Should Equal ";}


    public void CalculationTest(){

        int sum = Integer.parseInt(a) + Integer.parseInt(b);
        String total = String.valueOf(sum);

        // Print the result
        System.out.println("Total: " + total);


    }

}
