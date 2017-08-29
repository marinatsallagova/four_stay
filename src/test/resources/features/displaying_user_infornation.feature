@Staytest_124
Feature: Displaying user information

Scenario: Verify host user information
Given I am on the fourstay login dialog
And I enter email "testscooper@test.mail.com"
And I enter password "password"
When I click on the login button
Then the user name should be "Sheldon Cooper"



Scenario: Verify host user information
Given I am on the fourstay login dialog
And I enter email "testafowler@test.mail.com"
And I enter password "password"
When I click on the login button
Then the user name should be "Amy Fowler"
