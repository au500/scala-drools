package org.mireynol.rules.api

trait RulesService {

  def execute( session : String, process : Option[ String ], facts : List[ Any ], responseType : Class[ _ ] ) : List[ Any ];

}
