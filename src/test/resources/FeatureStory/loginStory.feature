Feature: User can login on site and register on site

  Scenario: User want login by phone number
    Given User on main page
    When User click on sign in button
    When User enter phone number in phone field
    When User click on login button
    Then User see successful message

  Scenario: User want login by email address
    Given User on main page
    When User click on sign in button
    When User click on sign in by email
    When User enter email in email field
    When User enter password in password field
    When User click on login button
    Then User can see user name

  Scenario: User want register account
    Given User on main page
    When User click on sign in button
    When User click on register button
    When User send name in name field
    When User send phone number in number field
    When User send email in email field
    When User send password in password field
    When User send register new user button
    Then User can see user name