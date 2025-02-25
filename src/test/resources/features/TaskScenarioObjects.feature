Feature: End to End simulation test

# Scenario: As a user i can add new data
#     Given A list of objects are available
#     When I add a new object to etalase
#     Then The object is available


@taskTest
Scenario Outline: As a user I can add new data
    Given A list of item are available get list of all objects
    When I add item to list "<payload>" Add object
    Then The item is available Single object

    Examples:
    |payload    |
    |addItem1   |
    |addItem2   |
