Feature: Price has to match search criteria
@price
Scenario: As a guest I should be able to see prices on the stay
When Navigate to http://fourstay.herokuapp.com/
And Login using valid username and password
And Input search criteria, specify city"Gaithersburg"
And  Input  criteria, specify date in"03/01/2018" and date out"03/02/2018" and click search.
And Input search criteria, specify number of beds"1 Bed"
#And Input search criteria, specify price form"100" to"300"
Then Result page will be opened with stays meeting search criteria

@bedNumber
Scenario: as a user when  looking at the search results, 
the search results should update if the user changes the number of beds
When Navigate to http://fourstay.herokuapp.com/
And Login using valid username and password
And Input search criteria, specify city"Gaithersburg"
And  Input  criteria, specify date in"03/01/2018" and date out"03/02/2018" and click search.
And Input search criteria, specify number of beds"1 Bed"
And Change search criteria, specify number of beds"2 Bed"
And Verify that search result is updated and matching new search criteria
Then Result page will be opened with stays meeting search criteria
