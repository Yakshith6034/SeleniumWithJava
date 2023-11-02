Feature: Remove from Cart Functionality

  Scenario: Remove a item to Cart
    # This scenario describes the steps to remove an item from the cart.
    Given the user navigates to the BookCart application1
    And user navigates to the BookCart
    When the cart contains the selected item
    Then the user removes the item from the cart

  Scenario: Display Empty Cart Message after Removing Book
    # This scenario focuses on the situation when the cart is empty after removing a book.
    Given the user navigates to the BookCart application1
    And user navigates to the BookCart
    And user searches for a book
    When user add the book to the cart
    And the user removes the item from the cart
    Then the user should see a message indicating an empty cart
    
    
 Scenario: Check the state of the Delete button
    # This scenario focuses on verifying the state of the Delete button.
    Given the user navigates to the BookCart application1
    And user navigates to the BookCart
    And user searches for a book
    And user add the book to the cart
    When the user clicks on the cart, they should be navigated to the cart page.
    Then Delete button should be enabled
    
    
    
    
