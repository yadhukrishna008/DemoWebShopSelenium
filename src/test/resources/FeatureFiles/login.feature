Feature: User Login

@smoke @tag
	Scenario Outline: Login validation
	  Given user navigates to login page
	  When user enters email "<email>"
	  And user enters password "<password>"
	  And user clicks login
	  Then login result should be "<result>"
	
	Examples:
	| email        | password     | result          |
	| valid_user   | valid_pass   | success         |
	| invalid_user | valid_pass   | no_customer_err |
	| valid_user   | invalid_pass | invalid_cred    |
	|              | valid_pass   | no_customer_err |
	| valid_user   |              | invalid_cred    |
	|              |              | no_customer_err |