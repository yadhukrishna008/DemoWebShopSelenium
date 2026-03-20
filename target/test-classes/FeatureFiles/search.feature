Feature: Product Search

	@search
  Scenario: Search for existing product using partial keyword
    Given user is on home page
    When user searches for product "computer"
    Then relevant products of "computer" should be displayed
	
	@search
  Scenario: Search for non existing product
    Given user is on home page
    When user searches for product "randomnonexistentproduct"
    Then "No products were found that matched your criteria." search error should appear
	
  @search
  Scenario: Search with empty keyword
    Given user is on home page
    When user searches for product ""
    Then system should display "Please enter some search keyword" alert
    