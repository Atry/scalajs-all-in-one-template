# The All-in-One Scala.js static web project template
[![Build Status](https://travis-ci.org/Atry/Binding.scala-template.svg?branch=master)](https://travis-ci.org/Atry/Binding.scala-template)

This repository is a template of the basic structure for a Scala.js web project, contains all the best technologies in Scala.js community since 2019:

* [Sbt](https://scala-sbt.org) is the build tool.
* [Scala.js](https://www.scala-js.org/) to compile [Scala](https://scala-lang.org) to JavaScript.
* [Binding.scala](https://github.com/ThoughtWorksInc/Binding.scala) for reactive HTML templating.
* [sbt-sassify](https://github.com/irundaia/sbt-sassify/) for compiling [Sass](https://sass-lang.com/) to CSS.
* [Font Awesome](https://fontawesome.com/) as an example of Sass dependency.
* [sbt-scala-js-map](https://github.com/ThoughtWorksInc/sbt-scala-js-map) for source mapping.
* [scalajs-bundler](https://github.com/scalacenter/scalajs-bundler) for [webpack](https://webpack.js.org/) and [NPM](https://www.npmjs.com/) (or [YARN](https://yarnpkg.com)).
* [ScalablyTyped](https://github.com/oyvindberg/ScalablyTyped) for type definition of NPM dependencies.
* [left-pad](https://github.com/left-pad/left-pad/) as an example of NPM dependency.
* [sbt-web](https://github.com/sbt/sbt-web) for [WebJars](https://www.webjars.org/).
* [sbt-buildinfo](https://github.com/sbt/sbt-web) to expose sbt settings to runtime.
* [Coursier](https://get-coursier.io/) for fast downloading Maven and ivy dependencies.
* [sbt-example](https://github.com/ThoughtWorksInc/sbt-example) to generate [ScalaTest](http://www.scalatest.org/) from from examples in Scaladoc comments.
* [sbt-dynver](https://github.com/dwijnand/sbt-dynver) to determine the build version from git tags.

Other libraries and tools can be found in [sbt settings](https://github.com/Atry/Binding.scala-template/search?q=extension%3Asbt&unscoped_q=extension%3Asbt).

This template contains settings for a static web project, and you can additionally configure Play or Akka HTTP dependencies in `web/build.sbt` to turn it into an dynamic web project.

## Directory Structure

 * web/
   
   The sbt-web project for web assets
   * build.sbt
     
     Sbt settings for the sbt-web project, which contains WebJars dependency configurations, including SASS / SCSS dependencies and static resources from external libraries.
   * src/main/assets/
         
     The root directory of static assets sources.
     * index.html
       
       The main page for release mode, which reference uglified version of CSS and JS resources.
     * devMod.html
       
       The main page for development mode, which reference indented CSS and JS resources.
     * style.scss
       
       The style sheet used by main page in SCSS syntax, which will be compiled to `style.css` by sbt-web pipeline.
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
   * coursier.sbt

     sbt-coursier settings.
   * project/
     * plugins.sbt

       sbt-coursier settings.

## Requirements

* [Java 8+](https://openjdk.java.net/)
* [sbt](https://www.scala-sbt.org/)
* [Node.js](https://nodejs.org/) or [nodenv](https://github.com/nodenv/nodenv)

## How to use this template?

Just clone this repository, and the following sbt tasks are available.

### Build

Run the following command:

``` shell
sbt assets
```

Then visit `web/target/web/public/main/index.html` to browse the main page.

#### Development build

By default, the `assets` command builds Scala.js in release mode. To build this project in development mode

``` shell
sbt "set web / scalaJSPipeline / isDevMode := true" assets
```

Then visit `web/target/web/public/main/devMod.html` to browse the main page in development mode.

### Test

Run the following command:

``` shell
sbt test
```

Then the examples in Scaladoc comments will be ran by ScalaTest.
