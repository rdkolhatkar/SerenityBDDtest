Feature: Validate Student Registration Form

  @Test
  Scenario Outline: Verify All Web Elements and UI Components of Student Registration Form
    Given "Student_Name" as "<name>"
    And The "Student_Email" as "<email>"
    And The Mobile "Student_Phone" as "<phone>"
    And The Student's date of birth "Student_Date_Of_Birth" as "<DOB>"
    And The Elective "Student_Subjects" as "<subjects>"
    And The Current Address "Student_Address" as "<currentAddress>"
    When Gender, Hobby, State and City are selected successfully
    Then Click on Submit button
    Examples:
      | name    | email             | phone      | DOB        | subjects              | currentAddress                     |
      | Sanjeev | sanjeev@gmail.com | 2432121091 | 14-09-1999 | Environmental Science | Street No. 12, SG. Apartment, Pune |