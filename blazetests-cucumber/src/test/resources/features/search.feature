Feature: Search Flights

  Scenario: Search Flights
    Given user is on Home page
    When he search flight:
      | from | Boston |
      | to   | London |
    Then he should see the flight options

  Scenario: Flight Details
    Given user is on Home page
    When he search flight:
      | from | Boston |
      | to   | London |
    Then he should see the flight options
    And he selects flight "234"
    Then he should see the flight details:
      | flight  | 234             |
      | airline | United Airlines |