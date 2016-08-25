package org.mireynol.credit.model

import spray.json.{DefaultJsonProtocol, RootJsonFormat}

import scala.beans.BeanInfo

@BeanInfo
case class Application( customerName : String, creditScore : Int )

object ApplicationJSONFormat extends DefaultJsonProtocol {
  implicit val applicationFormat  = jsonFormat2( Application )
}

@BeanInfo
case class Approval( message : String, approved : Boolean )

object ApprovalJSONFormat extends DefaultJsonProtocol {
  implicit val approvalFormat = jsonFormat2( Approval )
}