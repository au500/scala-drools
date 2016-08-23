import sbt._
import Dependencies._

organization := "org.mireynol"
name := "scala-drools"
version := "0.0.1-SNAPSHOT"
scalaVersion := "2.11.8"

resolvers in ThisBuild ++= Seq( "Sonatype releases" at "https://oss.sonatype.org/content/repositories/releases",
                                "Spray IO Repository" at "http://repo.spray.io/" )

lazy val root = ( project in file( "." ) ).aggregate( scalaRulesAPI )

lazy val scalaRulesAPI = ( project in file( "scala-rules-api" ) )
  .settings( Seq( libraryDependencies ++=
                  drools ++
                  kie ++
                  junit ++
                  junitInterface ++
                  slf4j ++
                  logback
                )

           )
