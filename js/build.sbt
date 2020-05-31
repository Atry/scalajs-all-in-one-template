enablePlugins(ScalaJSBundlerPlugin)

enablePlugins(Example)

enablePlugins(ScalaJSWeb)

enablePlugins(BuildInfoPlugin)

enablePlugins(ScalablyTypedConverterPlugin)

// ScalaJSWeb only works with ScalaJSBundlerPlugin when bundling mode is library-only.
// See https://github.com/scalacenter/scalajs-bundler/pull/288#issuecomment-476494335 for discussion of this problem
webpackBundlingMode := BundlingMode.LibraryOnly()

libraryDependencies += "org.lrng.binding" %%% "html" % "1.0.3"

libraryDependencies += "com.thoughtworks.binding" %%% "jspromisebinding" % "12.0.0"

libraryDependencies += "com.thoughtworks.binding" %%% "futurebinding" % "12.0.0"

libraryDependencies += "com.thoughtworks.binding" %%% "route" % "12.0.0"

libraryDependencies += "com.thoughtworks.binding" %%% "bindable" % "2.0.0-M1"

npmDependencies in Compile += "pad" -> "2.3 <="

requireJsDomEnv in Test := true

scalaJSUseMainModuleInitializer := true

libraryDependencies += "org.scalatest" %%% "scalatest" % "3.1.2" % Test

scalacOptions += "-Ymacro-annotations"
