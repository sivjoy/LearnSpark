/* 
 * Copyright (c) 2013 Snowplow Analytics Ltd. All rights reserved.
 *
 * This program is licensed to you under the Apache License Version 2.0,
 * and you may not use this file except in compliance with the Apache License Version 2.0.
 * You may obtain a copy of the Apache License Version 2.0 at http://www.apache.org/licenses/LICENSE-2.0.
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the Apache License Version 2.0 is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the Apache License Version 2.0 for the specific language governing permissions and limitations there under.
 */
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
