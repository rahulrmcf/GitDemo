@tag
Feature: Error Validation

  @ErrorValidation
  Scenario Outline: Title of you scenario outline
    Given I landed on Ecommerce page
    When Logged in with username <name> and password <password>
    Then "Incorrect email or password." message is displayed

    Examples:
      | name              | password 
      | rahulpr@gmail.com | R@hul@123
