addSbtPlugin("com.thoughtworks.sbt-best-practice" % "sbt-best-practice" % "8.2.2")

addSbtPlugin("com.dwijnand" % "sbt-dynver" % "4.1.1")

addSbtPlugin("org.lyranthe.sbt" % "partial-unification" % "1.1.2")

addSbtPlugin("com.thoughtworks.example" % "sbt-example" % "9.2.0")

addSbtPlugin("com.vmunier" % "sbt-web-scalajs" % "1.0.11")

addSbtPlugin("org.scala-js" % "sbt-scalajs" % "1.11.0")

libraryDependencies += "org.scala-js" %% "scalajs-env-nodejs" % "1.4.0"

addSbtPlugin("io.github.irundaia" % "sbt-sassify" % "1.5.2")

addSbtPlugin("org.scalablytyped.converter" % "sbt-converter" % "1.0.0-beta36")

addSbtPlugin("ch.epfl.scala" % "sbt-web-scalajs-bundler" % "0.21.1")

addSbtPlugin("io.spray" % "sbt-revolver" % "0.9.1")

addSbtPlugin("com.thoughtworks.sbt-scala-js-map" % "sbt-scala-js-map" % "4.1.1")

addSbtPlugin("com.eed3si9n" % "sbt-buildinfo" % "0.11.0")

ThisBuild / libraryDependencySchemes += "org.scala-lang.modules" %% "scala-java8-compat" % VersionScheme.Always
