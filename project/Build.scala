import sbt._
import Keys._
import play.Project

object ApplicationBuild extends Build {
  val appName = "foo"
  val appVersion = "1.0-SNAPSHOT"

  val appDependencies = Seq(
    "org.webjars" % "webjars-play" % "2.1-RC1",
    "org.webjars" % "bootstrap" % "2.3.2",
    "org.webjars" % "angularjs" % "1.2.0-rc.2",
    "org.webjars" % "angular-ui-bootstrap" % "0.6.0-1",
    "org.webjars" % "jquery" % "1.7.2",
    "co.freeside" % "betamax" % "1.1.2" % "test",
    "org.codehaus.groovy" % "groovy-all" % "1.8.8" % "test",
    "org.ccil.cowan.tagsoup" % "tagsoup" % "1.2.1",
    "org.jsoup" % "jsoup" % "1.7.2")

  val main = Project(appName, appVersion, appDependencies).settings()
}