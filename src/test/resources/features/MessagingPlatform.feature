
Feature: This feature is to send the Otac for the givien  customer by providing the email ID using /messaging/v1/otac/email/issue


  Scenario Outline: Messaging Platform to send OTAC success 1

    Given I want to execute service of method "post" and in environment "messaging"
    When the relative url is "messaging/v1/otac/email/issue"
    And the given test data is in  "1" and "5"
    And the query parameter is passed "null"
    Then execute the URL
    And I validate status code "200" and validate msisdn "idtest@mailinator.com"












