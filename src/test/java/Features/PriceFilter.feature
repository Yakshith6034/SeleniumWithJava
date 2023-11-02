Feature: Product Filtering by Price

Scenario: user should see the list of products from the selected price filter
    Given the user opens the BookCart Application
    And User enters username
    And User enters password
    When User clicks on Login button
    Then the user adjusts the price filter settings and display the products
 