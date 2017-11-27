Feature: Register User

  Scenario: Register a new user
    Given user is on registration page
    When he submits the registration form
    Then he should see the Dashboard page