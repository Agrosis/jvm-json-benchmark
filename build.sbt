import sbt.Keys._

lazy val root = (project in file("."))
  .settings(
    name := "jvm-json-benchmark",
    organization := "com.jantox",
    version := "0.1.0",

    scalaVersion := "2.11.8",
    scalacOptions += "-deprecation",

    scalacOptions in Test ++= Seq("-Yrangepos"),

    resolvers += "Plasma Conduit Repository" at "http://dl.bintray.com/plasmaconduit/releases",

    libraryDependencies ++= Seq(
      "com.plasmaconduit"          %% "json"            % "0.25.0",
      "io.argonaut"                %% "argonaut"        % "6.1",
      "com.fasterxml.jackson.core" %  "jackson-core"    % "2.8.1",
      "com.fasterxml.jackson.core" %  "jackson-databind" % "2.8.1",
      "io.spray"                   %% "spray-json"      % "1.3.2",
      "com.typesafe.play"          %  "play-json_2.11"  % "2.5.4",
      "com.google.code.gson"       %  "gson"            % "2.7"

    )
  )
  .enablePlugins(JmhPlugin)
