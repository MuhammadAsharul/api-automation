# Feature: End to End simulation test

# Scenario: As a user i can add new data
#     Given A list of products are available
#     When I add a new product to etalase
#     Then The product is available

# Scenario Outline: As a user i can add new data with some data
#     Given A list of products are available
#     When I add a new "<payload>" to etalase
#     Then The product is available
#     Examples:
#         | payload  | 
#         | addItem1 | 
#         | addItem2 |