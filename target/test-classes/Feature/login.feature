Feature: Test login functionality

Scenario: Check login is successful with valid credentials

Given user is on login page
When user enter username and password
Then user is navigate to home page