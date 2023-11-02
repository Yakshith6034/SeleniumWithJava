Feature: Login in BookCart Application

  Background: 
    # This background section defines common steps that are executed before each scenario.
    Given when user navigates to the BookCart application

  #Given user clicks on the login button
  Scenario: Login should be success
    # This scenario tests a successful login attempt.
    Given User enters the username
    Given User enters the password
    When user clicks on the login button
    Then Login should be successful

  Scenario: Login should fail with invalid username and password
    #This scenario tests a failed login attempt.
    Given user enters the invalid username
    Given user enters the invalid password
    When user clicks on the login button
    Then Login should be Fail

  Scenario: Login should fail with valid username and invalid password
    #This scenario tests a failed login attempt.
    Given user enters a valid username
    Given User enters an invalid password
    When user clicks on the login button
    Then Login should be Fail

  Scenario: Login should fail with invalid username and valid password
    #This scenario tests a failed login attempt.
    Given user enters the invalid username
    Given user enters a valid password
    When user clicks on the login button
   # Then Login should be Fail
