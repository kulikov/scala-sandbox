organization := "com.libitec"

name := "sandbox"

version := "0.0.1"

scalaVersion := "2.9.1"

libraryDependencies ++= Seq(
  "com.rabbitmq" % "amqp-client" % "2.7.1",
  "com.typesafe" % "config" % "0.5.0",
  "com.libitec" %% "util.amqp" % "0.0.4-SNAPSHOT"
)
