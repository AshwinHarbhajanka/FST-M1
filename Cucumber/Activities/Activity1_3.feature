@Activity1_3
Feature: Testing with Tags

@SimpleAlert @SmokeTest
Scenario: Testing with Simple Alert
    Given User is on the page
    When User clicks the simple alert button
    Then Alert opens
    And Read the text from the alert and print it
    And Close the alert
    And Close the browser
    
@ConfirmAlert
  Scenario: Testing with Confirm Alert
    Given User is on the page
    When User clicks the confirm alert button
    Then Alert opens
    And Read the text from the alert and print it
    And Close the alert with cancel
    And Close the browser

@PromptAlert
  Scenario Outline: Testing with Prompt Alert
    Given User is on the page
    When User clicks the prompt alert button
    Then Alert opens
    And Read the text from the alert and print it
    And Write a "<message>" in it
    And Close the alert
    And Close the browser

    Examples:
    | message |
    | Prompt Alert |
    
    