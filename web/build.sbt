enablePlugins(SbtWeb)

enablePlugins(SbtSassify)

enablePlugins(WebScalaJSBundlerPlugin)

enablePlugins(BuildInfoPlugin)

pipelineStages in Assets += scalaJSPipeline

libraryDependencies += "org.webjars" % "font-awesome" % "5.15.4"

libraryDependencies += "org.webjars" % "bootstrap" % "5.1.3"
