Feature: Flight Booking

  Scenario: Flight Options
    Given user is on Home page
    When he finds flight:
      | from | Boston |
      | to   | London |
    Then he should see the flight options

  Scenario: Flight Details
    Given user is on Home page
    When he finds flight:
      | from | Boston |
      | to   | London |
    Then he should see the flight options
    And he selects flight "234"
    Then he should see the flight details:
      | flight  | 234             |
      | airline | United Airlines |