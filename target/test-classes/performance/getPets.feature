Feature: Existing Pets

Background: setting variables
 * def baseUrl = "https://petstore.swagger.io/v2"


@getPets
Scenario: get pets by pending status
 Given url baseUrl
 And path "/pet/findByStatus"
 And params {status: "pending"}
 And headers {accept: "application/json"}
 When method GET
 Then status 200
 And print response