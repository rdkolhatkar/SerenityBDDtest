Feature: Validate Student Login Form

  @StudentLoginForm
  Scenario Outline: Verify All Web Elements and UI Components of Student Login Form
    Given "User_ID" as "<UserEmail>"
    And "User_Password" as "<Password>"
    When User navigate to the "<BaseUrl>"
    And Click on Submit button
    Then User should see the display message as "<Message>"
    Examples:
      | UserEmail                   | Password | BaseUrl                                          | Message                         |
      | ratnakarkolhatkar@gmail.com |          | https://rahulshettyacademy.com/locatorspractice/ | You are successfully logged in. |