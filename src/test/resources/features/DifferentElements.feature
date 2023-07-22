Feature: Different Elements Page

  Scenario: User Different Elements Page test

    Given I open JDI GitHub site
    And I login as user "Roman Iovlev"
    When I click on "Service" button in Header
    And I click on Different elements button in Service dropdown
    Then "Different Elements" page should be opened

    When I select checkbox Water on Different Elements Page
    And I select checkbox Wind on Different Elements Page
    And I select radio Selen on Different Elements Page
    And I select Yellow in dropdown on Different Elements Page
    Then "Water: condition changed to true" should be displayed in Log rows
    And "Wind: condition changed to true" should be displayed in Log rows
    And "metal: value changed to Selen" should be displayed in Log rows
    And "Colors: value changed to Yellow" should be displayed in Log rows