Feature: Search Functionality
@search
Scenario: Searchbar shoud be displayed
	Given user is on fourstay home page 
	When  user clicks on the login link 
	And enter guest email and guest password
	And hit enter
	Then the search bar should be displayed
	But enter text and click on search
	And enter move in date
	And enter move out date
	And select number of beds
	
	
