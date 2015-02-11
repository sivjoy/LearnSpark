import sbt._
import Keys._

object SparkExampleProjectBuild extends Build {
	import Dependencies._
  // Define our project, with basic project information and library dependencies
  lazy val project = Project("LearnSpark", file("."))
    .settings(
      name := "Simple Project",
        version := "1.0",
        scalaVersion := "2.10.4",
        libraryDependencies ++= Seq(
          Libraries.sparkCore,
          Libraries.scalaTest
        // Add your additional libraries here (comma-separated)...
      )
    )
}
