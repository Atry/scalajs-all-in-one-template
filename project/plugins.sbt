addSbtPlugin("com.vmunier" % "sbt-web-scalajs" % "1.2.0")

addSbtPlugin("org.scala-js" % "sbt-scalajs" % "1.17.0")

libraryDependencies += "org.scala-js" %% "scalajs-env-nodejs" % "1.4.0"

addSbtPlugin("io.github.irundaia" % "sbt-sassify" % "1.5.2")

addSbtPlugin("org.scalablytyped.converter" % "sbt-converter" % "1.0.0-beta42")

addSbtPlugin("ch.epfl.scala" % "sbt-web-scalajs-bundler" % "0.21.1")

addSbtPlugin("io.spray" % "sbt-revolver" % "0.10.0")

addSbtPlugin("com.thoughtworks.sbt-scala-js-map" % "sbt-scala-js-map" % "4.1.1")

addSbtPlugin("com.eed3si9n" % "sbt-buildinfo" % "0.13.1")

ThisBuild / libraryDependencySchemes += "org.scala-lang.modules" %% "scala-java8-compat" % VersionScheme.Always
