import sbt._
import Dependencies._

organization := "org.mireynol"
name := "scala-drools"
version := "0.0.1-SNAPSHOT"
scalaVersion := "2.11.8"

resolvers in ThisBuild ++= Seq( "Sonatype releases" at "https://oss.sonatype.org/content/repositories/releases",
                                "Spray IO Repository" at "http://repo.spray.io/" )

lazy val root = ( project in file( "." ) ).aggregate( scalaRulesAPI, testModel )

lazy val scalaRulesAPI = ( project in file( "scala-rules-api" ) )
  .settings( Seq( libraryDependencies ++=
                  drools ++
                  kie
                )

           )

lazy val testModel = ( project in file( "test-model" ) )

lazy val testRules = ( project in file( "test-rules" ) )
  .dependsOn( testModel )

/**
  * lazy val museoRules = ( project in file( "museo-rules" ) )
  * .dependsOn( museoModel )
  * *
  * lazy val museoModel = ( project in file( "museo-model" ) )
  * .settings( Seq( libraryDependencies ++=
  * sprayJson ++
  * logback
  * )
  * *
  * )
  * *
  * lazy val museoDecisionService = ( project in file( "museo-decision-service" ) )
  * .dependsOn( museoModel, museoRules )
  * .settings( Seq( libraryDependencies ++=
  * drools ++
  * kie ++
  * specs2 )
  * )
  */