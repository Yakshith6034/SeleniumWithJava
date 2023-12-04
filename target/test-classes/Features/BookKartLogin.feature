Feature: Login Functionality in BookCart Application

  Background: 
    # This background section defines common steps that are executed before each scenario.
    Given when user navigates to the BookCart application

  #Given user clicks on the login button
  Scenario: Login should be success
    # This scenario tests a successful login attempt.
    And User enters the username
    And User enters the password
    When user clicks on the login button
    Then Login should be successful

  Scenario: Login should fail with invalid username and password
    #This scenario tests a failed login attempt.
    And user enters the invalid username
    And user enters the invalid password
    When user clicks on the login button
    Then Login should be Fail

  Scenario: Login should fail with valid username and invalid password
    #This scenario tests a failed login attempt.
    And user enters a valid username
    And User enters an invalid password
    When user clicks on the login button
    Then Login should be Fail

  Scenario: Login should fail with invalid username and valid password
    #This scenario tests a failed login attempt.
    And user enters the invalid username
    And User enters the password
    When user clicks on the login button
    Then Login should be Fail
