## performance-testing-karate-gatling
Karate and Gatling performance testing


#### To run the Gatling test:
# 
      mvn clean test-compile gatling:test

#### And in case you have multiple Gatling simulation files and you want to choose only one to run:

# 
      mvn clean test-compile gatling:test -Dgatling.simulationClass=mock.CatsKarateSimulation

### Gatling Injections
      User insertions distributed evenly on a time window of a given duration
# 
      nothingFor(4), // 1
       atOnceUsers(10), // 2
      rampUsers(10).during(5), // 3
      constantUsersPerSec(20).during(15), // 4
      constantUsersPerSec(20).during(15).randomized(), // 5
      rampUsersPerSec(10).to(20).during(10), // 6
      rampUsersPerSec(10).to(20).during(10).randomized(), // 7
      stressPeakUsers(1000).during(20) // 8

### Gatling Feeder (CSV File)

#      
      val petCSV = csv("pet.csv")
#### using circular method to load whole file to end
#     
      val petCSV = csv("pet.csv").circular

#### setting data directory to gatling
#
          <configuration>
          <simulationsFolder>src/test/java/performance</simulationsFolder>
          <configFolder>src/test/java/performance/data</configFolder>
          </configuration>    



