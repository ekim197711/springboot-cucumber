Feature: Type safe test

  Scenario: Create some aliens
    When These aliens are created with datatable
      | id | fullName | weight | runSpeed | height | extraField     |
      | -1 | Mike     | 70     | 5        | 190    | something 1234 |
      | -2 | Ole      | 90     | 3        | 180    | another thing  |
    Then We want them printed out
