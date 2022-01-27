Feature: We can login  on site

  Scenario: We want login by phone number

    Given We on main page
    When We click on sign in button
    When We enter phone number in phone field
    When We click on login button
    Then We see successful message


  Scenario: We want login by email address

    Given We on main page
    When We click on sign in button
    When We click on sign in by email
    When We enter email in email field
    When We enter password in password field
    When  We click on login button
    Then  We can see user name