package org.mireynol.rules.api

import org.kie.api.KieServices
import org.mireynol.rules.drools.DroolsRulesService

class ResourceType

object ResourceType extends Enumeration {
  val CLASSPATH = Value( "CLASSPATH" )
  val DYNAMIC = Value( "DYNAMIC" )
}

class DecisionService( val resourceType : ResourceType.Value,
                       val group : Option[ String ],
                       val artifactId : Option[ String ],
                       val version : Option[ String ] ) extends DroolsRulesService {

  if ( resourceType == ResourceType.CLASSPATH ) {
    println( "should instantiate kie container" )
    if ( kContainer == null ) {
      kContainer = KieServices.Factory.get( ).newKieClasspathContainer( )
    }
    else {
      kContainer
    }
  }

  else if ( resourceType == ResourceType.DYNAMIC ) {
    if ( group.isDefined && artifactId.isDefined && version.isDefined ) {
      println( "do kie scanner setup" )
    }
    else {
      // throw exception
    }
  }

  def this( ) = {
    this( ResourceType.CLASSPATH, None, None, None )
  }

  def this( group : String, artifactId : String, version : String ) = {
    this( ResourceType.DYNAMIC, Some( group ), Some( artifactId ), Some( version ) )
  }

}
