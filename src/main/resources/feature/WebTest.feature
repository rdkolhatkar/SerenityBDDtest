Feature: Validate Student Registration Form
  @Test
  Scenario Outline: Verify All Web Elements and UI Components of Student Registration Form
    Given Student_Name" as "<name>"
    And "Student_Email" as "<email>"
    And "Student_Phone" as "<phone>"
    And "Student_Date_Of_Birth" as "<DOB>"
    And "Student_Subjects" as "<subjects>"
    And "Student_Address" as "<currentAddress>"
    When Gender, Hobby, State and City are selected sucessfully
    Then Click on Submit button
    Examples:
      | name | email | phone | DOB | subjects | currentAddress |