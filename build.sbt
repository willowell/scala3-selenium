val projectName = "Scala 3 Selenium Sample Project"
val projectDescription = "Sample project showcasing a minimal ScalaTest and Selenium setup"
val projectVersion = "0.1.0"
val projectScalaVersion = "3.1.2"

val scalaTestVersion = "3.2.12"

val dependencies = Seq(
  "io.github.bonigarcia" %  "webdrivermanager"         % "5.2.0"          % Test,
  "org.scalatestplus"    %% "selenium-4-1"             % "3.2.12.0"       % Test,
  "org.scalatest"        %% "scalatest-flatspec"       % scalaTestVersion % Test,
  "org.scalatest"        %% "scalatest-funspec"        % scalaTestVersion % Test,
  "org.scalatest"        %% "scalatest-shouldmatchers" % scalaTestVersion % Test
)

lazy val root = project
  .in(file("."))
  .settings(
    name := projectName,
    version := projectVersion,
    scalaVersion := projectScalaVersion,

    libraryDependencies ++= dependencies
  )
