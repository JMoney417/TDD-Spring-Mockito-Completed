Feature: Songs API

  Scenario: MYCOMPANY MUSIC app should allow admins to add songs
    Given I have a <song>
    When I post that <song> to the app
    Then the <song> should be stored in the database