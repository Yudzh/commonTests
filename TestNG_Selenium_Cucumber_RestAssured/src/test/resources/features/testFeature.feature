#language: en
  Feature: Standard user
    Scenario: Buy any item
      Given Open login page
      When Login as "standard_user" user
      Then Check inventory size

      When Buy any item
      When Go to cart page
      Then Check cart inventory size is 1

      When Get user