@Activity2_5
Feature: Login Test

Scenario Outline: Testing Login with examples
    Given User is on Login Page
    When User enters "<usernames>" and "<passwords>"
    Then Read the page title and confirmation message
    And Close the browser
    
  Examples:
  |usernames|passwords|
  |admin|password|
	|admin2|password2|