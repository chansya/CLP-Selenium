Feature: Add product to cart

  Scenario: Add a product to cart
    Given user is on product list page
    When user clicks on the desired product
    And user clicks the Add To Cart button
    Then the product should be in the cart
