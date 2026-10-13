Feature: Enter personal details 

Scenario: Enter personal details in the web page 
Given User is on the personal details page
When User enters the following personal details
  | India                 |
  | Mr.                   |
  | Naveen                |
  | Kumar                 |
  | 1998-09-22            |
  | 28/07/2026            |
  | nkumarc2209@gmail.com |
  | +91                   |
  | 6369143347            |
  | Email                 |
  
  Then User should verify the entered details