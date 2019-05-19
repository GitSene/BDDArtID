Feature: Login test of newtours webpage
  This is test the newtours login page functionality with different credentionality  

Background:
    Given I am in newtours home page "http://newtours.demoaut.com/"

  @tag1
  Scenario: Login success with user name  a and password a
    When I insert user name= "a" and  password= "a"
    And I press login button
    Then "SIGN-OFF" link should be seen on the top of menue
    

  @tag2
  Scenario Outline: Login test with different credentials
    When I insert user name= "<userName>" and  password= "<password>"
    And I press login button
    Then "<link>" link should be seen on the top of menue
    

    Examples: 
      | userName | password | link    |
      | a        | 5        | SIGN-OFF|
      | b        | b        | SIGN-OFF|
      | abc      | def      | SIGN-ON |
      | lmk      | 7        | SIGN-ON |
      

