import sbt.Keys._
import sbt._

object Dependencies {

  val droolsVersion = "6.4.0.Final"
  val slf4jVersion = "1.7.21"
  val logbackVersion = "1.1.7"
  val junitVersion = "4.12"
  val junitInterfaceVersion = "0.8"

  val slf4j = Seq( "org.slf4j" % "slf4j-api" % "1.7.5" )

  val drools = Seq( "org.drools" % "drools-core" % droolsVersion,
                    "org.drools" % "drools-compiler" % droolsVersion )

  val kie = Seq( "org.kie" % "kie-api" % droolsVersion,
                 "org.kie" % "kie-internal" % droolsVersion )

  val logback = Seq( "ch.qos.logback" % "logback-classic" % logbackVersion )

  val junit = Seq( "junit" % "junit" % junitVersion % "test" )

  val junitInterface = Seq( "com.novocode" % "junit-interface" % junitInterfaceVersion % "test" )

  val droolsTest = Seq( "org.drools" % "drools-core" % droolsVersion,
                        "org.drools" % "drools-compiler" % droolsVersion )

  val kieTest = Seq( "org.kie" % "kie-api" % droolsVersion % "test",
                     "org.kie" % "kie-internal" % droolsVersion % "test" )

}