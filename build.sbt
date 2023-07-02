lazy val js = project

lazy val web = project.settings(
  scalaJSProjects += js,
)

ThisBuild / scalaVersion := "3.2.2"
