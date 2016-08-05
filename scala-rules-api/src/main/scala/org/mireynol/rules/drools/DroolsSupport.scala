package org.mireynol.rules.drools

import org.drools.core.ClassObjectFilter
import org.kie.api.KieServices
import org.kie.api.runtime.{KieContainer, KieSession}
import org.mireynol.rules.api.{KnowledgeSessionService, RulesService, Type}

import scala.collection.mutable.ListBuffer

class DroolsSupport( val engineType : Type.Value, val group : Option[ String ], val artifact : Option[ String ],
                     val version : Option[ String ] ) extends KnowledgeSessionService with RulesService {

  var kContainer : KieContainer = null

  // classpath intialization
  if ( engineType == Type.STATIC ) {
    kContainer = KieServices.Factory.get( ).newKieClasspathContainer( )
  }
  else if ( engineType == Type.DYNAMIC ) {
    if ( group.isDefined && artifact.isDefined && version.isDefined ) {
      //TODO kie scanner intialization
    }
    else {
      // exception
    }

  }

  def this( ) = {
    this( Type.STATIC, None, None, None )
  }

  def this( group : String, artifact : String, version : String ) = {
    this( Type.DYNAMIC, Some( group ), Some( artifact ), Some( version ) )
  }

  override def getKnowledgeSession( session : String ) : KieSession = {
    kContainer.newKieSession( session )
  }

  override def execute( session : String, process : Option[ String ], facts : List[ Any ],
                        responseType : Class[ _ ] ) : List[ Any ] = {
    val kSession = getKnowledgeSession( session )
    val results = ListBuffer[ Any ]( )

    for ( fact <- facts ) kSession.insert( fact )
    kSession.fireAllRules( )

    // drools creates a new iterator for every one so store it in a val
    val i = kSession.getObjects( new ClassObjectFilter( responseType ) ).iterator( )
    while ( i.hasNext ) results += i.next

    results.toList
  }
}