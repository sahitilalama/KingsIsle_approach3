Feature: Gift Certificate Features

  Scenario: Open wizard101 game website
    Given I open wizard101 game website
    When I click on gift cards
    Then I am navigated to gift cards
    And I click on gift certificate
    Then I select option from prepaid memberships
    And I select option from crowns
    And I select option from bundles
    And I click on continue button
    Then I am navigated to personalize gift page
    And I enter text in To
    And I enter text in From
    And I enter text in Message
    Then I click on checkout with creditcard
    And I assert current charges on Payment Information page
    Then I quit driver and browser
