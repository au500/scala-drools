import sbt.Keys._
import sbt._

object Dependencies {

  val droolsVersion = "6.4.0.Final"

  val specs2 = Seq( "org.specs2" %% "specs2-core" % "3.8.3" % "test" )

  val drools = Seq( "org.drools" % "drools-core" % droolsVersion,
                    "org.drools" % "drools-compiler" % droolsVersion )

  val kie = Seq( "org.kie" % "kie-api" % droolsVersion,
                 "org.kie" % "kie-internal" % droolsVersion )

  val junit = Seq( "junit" % "junit" % "4.12" )

}