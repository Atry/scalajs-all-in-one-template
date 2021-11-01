lazy val js = project

lazy val web = project.settings(
  scalaJSProjects += js,
)

ThisBuild / scalaVersion := "2.13.7"
