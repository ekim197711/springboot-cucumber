Feature: Lets use DT

  Scenario: Send DT as data
    Given We have gaffa taped the following spaceships together
      | shipName    | fuel | maxSpeed |
      | Eagle 2     | 99   | 4323.26  |
      | Owl         | 28   | 553.1    |
      | The sparrow | 65   | 6323.2   |
      | R2D2        | 34   | 2313.3   |
    When send ships to rest controller
    Then all ships should now have an id
      | shipName    |
      | R2D2        |
      | Owl         |
      | The sparrow |
      | Eagle 2     |
