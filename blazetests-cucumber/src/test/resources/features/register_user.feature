Feature: Register User

  Scenario: Register a new user
    Given user is on registration page
    When submits the registration form with all the fields
    Then he should see the Dashboard page