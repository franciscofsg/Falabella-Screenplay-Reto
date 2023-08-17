Feature: Add product to cart

  Scenario: Add product to cart success
    Given that user open the page Falabela and search any product
    When user click on product tittle and user click on add to cart
    Then the user can read the product name from excel.
