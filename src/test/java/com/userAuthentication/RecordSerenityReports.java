package com.userAuthentication;

import net.serenitybdd.core.Serenity;
import org.junit.jupiter.api.Test;

public class RecordSerenityReports {

    @Test
    public  void runTest() {
        // Step 1: Perform some logic (e.g., a test case step)
        String actualResult = "Login successful";
        String expectedResult = "Login successful";

        // Step 2: Use Serenity.reportThat to add a custom description to the report
        Serenity.reportThat("Verify that the login process completes successfully", () -> {
            // Developer's Note:
            // This block contains the assertion or logic to evaluate.
            if (!actualResult.equals(expectedResult)) {
                throw new AssertionError("Expected: " + expectedResult + ", but got: " + actualResult);
            }
        });

        // Developer's Note:
        // `Serenity.reportThat()` is used to:
        // - Add a custom description to the Serenity report.
        // - Execute a block of code (typically an assertion) and report its result.
        // - If the assertion fails, it will be reflected in the Serenity report.

        // Step 3: Add another example for better understanding
        Serenity.reportThat("Validate the page title after navigation", () -> {
            String actualTitle = "Dashboard";
            String expectedTitle = "Dashboard";

            // Simulated assertion logic
            if (!actualTitle.equals(expectedTitle)) {
                throw new AssertionError("Expected title: " + expectedTitle + ", but got: " + actualTitle);
            }
        });

        // Log success message
        System.out.println("Assertions executed and reported in Serenity!");
    }

    @Test
    public void runSampleTest() {
        // Step 1: Perform some logic (e.g., a test case step)
        String testData = "Test Execution Data: Sample result details.";

        // Step 2: Record the data to Serenity report
        Serenity.recordReportData().withTitle("Test Data Summary").andContents(testData);

        // Developer's Note:
        // The `withTitle()` method sets the title for the recorded data in the Serenity report.
        // The `andContents()` method specifies the content to display under the given title.

        // Step 3: Another example with table content
        String tableData = "| Name       | Result  |\n" +
                "|------------|---------|\n" +
                "| Test Case  | Passed  |\n" +
                "| Test Case 2| Failed  |";

        Serenity.recordReportData().withTitle("Test Results Table").andContents(tableData);

        // Developer's Note:
        // Content can also be formatted as markdown, such as tables or lists.
        // This allows better readability in the Serenity UI.

        // Log success message
        System.out.println("Data has been recorded in Serenity reports!");
    }
}
