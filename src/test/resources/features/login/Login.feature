#language: en

@TESTS
  Feature: Login feature

  @TEST1
  Scenario: Successful login
    Given the user is on the login page
    When the user enters valid credentials
    Then the user should be logged in
