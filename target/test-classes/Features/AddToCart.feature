Feature: Add Product to Cart Functionality

  Background: 
    # Setting up the common steps that need to be performed before each scenario
    Given the user navigates to the BookCart application1
    And user navigates to the BookCart
    When user searches for a book

  Scenario: Verify Add to Cart button is enabled state
    # This scenario tests the Add to Cart button to ensure it is in an enabled state.
    Then button should be in  enable state

  Scenario: Increase product quantity in the cart upon multiple clicks on Add to Cart button
    # This scenario evaluates the behavior when the user clicks the Add to Cart button multiple times.
    And the user clicks the Add to Cart button multiple times
    Then the quantity of the product in the cart should be equal to the total number of clicks

  Scenario: Add a item to Cart
    # User adds a book to their cart and verifies the cart badge updates
    And user add the book to the cart
    Then the cart badge should get updated
