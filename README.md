# All-in-One Scala.js Static Web Project Template
[![Open in Gitpod](https://img.shields.io/badge/Gitpod-open%20in%20an%20online%20IDE-%230092CF.svg )](https://gitpod.io/#https://github.com/Atry/scalajs-all-in-one-template)
[![Scala CI](https://github.com/Atry/scalajs-all-in-one-template/actions/workflows/scala.yml/badge.svg)](https://github.com/Atry/scalajs-all-in-one-template/actions/workflows/scala.yml)

This repository is a template of the basic structure for a Scala.js web project, contains all the best technologies in Scala.js community until 2021:

* [Sbt](https://scala-sbt.org) is the build tool.
* [Scala.js](https://www.scala-js.org/) to compile [Scala](https://scala-lang.org) to JavaScript.
* [html.scala](https://github.com/GlasslabGames/html.scala/) for reactive HTML templating.
* [Binding.scala](https://github.com/ThoughtWorksInc/Binding.scala) for data-binding.
* [sbt-sassify](https://github.com/irundaia/sbt-sassify/) for compiling [Sass](https://sass-lang.com/) to CSS.
* [Font Awesome](https://fontawesome.com/) as an example of Sass dependency.
* [Bootstrap](https://getbootstrap.com/) for responsive UI components.
* [sbt-scala-js-map](https://github.com/ThoughtWorksInc/sbt-scala-js-map) for source mapping.
* [scalajs-bundler](https://github.com/scalacenter/scalajs-bundler) for [webpack](https://webpack.js.org/) and [NPM](https://www.npmjs.com/) (or [YARN](https://yarnpkg.com)).
* [ScalablyTyped](https://scalablytyped.org/) for type definition of NPM dependencies.
* [pad](https://pad-project.js.org/) as an example of NPM dependency.
* [sbt-web](https://github.com/sbt/sbt-web) for [WebJars](https://www.webjars.org/).
* [sbt-buildinfo](https://github.com/sbt/sbt-buildinfo) to expose sbt settings to runtime.
* [Coursier](https://get-coursier.io/) for fast downloading Maven and ivy dependencies.
* [sbt-example](https://github.com/ThoughtWorksInc/sbt-example) to generate [ScalaTest](http://www.scalatest.org/) from from examples in Scaladoc comments.
* [sbt-dynver](https://github.com/dwijnand/sbt-dynver) to determine the build version from git tags.

Other libraries and tools can be found in [sbt settings](https://github.com/Atry/Binding.scala-template/search?q=extension%3Asbt&unscoped_q=extension%3Asbt).

This template contains settings for a static web project, and you can additionally configure Play or Akka HTTP dependencies in `web/build.sbt` to turn it into a dynamic web project.

## Directory Structure

 * web/
   
   The sbt-web project for web assets
   * build.sbt
     
     Sbt settings for the sbt-web project, which contains WebJars dependency configurations, including SASS / SCSS dependencies and static resources from external libraries.
   * src/main/assets/
         
     The root directory of static assets sources.
     * index.html
       
       The main page in release mode, which references uglified CSS and JS resources.
     * devMod.html
       
       The main page in development mode, which references indented CSS and JS resources.
     * style.scss
       
       The style sheet used by main page in SCSS syntax, which will be compiled to `style.css` by a sbt-web pipeline.
   * target/web/public/main/
     
     The root directory of static assets output.
     * lib/
       
       The output directory for Webjars dependencies.
 * js/
   
   The Scala.js project to create JS output used in the sbt-web project.

   * build.sbt
     
     Sbt settings for the Scala.js project, which contains Scala.js settings, NPM dependencies and type definitions.
   
   * src/main/scala/
     
     The directory contains Scala.js source files.
 * project/
   * plugins.sbt
     
     Sbt plugins dependencies.

## Requirements

* [Java](https://openjdk.java.net/) 8+
* [Sbt](https://www.scala-sbt.org/) launcher
* [Node.js](https://nodejs.org/) or [nodenv](https://github.com/nodenv/nodenv)

## How to use this template?

Just clone this repository, and the following sbt tasks are available.

### Build

Run the following command:

``` shell
sbt assets
```

Then visit `web/target/web/public/main/devMod.html` to browse the main page.

#### Release mode build

By default, the `assets` command builds Scala.js in development mode. To build this project in release mode

``` shell
sbt "set scalaJSStage := FullOptStage" assets
```

Then visit `web/target/web/public/main/index.html` to browse the main page in release mode.

### Test

Run the following command:

``` shell
sbt test
```

Then the examples in Scaladoc comments will be ran by ScalaTest.
