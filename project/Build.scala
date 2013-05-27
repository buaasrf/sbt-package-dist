import sbt._
import Keys._

import java.io.File


object StandardProjectPlugin extends Build {
  lazy val root = Project(
    id = "sbt-package-dist",
    base = file(".")
  ).settings(
    organization := "com.twitter",
    name := "sbt-package-dist",
    version := "1.1.0-SNAPSHOT",
    sbtPlugin := true,
    publishTo := Some(Resolver.file("file", new File(Path.userHome.absolutePath + "/.ivy2/local"))),
    publishMavenStyle := true,
    pomExtra :=
      <licenses>
        <license>
          <name>Apache 2</name>
          <url>http://www.apache.org/licenses/LICENSE-2.0.txt</url>
          <distribution>repo</distribution>
        </license>
      </licenses>,
    libraryDependencies ++= Seq(
      "ivysvn" % "ivysvn" % "2.1.0",
      "org.markdownj" % "markdownj" % "0.3.0-1.0.2b4",
      "org.freemarker" % "freemarker" % "2.3.16"
    )
  )
}
