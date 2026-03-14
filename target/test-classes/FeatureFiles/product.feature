Feature: Product Browsing and Selection

	Background:
    Given user is logged in to the account
    Given user hovers over category "Computers" and select "Desktops"
  
  @pro
  Scenario: View products by category
    Given user is on product sub category page "Desktops"
    Then list of products should be displayed

  @pro
  Scenario: View product details
    Given user opens product "Build your own computer"
    Then "Build your own computer" product details page should be displayed

  @pro
  Scenario: Configure customizable product
    Given user opens product "Build your own computer"
    When user selects product configuration options
    And user adds product to cart
    Then product should be added successfully
 
  @pro
  Scenario: Verify product price updates after configuration
    Given user opens product "Build your own computer"
    When user changes product configuration
    And user adds product to cart
    Then product price should update accordingly
    
  @pro
  Scenario: Attempt to add product without selecting required options
    Given user opens product "Build your own computer"
    When user adds product to cart
    Then validation error message should appear
    