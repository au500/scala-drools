package org.mireynol.credit.service

import akka.actor.{ActorSystem, Props}
import akka.io.IO
import spray.can.Http
import akka.pattern.ask
import akka.util.Timeout
import org.slf4j.LoggerFactory

import scala.concurrent.duration._
import scala.util.Properties

object Main extends App {

  val logger = LoggerFactory.getLogger( classOf[ App ] )

  logger.info( "Starting Credit Approval Example REST service" )

  implicit val timeout = Timeout( 5.seconds )
  implicit val system = ActorSystem( "credit-approval-services" )
  val service = system.actorOf( Props[ CreditServiceActor ], "credit-approval-service" )

  val port = Properties.envOrElse( "$OPENSHIFT_PORT", "8080" ).toInt
  logger.info( "HTTP Port is: " + port )

  IO( Http ) ? Http.Bind( service, interface = "0.0.0.0", port = port )

}
