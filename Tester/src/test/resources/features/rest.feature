Feature: Google Search functionality

  # Scenario 1: Valid Search Scenario
  Scenario: Searching for a valid term on Google
    Given I am on the Google homepage
    When I search for "Cucumber BDD"
    Then I should see search results for "Cucumber BDD"

  # Scenario 2: Invalid Search Scenario
  Scenario: Searching for a non-existent term on Google
    Given I am on the Google homepage
    When I search for "XYZ1234567890"
    Then I should see no results for "XYZ1234567890"