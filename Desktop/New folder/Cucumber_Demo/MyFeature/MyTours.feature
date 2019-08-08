Feature: My Validations on Mercury Tours

  Scenario Outline: Login for Srinivas and Jyoti
    Given mercury application is launched
    Then User enters username "<uname>"
    And User enters password "<pswd>"
    When User clicks on submit button
    And Verifies the login success

    Examples: 
      | uname   | pswd    |
      | demo    | demo    |
      | mercury | mercury |

      