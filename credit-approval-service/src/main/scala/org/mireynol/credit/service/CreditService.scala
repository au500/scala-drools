package org.mireynol.credit.service

import akka.actor.Actor
import org.mireynol.credit.model.Approval
import org.mireynol.rules.api.RulesService
import org.mireynol.rules.drools.ClasspathDroolsRulesService
import spray.httpx.SprayJsonSupport
import spray.routing.HttpService


class CreditServiceActor extends Actor with CreditService {
  def actorRefFactory = context

  def receive = {
    runRoute( applicationRoute )
  }
}

trait CreditService extends HttpService with SprayJsonSupport {

  import spray.http.MediaTypes._
  import org.mireynol.credit.model.Application
  import org.mireynol.credit.model.ApplicationJSONFormat.applicationFormat
  import org.mireynol.credit.model.Approval
  import org.mireynol.credit.model.ApprovalJSONFormat.approvalFormat

  val rulesService : RulesService = new ClasspathDroolsRulesService( )

  val applicationRoute = path( "applications" ) {
    post {
      respondWithMediaType( `application/json` )
      entity( as[ Application ] ) { application =>
        detach() {
          val results = rulesService.execute( "credit-approval-ksession", None, List( application ),classOf[ Approval ] ).asInstanceOf[ List[ Approval ] ]
          complete( results(0) )
        }

      }
    }
  }

}


