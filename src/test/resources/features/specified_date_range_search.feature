Feature: user should be able to search stay for the a specified date range

Scenario: User specifies location, day in, day out and number of beds while searching for the stay. 
Given  Navigate to http://fourstay.herokuapp.com/
And  Input search criteria, specify date in"03/01/2018" and date out"03/02/2018" and click search.
Then  results should contain
|District of Columbia|
|Maryland|
|Virginia|

