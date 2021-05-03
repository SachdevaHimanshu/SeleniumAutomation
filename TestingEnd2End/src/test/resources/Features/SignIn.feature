

Feature: Feature to test Signin Page Functionality
  


  Scenario: To check signin is successful with valid credentials
    Given User is on SignIn Page
    #And the credentials are Valid
    When user enters username and password
    And clicks on Submit button
    Then user is navigated to Home Page
    
 
  #Scenario: To check that Keep me signed in CheckBox is displayed on the signin page
    #Given User is on SignIn Page
    #Then Keep me signed in CheckBox should be displayed
    

  Scenario: To check signin is successful with valid credentials
    Given User is on SignIn Page
    #And the credentials are Valid
    When user enters wrong username and password
    And clicks on Submit button
    Then Error message should be displayed

