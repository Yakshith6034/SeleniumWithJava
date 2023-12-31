Feature: User Registration Process

  Background: 
    Given the user navigate to the Cart application
    And user clicks on  login button
    When the user clicks on the Register button

  #Scenario to test successful user registration.
  Scenario: User Should be registered Successfully
    And the user enters the First Name
    And the user enters the Last Name
    And the user enters the User Name
    And the user enters the Password
    And the user enters the Confirm Password
    When the user select the Gender
    Then the user details should be saved successfully

  Scenario: Verify when user enters the only UpperCase letter in Password
    # This scenario tests the behavior when the user enters a password containing only uppercase characters.
    And the user enters the First Name
    And the user enters the Last Name
    And the user enters the User Name
    When they enter a password with only uppercase characters
    Then Appropriate field validation messages should be displayed

  # This scenario focuses on the validation of mandatory fields during the registration process.
  Scenario: Registration Error Message Validation for Mandatory fields
    When the user submits the form without entering mandatory field
    Then the user should see validation messages indicating the required fields
