@Login
Feature: Check login fungtionality as user 
     
   #TC_1  
  Scenario: Login with valid Username and Password
    Given User is on login page TestAutomasi  
    When User enter valid userName "fullstackdemo"
    	And User enter valid password "fullstackdemo"
    	And User click button Login
    Then User redirected to dashboard
    
  #TC_2  
  Scenario: Login with invalid Username and valid Password
    Given User is on login page TestAutomasi
    When User enter invalid userName "notfullstackdemo"
    	And User enter valid password "fullstackdemo"
    	And User click button Login
    Then User accept error message register "The username is not registered on this site."
    
  #TC_3  
  Scenario: Login with valid Username and invalid Password
    Given User is on login page TestAutomasi 
    When User enter valid userName "fullstackdemo"
    	And User enter invalid password "notfullstackdemo"
    	And User click button Login
    Then User accept error message incorect password "The password you entered for the username fullstackdemo is incorrect."
    
  #TC_4  
  Scenario: Login with invalid Username and invalid Password
    Given User is on login page TestAutomasi 
    When User enter invalid userName "<username>"
    	And User enter invalid password "<password>"
    	And User click button Login
    Then User accept error message register "The username is not registered on this site."