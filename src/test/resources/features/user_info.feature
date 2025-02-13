Feature: User Information Management
  @testAserciones
  Scenario: Add personal, contact, and passport details
    Given the user is on the login page
    When the user logs in with valid credentials
    And the user enters their personal details
    And the user enters their contact details
    And the user enters their passport details
    Then the user information should be saved and visible correctly