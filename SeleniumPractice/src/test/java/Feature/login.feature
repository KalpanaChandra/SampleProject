Feature: ParaSoft Home Page

Scenario: ParaSoft Home Page Test Scenario

Given Parasoft broswer is launched
When user is on home page
Then user can see login button

Scenario Outline: ParaSoft Login Scenarios for multiple users

Given User is in Login screen
When User enters username as "<name>" and password as "<password>"
Then User is logged in successfully
Then User logs out

Examples:
|name|password|
|john|demo|
|oliver|demo|
