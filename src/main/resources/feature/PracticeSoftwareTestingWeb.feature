Feature: Validate Static and Dynamic Drop Down boxes

  @CheckStaticDropDown
  Scenario Outline: Verify all the Static and Dynamic Drop Downs are updated with correct attributes when user clicks on dropdown list.
    Given User Navigates to "<Url>"
    When User Clicks on Static Dropdown
    Then Static Dropdown Box Should display the Correct Value
    Examples:
      | Url                                               |
      | https://rahulshettyacademy.com/dropdownsPractise/ |