Feature: Flipkart And Amazon module


  @Test
  Scenario Outline: Add to cart in FlipKart
    Given user is on flipkart homepage
    When Search for "<Searched_Item>" any item
    And Click on the First Item in the list
    And Print Price of the Item
    Then Add to cart in guest mode
    And Increase Quantity by 1
    And Print the Price after addition of Quantity
    Examples:
      | Searched_Item                 |
      | APPLE iPhone 12 (Blue, 64 GB) |


  @Test
  Scenario Outline: Compare price of an item in Flipkart from Amazon
    Given user is on flipkart homepage
    When Search for "<Searched_Item>" any item
    And Click on the First Item in the list
    Then Add to cart in guest mode in Flipkart
    And Get price of item after adding to cart
    Given user is on amazon homepage
    When Search for "<Searched_Item>" any item in Amazon
    And Click on the same item as on Flipkart in the list
    And Print Price of the Item from Amazon
    Then Add to cart in guest mode in Amazon
    And Print the Price after addition of item in cart
    And Compare price of same product in both site
    Examples:
      | Searched_Item                 |
      | APPLE iPhone 12 (Blue, 64 GB) |


