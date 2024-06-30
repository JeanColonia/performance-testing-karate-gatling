# performance-testing-karate-gatling
Karate and Gatling performance testing


## To run the Gatling test:
# code 
      mvn clean test-compile gatling:test

## And in case you have multiple Gatling simulation files and you want to choose only one to run:

# code 
      mvn clean test-compile gatling:test -Dgatling.simulationClass=mock.CatsKarateSimulation

