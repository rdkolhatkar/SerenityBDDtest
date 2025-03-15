package com.dataDrivenTest;

import net.serenitybdd.junit.runners.SerenityParameterizedRunner;
import net.thucydides.junit.annotations.Qualifier;
import net.thucydides.junit.annotations.TestData;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import java.util.Arrays;
import java.util.Collection;
import static org.junit.Assert.assertEquals;


/**
 * Serenity BDD Data-Driven Test for Adding Two String Numbers
 *
 * This test demonstrates how to use SerenityParameterizedRunner to perform data-driven testing.
 * It takes two numbers as String inputs, adds them, and verifies the expected total.
 * The test is executed multiple times with different data sets provided by the @TestData annotation.
 *
 * Annotations used:
 * - @RunWith(SerenityParameterizedRunner.class): Runs the test using Serenity's parameterized runner.
 * - @TestData(columnNames = "A,B,Total"): Defines test data columns used for the parameterized test.
 * - @Qualifier: Provides a readable test case name based on input values.
 * - @Test: Marks the method as a test case.
 */
@RunWith(SerenityParameterizedRunner.class) // Serenity runner for data-driven testing
public class DataDrivenTesting {


    private final String a;
    private final String b;
    private final String expectedTotal;

    public DataDrivenTesting(String a, String b, String expectedTotal) {
        this.a = a;
        this.b = b;
        this.expectedTotal = expectedTotal;
    }

    /**
     * Provides the test data to be used in the test.
     * - The data consists of multiple test cases in a list.
     * - Each test case contains values for "A", "B", and the expected "Total".
     *
     * @return A collection of test data values.
     */
    @TestData(columnNames = "A,B,Total")
    public static Collection<Object[]> testData() {
        return Arrays.asList(new Object[][]{
                {"1", "2", "3"},
                {"5", "10", "15"},
                {"100", "200", "300"},
                {"0", "0", "0"}
        });
    }
    /**
     * Generates a readable test name for each test execution.
     * This helps in debugging by displaying meaningful test descriptions in reports.
     *
     * @return A formatted string representing the test case scenario.
     */
    @Qualifier
    public String qualifier() {
        return a + " + " + b + " Should Equal " + expectedTotal;
    }

    @Test
    public void shouldAddStringNumbersCorrectly() {
        int sum = Integer.parseInt(a) + Integer.parseInt(b);
        String total = String.valueOf(sum);
        assertEquals("Sum mismatch!", expectedTotal, total);
    }

}


