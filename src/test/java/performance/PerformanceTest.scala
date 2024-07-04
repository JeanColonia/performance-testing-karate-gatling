package performance

import com.intuit.karate.gatling.PreDef._
import io.gatling.core.Predef._
import scala.concurrent.duration._

class PerformanceTest extends Simulation {

  val protocol = karateProtocol(
    // "/v2/pet/{petId}" -> Nil
  )

  protocol.nameResolver = (req, ctx) => req.getHeader("karate-name")
  protocol.nameResolver = (req, ctx) => req.getHeader("karate-name-resolver")

  val petCSV = csv("pets.csv").circular
  val create = scenario("get pets by pending status").feed(petCSV).exec(karateFeature("classpath:performance/getPets.feature"))

  setUp(
    create.inject(
      atOnceUsers(3), //3
      nothingFor(4 seconds),
      constantUsersPerSec(1).during(1 seconds), //10
      // constantUsersPerSec(2).during(10 seconds), //20 
      // rampUsersPerSec(2).to(10).during(10 seconds), //2-10
      // nothingFor(4 seconds)

      ).protocols(protocol)
  )

}