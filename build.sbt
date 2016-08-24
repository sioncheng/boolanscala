name := "boolanscala"

version := "0.0.1"

isSnapshot := true

//organization := "com.github.notyy"

// set the Scala version used for the project
scalaVersion := "2.11.8"

libraryDependencies ++= Seq(
  "org.scalacheck" %% "scalacheck" % "1.13.2" % "test",
  "org.pegdown" % "pegdown" % "1.0.2" % "test", //used in html report
  "org.scalatest" %% "scalatest" % "2.2.1" % "test",
  "org.slf4j" % "slf4j-api" % "1.7.7",
  "ch.qos.logback" % "logback-classic" % "1.1.2",
  "com.typesafe.scala-logging" %% "scala-logging-slf4j" % "2.1.2"
)

// append -deprecation to the options passed to the Scala compiler
scalacOptions += "-deprecation"

// create beautiful scala test report
testOptions in Test ++= Seq(
  Tests.Argument(TestFrameworks.ScalaTest,"-h","target/html-unit-test-report"),
  Tests.Argument(TestFrameworks.ScalaTest,"-u","target/unit-test-reports"),
  Tests.Argument(TestFrameworks.ScalaTest,"-o"),
  Tests.Argument(TestFrameworks.ScalaTest,"-l","FunctionTest")
)