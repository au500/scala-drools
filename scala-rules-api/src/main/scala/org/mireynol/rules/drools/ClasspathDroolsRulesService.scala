package org.mireynol.rules.drools

import org.mireynol.rules.api.RulesService

class ClasspathDroolsRulesService extends RulesService {

  val drools = new DroolsSupport( )

  override def execute( session : String, process : Option[ String ], facts : List[ Any ], responseType : Class[ _ ] ) : List[ Any ] = {
    drools.execute( session, process, facts, responseType )
  }

}