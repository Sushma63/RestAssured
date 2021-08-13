Feature: This feature is used to create the shortening URL details for the Target URL


  Scenario Outline: Test condition to create tinyURL for the particular target URL

    Given I want to execute service of method "put" and in environment "tinyurl"
    When the relative url is "tinyurl/"
    And the given test data is in  "7" and "5"
    And the query parameter is passed "null"
    Then execute the URL
    And I validate status code "200" and validate response parameter "http://google.com"

  Scenario Outline: Test condition to create tinyURL for the particular target URL by passing Invalid duration.

    Given I want to execute service of method "put" and in environment "tinyurl"
    When the relative url is "tinyurl/"
    And the given test data is in  "7" and "7"
    And the query parameter is passed "null"
    Then execute the URL
    And I validate status code "200"
















