Feature: Search for products
  Background:
    Given user is on the home page

    # Positive test
  Scenario: Search for a valid product
    When user types a valid product name in the search bar
    And user presses the search icon
    Then A page showing the search result should appear

    # Negative test
  Scenario: Search for an invalid product
    When user types an invalid product name in the search bar
    And user presses the search icon
    Then A page showing no result is found should appear
     # success alert is still shown
