package org.mireynol.rules.drools

import org.junit.Test
import org.junit.Assert._
import org.mireynol.rules.model.{ModelObject, OtherModelObject}


class ClasspathDroolsRulesServiceTest {

  val ruleService = new ClasspathDroolsRulesService( )
  val kSession = "test-ksession"

  @Test
  def should_fire_one_basic_rule = {
    val obj = ModelObject( Some( "1" ) )

    val results : List[ OtherModelObject ] = ruleService.execute( kSession, None, List( obj ), classOf[ OtherModelObject ] ).asInstanceOf[ List[ OtherModelObject ] ]

    assertTrue( results.size == 1 )
    assertEquals( results( 0 ).getClass( ), classOf[ OtherModelObject ] )
    assertEquals( 1, results( 0 ).value )
  }

  @Test
  def should_apply_filter_of_results_for_greater_than_three = {
    val obj1 = ModelObject( Some( "1" ) )
    val obj2 = ModelObject( Some( "2" ) )
    val obj3 = ModelObject( Some( "3" ) )
    val obj4 = ModelObject( Some( "4" ) )
    val obj5 = ModelObject( Some( "5" ) )

    val facts = List( obj1, obj2, obj3, obj4, obj4, obj5 )

    val results = ruleService.execute( kSession, None, facts, classOf[ OtherModelObject ] ).asInstanceOf[ List[ OtherModelObject ] ].filter( _.value > 3 )

    assertTrue( results.filter( _.value <= 3 ).length == 0 )
  }

}