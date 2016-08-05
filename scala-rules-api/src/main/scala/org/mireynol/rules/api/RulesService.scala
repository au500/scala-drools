package org.mireynol.rules.api

object Type extends Enumeration {
  val STATIC = Value( "STATIC" )
  val DYNAMIC = Value( "DYNAMIC" )
}

trait RulesService {

  def execute( session : String, process : Option[ String ], facts : List[ Any ], responseType : Class[ _ ] ) : List[ Any ];

}
