enablePlugins(ScalaJSBundlerPlugin)

enablePlugins(Example)

enablePlugins(ScalaJSWeb)

enablePlugins(BuildInfoPlugin)

// ScalaJSWeb only works with ScalaJSBundlerPlugin when bundling mode is library-only.
// See https://github.com/scalacenter/scalajs-bundler/pull/288#issuecomment-476494335 for discussion of this problem
webpackBundlingMode := BundlingMode.LibraryOnly()

libraryDependencies += "com.thoughtworks.binding" %%% "nextanimationframe" % "0.1.0"

libraryDependencies += "com.thoughtworks.binding" %%% "jspromisebinding" % "11.8.1"

libraryDependencies += "com.thoughtworks.binding" %%% "futurebinding" % "11.8.1"

libraryDependencies += "com.thoughtworks.binding" %%% "dom" % "11.8.1"

libraryDependencies += "com.thoughtworks.binding" %%% "route" % "11.8.1"

libraryDependencies += "com.thoughtworks.binding" %%% "latestevent" % "0.3.0"

libraryDependencies += "com.thoughtworks.binding" %%% "bindable" % "1.1.0"

addCompilerPlugin("org.scalamacros" % "paradise" % "2.1.1" cross CrossVersion.full)

resolvers += Resolver.bintrayRepo("oyvindberg", "ScalablyTyped")

libraryDependencies += ScalablyTyped.P.pad

npmDependencies in Compile += "pad" -> "2.3.0"

requireJsDomEnv in Test := true

scalaJSUseMainModuleInitializer := true

libraryDependencies += "org.scalatest" %%% "scalatest" % "3.0.8" % Test

scalacOptions += "-P:scalajs:sjsDefinedByDefault"
