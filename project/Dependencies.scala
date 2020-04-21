import sbt._

object Dependencies {

  //lazy val ammoniteDeps = Seq(
  //  "com.github.pathikrit" %% "better-files" % "3.8.0",
  //  "com.typesafe.play" %% "play-json" % "2.7.3",
  //  "com.typesafe" % "config" % "1.3.4"
  //)

  lazy val aoyi = Seq(
    "com.lihaoyi" %% "pprint" % "0.5.9",
    "com.lihaoyi" % "ammonite" % "2.0.4" % "test" cross CrossVersion.full,
    "sh.almond" %% "ammonite-spark" % "0.9.0"
  )

  lazy val betterFiles = "com.github.pathikrit" %% "better-files" % "3.8.0"

  lazy val codeDeps = Seq(
    "com.beachape" %% "enumeratum" % "1.5.15",
    "com.github.scopt" %% "scopt" % "3.7.1"
  )

  lazy val configDeps = Seq(
    "org.yaml" % "snakeyaml" % "1.26",
    "com.github.pureconfig" %% "pureconfig" % "0.12.3",
    "com.github.pureconfig" %% "pureconfig-enumeratum" % "0.12.3"
  )

  lazy val loggingDeps = Seq(
    "ch.qos.logback"             % "logback-classic" % "1.2.3",
    "com.typesafe.scala-logging" %% "scala-logging"  % "3.9.2"
  )
  

  lazy val playJson = "com.typesafe.play" %% "play-json" % "2.8.1"


  lazy val scalaCheck = "org.scalacheck" %% "scalacheck" % "1.14.3"

  lazy val scalaLogging =
    "com.typesafe.scala-logging" %% "scala-logging" % "3.9.2"

  lazy val scalaLoggingDep = "ch.qos.logback" % "logback-classic" % "1.2.3"

  lazy val sparkDeps = Seq(
    "com.github.fommil.netlib" % "all" % "1.1.2" pomOnly (),
    "org.apache.spark" %% "spark-core" % "2.4.5",
    "org.apache.spark" %% "spark-sql" % "2.4.5",
    "org.apache.spark" %% "spark-graphx" % "2.4.5",
    "org.apache.spark" %% "spark-mllib" % "2.4.5"
  )

  lazy val testingDeps = Seq(
    "org.scalactic" %% "scalactic" % "3.1.1",
    "org.scalatest" %% "scalatest" % "3.1.1" % "test"
  )

  lazy val typeSafeConfig = "com.typesafe" % "config" % "1.4.0"

}