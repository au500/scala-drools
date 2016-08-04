package org.mireynol.rules.drools

import org.drools.core.ClassObjectFilter
import org.kie.api.runtime.{KieContainer, KieSession}
import org.mireynol.rules.api._

import scala.collection.mutable.{ListBuffer, Map}

class DroolsRulesService extends KnowledgeSessionService {

  var kContainer : KieContainer = null

  def execute( session : String, process : Option[ String ], facts : List[ Any ], responseType : Class[ _ ] ) : List[ Any ] = {

    val kSession = getKnowledgeSession( session )
    val results = ListBuffer[ Any ]( )

    for ( fact <- facts ) kSession.insert( fact )
    kSession.fireAllRules( )

    // drools creates a new iterator for every one so store it in a val
    val i = kSession.getObjects( new ClassObjectFilter( responseType ) ).iterator( )
    while ( i.hasNext ) results += i.next

    results.toList

  }

  override def getKnowledgeSession( session : String ) : KieSession = {
    kContainer.newKieSession( session )
  }

}