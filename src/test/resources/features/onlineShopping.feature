@Assignment
Feature: Online Shopping

  @Scenario1
  Scenario: Verify that user cannot log in with valid but not registered email
    Given user goes to the home page
    And user clicks the category button
    When user selects the furniture category option
    Then user saves the first product name and price of the list page
    When user click the first product of the list page
    Then verify product details are same on the product list and detail page
    And user clicks the add to basket button
    And user click the checkout now button
    When user adds item to the cart of quantity "2"
    Then verify product details are same on the product detail and cart page
    And user clicks the remove item button
    Then user clicks the start shopping button