Feature: Login functionality

Background:
  Given user opens the login page
  
@Valid
Scenario: Valid login
  When user enters the username "nkumarc2209@gmail.com"
  And user enters the password "Naveen@1998"
  And user clicks login   
  Then user should see the home page
  
@Invalid
Scenario: Invalid login
  When user enters the username "nkumarc2209@gmail.com"
  And user enters the password "Naveen@1998"
  And user clicks login   
  Then user should see the error message