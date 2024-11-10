Feature: Validate REST API
  @Api
  Scenario Outline: Verify if Add Place API is working as expected
    Given Name "name" as "<name>"
    And The PhoneNumber "phone_number" as "<phone_number>"
    And The Address "address" as "<address>"
    And The Language "language" as "<language>"
    And URL value of Website "website" as "<website>"
    When API is invoked
    Then Status response code is "201"
    Examples:
      | name            | phone_number       | address                   | language  | website           |
      | Frontline house | (+91) 983 893 3937 | 29, side layout, cohen 09 | French-IN | http://google.com |
