@login
Feature: Heroku Login
  As a Heroku user I want to be able to:
  - Login to the site
  @loginSuccess
  Scenario Outline: Successful login
    Given I am on Heroku login page
    When I login with "<username>" and "<password>"
    Then I should be able to successfully login
    Examples:
      | username | password             |
      | tomsmith | SuperSecretPassword! |

  @loginFailure
  Scenario Outline: Failure login
    Given I am on Heroku login page
    When I login with "<username>" and "<password>"
    Then I should not be able to login
    Examples:
      | username | password      |
      | tomsmith | WrongPassword |
