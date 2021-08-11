Feature: This feature is to create tinyurl for Target URL


  Scenario Outline: Test condition to create tinyURL for the partiular target URL

    Given I want to execute service of method "put" and in environment "tinyurl"
    When the relative url is "tinyurl/"
    And the given test data is in  "3" and "5"
    And the query parameter is passed "null"
    Then execute the URL
    And I validate status code "200" and validate msisdn "http://google.com"

  Scenario Outline: Test condition to get the details tinyURL for the particular target URL

    Given I want to execute service of method "put" and in environment "tinyurl"
    When the relative url is "tinyurl/"
    And the given test data is in  "3" and "5"
    And the query parameter is passed "null"
    Then execute the URL
    And the relative url is "tinyurl/{url_id}" and method is "get"
    And execute the URL
    And I validate status code "200" and validate msisdn "http://google.com"

  Scenario Outline: Test condition to Update the details tinyURL for the particular target URL

    Given I want to execute service of method "put" and in environment "tinyurl"
    When the relative url is "tinyurl/"
    And the given test data is in  "3" and "5"
    And the query parameter is passed "null"
    Then execute the URL
    And the relative url is "tinyurl/{url_id}" and method is "post"
    And the given test data is in  "3" and "6"
    And execute the URL
    And I validate status code "204" and validate msisdn ""
    And the relative url is "tinyurl/{url_id}" and method is "get"
    And execute the URL
    And I validate status code "200" and validate msisdn "http://google.com"


  Scenario Outline: Test condition to delete the details tinyURL for the particular target URL

    Given I want to execute service of method "put" and in environment "tinyurl"
    When the relative url is "tinyurl/"
    And the given test data is in  "3" and "5"
    And the query parameter is passed "null"
    Then execute the URL
    And the relative url is "tinyurl/{url_id}" and method is "delete"
    And execute the URL
    And I validate status code "204"



  Scenario Outline: Test condition to delete tinyURL of  particular tinyURL id

    Given I want to execute service of method "put" and in environment "tinyurl"
    When the relative url is "tinyurl/"
    And the given test data is in  "3" and "5"
    And the query parameter is passed "null"
    Then execute the URL
    And the relative url is "tinyurl/{url_id}" and method is "delete"
    And execute the URL
    And I validate status code "204"
    And the relative url is "tinyurl/{url_id}" and method is "get"
    And execute the URL
    And I validate status code "404"










