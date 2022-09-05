Feature: Functional requirements - Technical Test

  @Formedix @Formedix_01 @Formedix_01.1
  Scenario: Successful login
    Given the page with url 'https://ryze-staging.formedix.com/sign-in' is opened
    When we type 'testteamtechtest' in the 'username' input field
    And we type 'T3st3rT3ch' in the 'password' input field
    And we click 'Sign in' button
    Then make sure user user is successfully logged in