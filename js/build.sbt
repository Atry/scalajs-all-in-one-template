enablePlugins(ScalaJSBundlerPlugin)

enablePlugins(Example)

enablePlugins(ScalaJSWeb)

enablePlugins(BuildInfoPlugin)

enablePlugins(ScalablyTypedConverterPlugin)

// ScalaJSWeb only works with ScalaJSBundlerPlugin when bundling mode is library-only.
// See https://github.com/scalacenter/scalajs-bundler/pull/288#issuecomment-476494335 for discussion of this problem
webpackBundlingMode := BundlingMode.LibraryOnly()

libraryDependencies += "com.yang-bo" %%% "html" % "3.0.1"

Compile / npmDependencies += "pad" -> "2.3 <="

Compile / npmDependencies += "bootstrap" -> "5.1.3"

Compile / npmDependencies += "@types/bootstrap" -> "5.1.6"

requireJsDomEnv in Test := true

scalaJSUseMainModuleInitializer := true

libraryDependencies += "org.scalatest" %%% "scalatest" % "3.2.10" % Test

ThisBuild / libraryDependencySchemes += "org.scala-js" %% "scalajs-dom_sjs1" % VersionScheme.Always

stEnableScalaJsDefined := Selection.All
