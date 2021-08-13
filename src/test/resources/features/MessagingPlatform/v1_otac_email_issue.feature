
Feature: This feature is used to send the OTAC for the given customer by providing the email ID

  Scenario Outline: To verify the functionality of the api to send OTAC is successful when valid email is passed in the request.

    Given I want to execute service of method "post" and in environment "messaging"
    When the relative url is "messaging/v1/otac/email/issue"
    And the given test data is in  "1" and "5"
    And the query parameter is passed "null"
    Then execute the URL
    And I validate status code "200" and validate response parameter "idtest@mailinator.com"


  Scenario Outline: Test condition to verify functionality of api by passing invalid otac template .

    Given I want to execute service of method "post" and in environment "messaging"
    When the relative url is "messaging/v1/otac/email/issue"
    And the given test data is in  "1" and "7"
    And the query parameter is passed "null"
    Then execute the URL
    And I validate status code "400" and validate response parameter "Invalid template format. Requires {OTAC} token in template."












