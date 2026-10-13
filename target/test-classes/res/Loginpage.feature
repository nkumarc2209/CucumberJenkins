Feature: Instagram Login feature

Scenario Outline: Login with multiple user 

Given user should login with instagram login page
When user should enter the "<username>" and "<password>"
And user should click the login button
Then user should verify the error message

Examples:

 | username  | password  |
 | admin     | admin123  |
 | naveen    | naveen123 |
 | nithish   | nithish123|