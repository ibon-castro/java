Feature: HomeController

  Scenario: Accessing the home endpoint
    Given the application is running
    When the client calls GET /
    Then the client receives status code 200
    And the client receives the message "Hello Mosse!"
