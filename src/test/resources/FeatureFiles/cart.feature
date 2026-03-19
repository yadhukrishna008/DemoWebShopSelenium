Feature: Cart Management
  I want to manage my shopping cart
  So that I can proceed to checkout with the correct items

  @cart
  Scenario Outline: Add and verify product from specific category
    Given user hovers over category "<category>" and select "<subCategory>"
    When user adds the product "<product>" to the cart
    Then the cart should display "<product>" with quantity "1"

    Examples:
      | category    | subCategory | product          |
      | Computers   | Notebooks   | 14.1-inch Laptop |
      | Electronics | Cell-phones | Smartphone       |

  @cart
  Scenario: Update product quantity and verify sub-total calculation
    Given user has "1" item of "TCP Self-Paced Training" in the cart at $"400.00"
    When user updates the quantity of "TCP Self-Paced Training" to "5"
    Then the Sub-Total should display $"2000.00"

  @cart
  Scenario: Remove product from cart
    Given user has "1" item of "3rd Album" in the cart
    When user removes the item from the cart
    Then the message "Your Shopping Cart is empty!" should be displayed
    
  @cart
  Scenario: Set quantity to zero to remove item
    Given user has "1" item of "TCP Self-Paced Training additional month" in the cart
    When user updates the quantity of "TCP Self-Paced Training additional month" to "0"
    Then the message "Your Shopping Cart is empty!" should be displayed
    
  @cart 
  Scenario: Attempt to add an out-of-stock item
    Given user search and opens product "Custom T-Shirt"
    Then the "Add to Cart" button should be disabled
    And an "Out of stock" label should be visible

  
    