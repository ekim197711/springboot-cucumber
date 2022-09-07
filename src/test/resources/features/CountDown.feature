Feature: Countdown to launch
  Scenario: Call backend with last countdown number
    When the client calls endpoint "/launch/counter/4"
    Then response status code is 200
    And returned string should be "T-3"