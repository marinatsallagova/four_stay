Feature: Fourstay login window 

Scenario: Email field should be displayed 
	Given the user is on fourstay home page 
	When the user clicks on the login link 
	And enter wrong email and correct password
	And click enter
	Then the email field should be displayed 
	
