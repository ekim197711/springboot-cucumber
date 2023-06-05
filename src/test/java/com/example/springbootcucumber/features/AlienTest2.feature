Feature: Create Smurf aliens from features folder

  Scenario: Create 100 smurfs
    Given No aliens exists
    When Create 50 alien with name "Mike" and type "Smurf"
    Then Total number of aliens with type "Smurf" should be 50
    When Create 50 alien with name "Harriet" and type "Smurf"
    Then Total number of aliens with type "Smurf" should be 100

  Scenario: Create 100 Wookies
    Given No aliens exists
    When Create 50 alien with name "Brian" and type "Wookie"
    Then Total number of aliens with type "Wookie" should be 50
    When Create 50 alien with name "Anna" and type "Wookie"
    Then Total number of aliens with type "Wookie" should be 100

