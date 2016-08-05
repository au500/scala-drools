package org.mireynol.rules.drools

import org.junit.Test
import org.junit.Assert._
import org.mireynol.rules.model.{ModelObject, OtherModelObject}


class ClasspathDroolsRulesServiceTest {

  val ruleService = new ClasspathDroolsRulesService( )

  @Test
  def firstTest = {
    val obj = ModelObject( true )
    val kSession = "test-ksession"

    val results : List[ OtherModelObject ] = ruleService.execute( kSession, None, List( obj ), classOf[ OtherModelObject ] ).asInstanceOf[ List[ OtherModelObject ] ]

    assertTrue( results.size == 1 )
    assertEquals( results( 0 ).getClass( ), classOf[ OtherModelObject ] )
    assertEquals( "success", results( 0 ).value )
  }

}
