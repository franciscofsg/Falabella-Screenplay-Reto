
Feature: Add product to cart

  Scenario: Add product to cart successfully

    Given that the user open the Falabella page and searches for any product.

    When the user select a product from the list of search results and select the quantity of the product to cart by clicking on Add to cart.

    Then the user verifies that the name of the product in the cart is equal to the name of the product selected

    And the user verifies that the quantity of products in the cart is equal to the quantity of the selected product.
