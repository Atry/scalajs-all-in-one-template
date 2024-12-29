package views
import com.thoughtworks.binding.*, Binding.*
import com.yang_bo.html.*
import org.scalajs.dom.*
import typings.pad.{mod => pad}
import buildinfo.BuildInfo

object Main:

  /** The root view of the main page.
    *
    * @example Given a root view,
    *          {{{
    *          import org.scalajs.dom._
    *          import com.thoughtworks.binding._
    *          import com.yang_bo.html
    *          import org.scalajs.dom.HTMLInputElement
    *          html.render(document.body, views.Main.rootView)
    *          }}}
    *          
    *          then it should not contain the build information in the beginning.
    * 
    *          {{{
    *          document.getElementById("buildInfo") should be(null)
    *          }}}
    * 
    *          When the "Build info" box is checked,
    * 
    *          {{{
    *          val buildCheckBox = document.getElementById("buildCheckBox").asInstanceOf[HTMLInputElement]
    *          buildCheckBox.checked = true
    *          buildCheckBox.onchange(null)
    *          }}}
    * 
    *          then the build information should be present.
    * 
    *          {{{
    *          document.getElementById("buildInfo").innerHTML should not be empty
    *          }}}
    */
  def rootView: Binding[Node] =
    val showBuildInfo = Var(false)
    lazy val buildCheckBox: Binding.Stable[HTMLInputElement] = 
      html"""<input class="form-check-input" id="buildCheckBox" role="switch" type="checkbox" onchange=${ (_: Event) =>
        showBuildInfo.value = buildCheckBox.value.checked
      }/>"""
    html"""<form>
      <div class="form-check form-switch">
        ${ buildCheckBox }
        <label class="form-check-label" for="buildCheckBox">Build <span class="info" aria-label="i"></span>nfo</label>
      </div>
      ${
        if (showBuildInfo.bind) {
          html"""<pre id="buildInfo">
            ${pad(15, "Name")} ${BuildInfo.name}
            ${pad(15, "Version")} ${BuildInfo.version}
            ${pad(15, "Scala Version")} ${BuildInfo.scalaVersion}
            ${pad(15, "Sbt Version")} ${BuildInfo.sbtVersion}
          </pre>""".bind
        } else {
          html"""<!-- Build info is hidden -->"""
        }
      }
    </form>"""
  end rootView

  def main(args: Array[String]): Unit =
    typings.bootstrap.bootstrapRequire
    render(document.body, rootView)
  end main

end Main