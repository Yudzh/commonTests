# language: en
Feature: Make a bill

  Scenario: Make a bill
    Given Prepare user
    Given Prepare another user

    Given Open bank register page
    When Register user

    Given Go to Bill Pay page
    When Make a bill payment