Feature: User Registration

@smoke
Scenario: Successful user registration
  Given user navigates to registration page
  When user enters valid registration details
  And user submits the registration form
  Then user account should be created successfully

@smoke
Scenario: Register with blank mandatory fields
  Given user navigates to registration page
  When user submits the registration form
  Then validation errors should appear

@smoke
Scenario Outline: Registration validation scenarios
  Given user navigates to registration page
  When user enters registration details "<email>" "<password>" "<confirmPassword>"
  And user submits the registration form
  Then "<errorMessage>" should appear

	Examples:
	| email              | password | confirmPassword | errorMessage            |
	| existing@mail.com  | Test123  | Test123         | duplicate email error   |
	| invalidmail        | Test123  | Test123         | email validation error  |
	| user@mail.com      | Test123  | Test456         | password mismatch error |
	