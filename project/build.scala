import sbt._

object TweetArchiverBuild extends Build {
  lazy val root = Project("TweetArchiver", file(".")) dependsOn(dispatchTwitter)
  lazy val dispatchTwitter = uri("git://github.com/n8han/dispatch-twitter#0.1.4")
}