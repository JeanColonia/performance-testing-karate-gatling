Feature: Existing Pets

Background: setting variables
 * def baseUrl = "https://petstore.swagger.io/v2"
 * def sleep = function(ms){ java.lang.Thread.sleep(ms); }
 * def pause = karate.get('_gatling.pause', sleep)
 * def petId = __gatling.petId
 * def status_ = 'pending'
@getPets
Scenario: get pets by pending status
 Given url baseUrl
 And path "/pet/findByStatus"
 And params {status: "#(status_)"}
 And headers {accept: "application/json"}
 And header karate-name = 'Buscar por Status = ' + status_ 
 When method GET
 Then status 200
 * print response
 # * def petId = response[0].id
 * pause(5000)
 Given url baseUrl
 And path "/pet/",petId
 And headers {accept: "application/json"}
 And header karate-name-resolver = 'Buscar por PetId: ' + petId
 When method GET
 Then status 200
