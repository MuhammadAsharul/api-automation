Feature: End to End simulation test

Scenario: As a user i can add new data
    Given A list of item are available get list of all objects
    When I add a new object to etalase
    Then The item is available Single object


@taskTest
Scenario Outline: As a user I can add new data
    Given A list of item are available get list of all objects
    When I add item to list "<payload>" Add object
    Then The item is available Single object

    Examples:
    |payload    |
    |addItem1   |
    |addItem2   |

Scenario Outline: As a user I can update data
    Given A list of products are available
    When I add new "<payload>" to etalase
    And The product is available
    Then I can update item "<update>"

    Examples:
    |payload    | update        | 
    |addItem1   | updateItem1   |
    |addItem2   | updateItem2   |