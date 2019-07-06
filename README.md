# The template of Binding.scala web project

This repository contains basic structure for a Scala web project with the following technologies built-in:

* [Scala](https://scala-lang.org)
* [Sbt](https://scala-sbt.org)
* [Scala.js](https://www.scala-js.org/)
* [Binding.scala](https://github.com/ThoughtWorksInc/Binding.scala)
* [ScalablyTyped](https://github.com/oyvindberg/ScalablyTyped)
* [Font Awesome](https://fontawesome.com/)
* [sbt-sassify](https://github.com/irundaia/sbt-sassify/) for [Sass](https://sass-lang.com/)
* [sbt-scala-js-map](https://github.com/ThoughtWorksInc/sbt-scala-js-map) for source mapping
* [scalajs-bundler](https://github.com/scalacenter/scalajs-bundler) for [NPM](https://www.npmjs.com/)
* [sbt-web](https://github.com/sbt/sbt-web) for [WebJars](https://www.webjars.org/)

Other dependencies can be found in [sbt settings](https://github.com/Atry/Binding.scala-template/search?q=extension%3Asbt&unscoped_q=extension%3Asbt).

## Build

Run the following command:

```
sbt assets
```

Then visit `web/target/web/public/main/index.html` to browse the main page.

### Development build

By default, the `assets` command builds Scala.js in release mode. To build this project in development mode

```
sbt 'set web / scalaJSPipeline / isDevMode := true' assets
```

Then visit `web/target/web/public/main/devMod.html` to browse the main page in development mode.
