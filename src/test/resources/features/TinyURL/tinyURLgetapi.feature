Feature: This feature is used to fetch the tinyURL details for the Target URL

  Scenario Outline: Test condition to retrieve details of tinyURL by passing Url_id
Given I want to execute service of method "put" and in environment "tinyurl"
When the relative url is "tinyurl/"
And the given test data is in  "7" and "5"
And the query parameter is passed "null"
Then execute the URL
And The required request parameters are "url_id"
And the relative url is "tinyurl/{url_id}" and method is "get"
And execute the URL
And I validate status code "200" and validate response parameter "http://google.com"


Scenario Outline: Test condition to retrieve the details of tinyURL by passing not existed UrlID.

Given I want to execute service of method "put" and in environment "tinyurl"
When the relative url is "tinyurl/"
And the given test data is in  "7" and "5"
And the query parameter is passed "null"
Then execute the URL
And The required request parameters are "url_id"
And the relative url is "tinyurl/{url_id}" and method is "delete"
And execute the URL
And I validate status code "204"
And the relative url is "tinyurl/{url_id}" and method is "get"
And execute the URL
And I validate status code "404"
