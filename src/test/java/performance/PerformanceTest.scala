package performance

import com.intuit.karate.gatling.PreDef._
import io.gatling.core.Predef._
import scala.concurrent.duration._

class PerformanceTest extends Simulation {

  val protocol = karateProtocol()

  //protocol.nameResolver = (req, ctx) => req.getHeader("karate-name")
 

  val create = scenario("get pets by pending status").exec(karateFeature("classpath:performance/getPets.feature"))

  setUp(
    create.inject(atOnceUsers(1)).protocols(protocol)
  )

}