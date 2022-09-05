Feature: Functional requirements - Technical Test

  @Formedix @Formedix_01 @Formedix_01.1
  Scenario: 01 - Successful login
    Given the page with url 'https://ryze-staging.formedix.com/sign-in' is opened
    When we type 'testteamtechtest' in the 'username' input field
    And we type 'T3st3rT3ch' in the 'password' input field
    And we click 'Sign in' button
    Then make sure user user is successfully logged in

  @Formedix @Formedix_01 @Formedix_01.2
  Scenario: 02- Studies layout test
    When we hover over 'repository' item
    And we click 'Studies' item from repository nav-menu
    Then check the following options are shown under Tech Study
      | Updated | Status | Version |
    Then enter 'Tech Study' view
    And click 'Data acquisition' from 'Asset groups' view
    Then click 'Forms' from 'Assets' view


  @Formedix @Formedix_01 @Formedix_01.3
  Scenario: 03- Go into forms
    When select 'Medical History' form
    And click 'Edit form' button from Form view
    And type 'test' in the study screen 'description' input field
    Then click 'Validate & Update' button from Form view
    And make sure 'description' value is 'test'

  @Formedix @Formedix_01 @Formedix_01.4
  Scenario: 04- User sing out
    When we hover over 'user icon' item
    And we click 'Sign out' item from user menu
    Then check sign out reason is as following
    |You have signed out.|