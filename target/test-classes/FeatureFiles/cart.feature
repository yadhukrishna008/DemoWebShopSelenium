Feature: Cart Management
  As a logged-in user
  I want to manage my shopping cart
  So that I can proceed to checkout with the correct items

  Background:
    Given user is logged in to the account

  @smoke @cart
  Scenario Outline: Add and verify product from specific category
    Given user hovers over category "<category>" and select "<subCategory>"
    When user adds the product "<product>" to the cart
    Then the cart should display "<product>" with quantity "1"

    Examples:
      | category  | subCategory | product      |
      | Computers | Desktops    | Build your own computer |
      | Apparel   | Shoes       | Blue and red Sneaker    |

  @regression
  Scenario: Update product quantity in cart
    Given user has "1" item of "TCP Self-Paced Training" in the cart
    When user updates the quantity to "5"
    Then the cart total price should reflect "5" units

  @regression
  Scenario: Remove last product from cart
    Given user has "1" item in the cart
    When user removes the item from the cart
    Then the message "Your Shopping Cart is empty!" should be displayed
    
   @negative @regression
  Scenario: Attempt to add an out-of-stock item
    Given user navigates to a product page that is "Out of Stock"
    Then the "Add to Cart" button should be disabled
    And an "Out of stock" label should be visible

  @logic @regression
  Scenario: Verify total price updates automatically
    Given user has "1" item of "Smartphone" at "$200" in the cart
    When user updates the quantity of "Smartphone" to "2"
    Then the "Sub-Total" should display "$400"

  @boundary @regression
  Scenario: Set quantity to zero
    Given user has "1" item in the cart
    When user updates the quantity to "0"
    Then the item should be removed from the cart