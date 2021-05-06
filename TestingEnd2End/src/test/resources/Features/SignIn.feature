

Feature: Signin Functionality Feature
  

  Scenario: Signin with Valid Credentials
    Given User is on SignIn Page
    When user enters username and password
    And clicks on Submit button
    Then user is navigated to Home Page   

  Scenario: Signin with Invalid Credentials 
    Given User is on SignIn Page
    When user enters wrong username and password
    And clicks on Submit button
    Then Error message should be displayed
    
    #Scenario outlines are used when the same test has to be performed with different data set.
   Scenario Outline: Signin with Invalid Credentials Multiple Values
   Given User is on SignIn Page
   When User enters Username as "<Username>" and Password as "<Password>"
   And clicks on Submit button 
   Then Error message should be displayed

	Examples: 
	| Username | Password |
	#this will fail as the username and password is correct
	| SachdevaHimanshu21@rediff.com | #21Rediff |
	| SachdevaHimanshu21@rediff.com | #wrong |
	| ded | wed          |
