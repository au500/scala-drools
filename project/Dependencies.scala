import sbt.Keys._
import sbt._

object Dependencies {

  val droolsVersion = "6.4.0.Final"
  val slf4jVersion = "1.7.21"
  val logbackVersion = "1.1.7"
  val junitVersion = "4.12"
  val junitInterfaceVersion = "0.8"
  val sprayVersion = "1.3.3"
  val sprayJsonVersion = "1.3.2"
  val akkaVersion = "2.3.9"

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

  val spray = Seq( "io.spray" %% "spray-can" % sprayVersion,
                   "io.spray" %% "spray-util" % sprayVersion,
                   "io.spray" %% "spray-routing" % sprayVersion,
                   "io.spray" %% "spray-testkit" % sprayVersion % "test" )

  val sprayJson = Seq( "io.spray" %% "spray-json" % sprayJsonVersion )

  val akka = Seq( "com.typesafe.akka" %% "akka-actor" % akkaVersion,
                  "com.typesafe.akka" %% "akka-testkit" % akkaVersion % "test" )

}