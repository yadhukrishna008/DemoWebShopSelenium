Feature: Checkout Process

	@checkout
  Scenario: Successful checkout with valid details
    Given user has product in cart
    When user proceeds to checkout
    And user enters valid billing and shipping details
    And user selects shipping and payment method
    And user confirms the order
    Then order should be placed successfully

	@checkout
  Scenario: Guest user attempts checkout
    Given guest user has product in cart
    When user proceeds to checkout
    Then system should request login

	@checkout
  Scenario: Checkout with missing mandatory details
    Given user has product in cart
    When user proceeds to checkout
    And user leaves mandatory checkout fields empty
    Then validation errors should appear in checkout

	@checkout
  Scenario: Checkout with invalid payment information
    Given user has product in cart
    When user proceeds to checkout
    And user enters valid billing and shipping details
    And user enters invalid payment details
    Then payment error message should appear
    