organization := "com.libitec"

name := "sandbox"

version := "0.0.1"

scalaVersion := "2.9.2"

libraryDependencies ++= Seq(
  "com.rabbitmq" % "amqp-client" % "2.8.7",
  "com.typesafe" % "config" % "1.0.0",
  "com.libitec" %% "util.amqp" % "0.0.4-SNAPSHOT"
)
