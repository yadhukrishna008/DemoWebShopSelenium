Feature: End to End Order Placement

#	@e2e
  Scenario: Complete product purchase flow
    Given user navigates to login page
    And user logs in with valid credentials
    When user searches for product "computer"
    And user opens product "Build your own computer"
    And user selects product configuration options
    And user adds product to cart
    And user navigates to cart
    And user proceeds to checkout
    And user completes checkout with valid details
    Then order should be placed successfully

	@e2e
  Scenario: Attempt order without login
    Given guest user has product in cart
    When user proceeds to checkout
    Then system should request login