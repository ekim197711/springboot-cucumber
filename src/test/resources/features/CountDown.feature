Feature: Countdown to launch should work

  Scenario: Call backend with last countdown number
    When the client calls endpoint "/launch/counter/4"
    Then response status code is 200
    And returned string should be "T-3"

  Scenario: Call backend with ONE
    When the client calls endpoint "/launch/counter/1"
    Then response status code is 200
    And returned string should be "Launch! Go go go!"

  Scenario: Call backend with rubbish non existing endpoint
    When the client calls endpoint "/launch/yesyes/mycounter/1"
    Then response status code is not present