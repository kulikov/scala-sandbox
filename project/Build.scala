import sbt._
import Keys._

object SandboxBuild extends Build {

  lazy val root        = Project(id = "sandbox", base = file(".")) dependsOn(utilAmqp)
  lazy val utilAmqp    = Project(id = "util-amqp", base = file("./util/util-amqp"))
}
