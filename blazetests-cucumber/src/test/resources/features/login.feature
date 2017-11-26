Feature: Login

  Scenario: User should login with valid email and password
    Given user is on Login page
    When he enters his credentials:
      | email    | user16112017@test.com |
      | password | p@ssword              |
    Then he should see the Dashboard

  Scenario: User should login with valid email and invalid password
    Given user is on Login page
    When he enters his credentials:
      | email    | user16112017@test.com |
      | password | 8787shhss             |
    Then he should see error message
      """
      These credentials do not match our records.
      """