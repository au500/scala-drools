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
  .dependsOn( testModel % "test" )
  .settings( Seq( libraryDependencies ++=
                  drools ++
                  kie ++
                  junit ++
                  junitInterface ++
                  slf4j ++
                  logback
                )

           )

lazy val testModel = ( project in file( "test-model" ) )

lazy val testRules = ( project in file( "test-rules" ) )
  .dependsOn( testModel )
