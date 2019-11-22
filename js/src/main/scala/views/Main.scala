package views
import com.thoughtworks.binding._, Binding._
import org.scalajs.dom._
import typings.pad.{padMod => pad}
import buildinfo.BuildInfo
import org.lrng.binding.html, html._
import org.scalajs.dom.raw._

object Main {

  /** The root view of the main page.
    *
    * @example Given a root view,
    *          {{{
    *          import org.scalajs.dom._
    *          import com.thoughtworks.binding._
    *          import org.scalajs.dom.raw.HTMLInputElement
    *          dom.render(document.body, views.Main.rootView)
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
  @html
  def rootView: Binding[Node] = {
    val showBuildInfo = Var(false)
    lazy val buildCheckBox: NodeBinding[HTMLInputElement] = {
      <input id="buildCheckBox" type="checkbox" onchange={ _: Event =>
        showBuildInfo.value = buildCheckBox.value.checked
      }/>
    }
    <form>
      { buildCheckBox }
      <label for="buildCheckBox">Build <span class="info" data:aria-label="i"></span>nfo</label>
      {
        if (showBuildInfo.bind) {
          <pre id="buildInfo">
            {pad(15, "Name")} {BuildInfo.name}
            {pad(15, "Version")} {BuildInfo.version}
            {pad(15, "Scala Version")} {BuildInfo.scalaVersion}
            {pad(15, "Sbt Version")} {BuildInfo.sbtVersion}
          </pre>
        } else {
          <!-- Build info is hidden -->
        }
      }
    </form>
  }

  def main(args: Array[String]): Unit = {
    dom.render(document.body, rootView)
  }

}
