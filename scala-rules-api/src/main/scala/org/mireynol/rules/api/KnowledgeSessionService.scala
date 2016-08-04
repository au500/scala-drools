package org.mireynol.rules.api

import org.kie.api.runtime.KieSession

trait KnowledgeSessionService {

  def getKnowledgeSession( session : String ) : KieSession

}
