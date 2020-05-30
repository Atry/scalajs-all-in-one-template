addSbtPlugin("com.thoughtworks.sbt-best-practice" % "sbt-best-practice" % "7.2.0")

addSbtPlugin("com.dwijnand" % "sbt-dynver" % "4.0.0")

addSbtPlugin("org.lyranthe.sbt" % "partial-unification" % "1.1.2")

addSbtPlugin("com.thoughtworks.example" % "sbt-example" % "7.0.1")

addSbtPlugin("com.vmunier" % "sbt-web-scalajs" % "1.0.11")

addSbtPlugin("org.scala-js" % "sbt-scalajs" % "1.1.0")

addSbtPlugin("org.irundaia.sbt" % "sbt-sassify" % "1.5.1")

resolvers += Resolver.bintrayRepo("oyvindberg", "converter")

// for Scala.js 1.x.x
addSbtPlugin("org.scalablytyped.converter" % "sbt-converter" % "1.0.0-beta13")

addSbtPlugin("ch.epfl.scala" % "sbt-web-scalajs-bundler" % "0.18.0")

addSbtPlugin("io.spray" % "sbt-revolver" % "0.9.1")

addSbtPlugin("com.thoughtworks.sbt-scala-js-map" % "sbt-scala-js-map" % "4.0.0")

addSbtPlugin("com.eed3si9n" % "sbt-buildinfo" % "0.9.0")
