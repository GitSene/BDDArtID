Feature: Testing registration page with different values
As a company our customer should register
with correct data
so that we can refer them easily

Background:
Given you are in registration page "http://newtours.demoaut.com/mercuryregister.php"
And Add correct data to registration form
|Babek|Habibi|202837485|qwert@gmail.com|Bush st|Aldie|VA|20105|

 
Scenario Outline:
 When I insert password "<password>" and confirm passwprd "<confirm>"
 And I click sumbmit
 Then "<url>" page should be seen
 
 Examples:
  
 |password|confirm|url|
 |abcd|abcd|http://newtours.demoaut.com/create_account_success.php|
 |abcder|abc|http://newtours.demoaut.com/mercuryregister.php|
 | |fjhjhfy|http://newtours.demoaut.com/mercuryregister.php|
