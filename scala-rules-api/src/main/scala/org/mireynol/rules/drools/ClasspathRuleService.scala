package org.mireynol.rules.drools

import org.mireynol.rules.api.{DecisionService, RulesService}


object ClasspathRuleService extends RulesService {

  val decisionService : DecisionService = new DecisionService( )

  override def execute( session : String, process : Option[ String ], facts : List[ Any ], responseType : Class[ _ ] ) : List[ Any ] = {
    decisionService.execute( session, process, facts, responseType )
  }

}
