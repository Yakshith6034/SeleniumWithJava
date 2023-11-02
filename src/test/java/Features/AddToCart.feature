Feature: Add to Cart Functionality

  #Background: 
    # Setting up the common steps that need to be performed before each scenario
    #Given the user navigates to the BookCart application1
    #And user navigates to the BookCart

  Scenario: Add a item to Cart
    #User adds a book to their cart and verifies the cart badge updates
    Given the user navigates to the BookCart application1
    And user navigates to the BookCart
    And user searches for a book
    When user add the book to the cart
    Then the cart badge should get updated

  