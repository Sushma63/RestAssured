
Feature: This feature is to fetch the identity details of a customer by providing the email ID using identity/v1/identity/EMAIL/{email)/details


  Scenario Outline: fetch the identity details of a customer by providing the  a valid email ID
    Given I want to execute service of method "get" and in environment "ref_url"
    When the relative url is "identity/v1/identity/EMAIL/{email}/details"
    And the given test data is in  "1" and "4"
    And the query parameter is passed "active=false"
    Then execute the URL
    And I validate status code "200" and validate response parameter "+447800901004"


  Scenario Outline: fetch the identity details of a customer by providing the a invalid email ID for 404
    Given I want to execute service of method "get" and in environment "ref_url"
    When  the relative url is "identity/v1/identity/EMAIL/{email}/details"
    And the given test data is in  "2" and "4"
    And the query parameter is passed "active=false"
    Then execute the URL
    And I validate status code "404"

  Scenario Outline: Negative
    Given I want to execute service of method "get" and in environment "ref_url"
    When  the relative url is "identity/v1/identity/EMAIL/{email}/details"
    And the given test data is in  "2" and "4"
    And the query parameter is passed "active=false"
    Then execute the URL
    And I validate status code "405"










