enablePlugins(ScalaJSBundlerPlugin)

enablePlugins(Example)

enablePlugins(ScalaJSWeb)

enablePlugins(BuildInfoPlugin)

// ScalaJSWeb only works with ScalaJSBundlerPlugin when bundling mode is library-only.
webpackBundlingMode := BundlingMode.LibraryOnly()

Compile / fastOptJS / relativeSourceMaps := false

libraryDependencies += "com.thoughtworks.binding" %%% "nextanimationframe" % "0.1.0"

libraryDependencies += "com.thoughtworks.binding" %%% "jspromisebinding" % "11.8.0"

libraryDependencies += "com.thoughtworks.binding" %%% "futurebinding" % "11.8.0"

libraryDependencies += "com.thoughtworks.binding" %%% "dom" % "11.8.0"

libraryDependencies += "com.thoughtworks.binding" %%% "route" % "11.8.0"

libraryDependencies += "com.thoughtworks.binding" %%% "latestevent" % "0.3.0"

libraryDependencies += "com.thoughtworks.binding" %%% "bindable" % "1.1.0"

addCompilerPlugin("org.scalamacros" % "paradise" % "2.1.1" cross CrossVersion.full)

resolvers += Resolver.bintrayRepo("oyvindberg", "ScalablyTyped")

libraryDependencies += ScalablyTyped.L.`left-pad`

npmDependencies in Compile += "left-pad" -> "1.3.0"

scalaJSUseMainModuleInitializer := true

libraryDependencies += "org.scalatest" %%% "scalatest" % "3.0.7" % Test

scalacOptions += "-P:scalajs:sjsDefinedByDefault"
