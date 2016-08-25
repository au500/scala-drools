import sbt._
import Dependencies._

organization := "org.mireynol"
name := "scala-drools"
version := "0.0.1-SNAPSHOT"
scalaVersion := "2.11.8"

resolvers in ThisBuild ++= Seq( "Sonatype releases" at "https://oss.sonatype.org/content/repositories/releases",
                                "Spray IO Repository" at "http://repo.spray.io/" )

lazy val root = ( project in file( "." ) ).aggregate( scalaRulesAPI, creditApprovalModel, creditApprovalRules )

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

lazy val creditApprovalModel = ( project in file( "credit-approval-model" ) ).settings( Seq( libraryDependencies ++= sprayJson ) )

lazy val creditApprovalRules = ( project in file( "credit-approval-rules" ) )
  .dependsOn( creditApprovalModel )
  .settings( Seq( libraryDependencies ++=
                  droolsTest ++
                  kieTest ++
                  junit ++
                  junitInterface ++
                  slf4j ++
                  logback
                )

           )

lazy val creditApprovalService = ( project in file( "credit-approval-service" ) )
  .dependsOn( creditApprovalModel, creditApprovalRules, scalaRulesAPI )
  .settings( Seq( libraryDependencies ++=
                  logback ++
                  akka ++
                  slf4j ++
                  spray ++
                  sprayJson
                )
           )