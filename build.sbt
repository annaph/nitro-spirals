name := "nitro-spirals"

organization := "org.nitro.spirals"

version := "1.0"

scalaVersion := "2.13.3"

scalacOptions ++= Seq(
  "-encoding", "utf8",
  "-deprecation",
  "-feature",
  "-unchecked")

libraryDependencies ++= Seq(
  "org.scalatest" %% "scalatest" % "3.2.2" % Test)

fork := true
