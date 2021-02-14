name := "IMDB Challenge"
organization := "com.example.imdb"
version := "1.0.0"
javacOptions ++= Seq("-target", "1.8", "-Xlint")
scalaVersion := "2.13.0"
scalacOptions ++= Seq(
  "-deprecation",  // warn on deprecation
  "-feature",      // warn on feature
  "-unchecked",    // warn on unchecked
  "-language:_",   // enable advanced features
)
Test / fork := true
Test / envVars += "TEST" → "1"
libraryDependencies ++= Seq(
  "org.scala-lang.modules" %% "scala-xml" % "2.0.0-M1",
  "org.scalatest" %% "scalatest" % "3.2.0" % Test,
  "net.sourceforge.htmlcleaner" % "htmlcleaner" % "2.6.1",
  "org.jsoup" % "jsoup" % "1.8.3",
)
test in assembly := {}
assemblyMergeStrategy in assembly := {
  case PathList("META-INF", xs @ _*) ⇒
    xs map {_.toLowerCase} match {
    case "manifest.mf" :: Nil  |
         "index.list" :: Nil   |
         "dependencies" :: Nil ⇒ MergeStrategy.discard
    case _ ⇒ MergeStrategy.last
    }
  case _ ⇒ MergeStrategy.first
}
mainClass in assembly := Some("com.example.imdb.Main")
assemblyJarName in assembly := "imdb-challenge.jar"
