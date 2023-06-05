#Feature: Should fail.
#
#  Scenario: Fails on purpose
#    When the client calls endpoint "/launch/counter/4"
#    Then response status code is 300
#    And returned string should be "T-3"
