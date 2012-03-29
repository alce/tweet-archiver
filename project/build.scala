import sbt._

object TwitterArchiveBuild extends Build {
  lazy val root = Project("TwitterArchive", file(".")) dependsOn(dispatchTwitter)
  lazy val dispatchTwitter = uri("git://github.com/n8han/dispatch-twitter#0.1.4")
}