enablePlugins(SbtWeb)

enablePlugins(SbtSassify)

enablePlugins(WebScalaJSBundlerPlugin)

enablePlugins(BuildInfoPlugin)

pipelineStages in Assets += scalaJSPipeline

libraryDependencies += "org.webjars" % "font-awesome" % "5.11.2"
