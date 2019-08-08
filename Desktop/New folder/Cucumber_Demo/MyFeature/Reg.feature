Feature: MyTestMe Validation

Scenario: As a user I want to Register

Given Application is up andlaunched
When User click on register button
Then Application is opened
And User provide valid data
Then Login Success
