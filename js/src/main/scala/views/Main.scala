package views
import com.thoughtworks.binding._, Binding._
import org.lrng.binding.html, html._
import org.scalajs.dom._, raw._
import typings.pad.{mod => pad}
import buildinfo.BuildInfo

object Main {

  /** The root view of the main page.
    *
    * @example Given a root view,
    *          {{{
    *          import org.scalajs.dom._
    *          import com.thoughtworks.binding._
    *          import org.lrng.binding.html
    *          import org.scalajs.dom.raw.HTMLInputElement
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
  @html
  def rootView: Binding[Node] = {
    val showBuildInfo = Var(false)
    lazy val buildCheckBox: NodeBinding[HTMLInputElement] = {
      <input class="form-check-input" id="buildCheckBox" data:role="switch" type="checkbox" onchange={ _: Event =>
        showBuildInfo.value = buildCheckBox.value.checked
      }/>
    }
    <form>
      <div class="form-check form-switch">
        { buildCheckBox }
        <label class="form-check-label" for="buildCheckBox">Build <span class="info" data:aria-label="i"></span>nfo</label>
      </div>
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
    typings.bootstrap.bootstrapRequire
    html.render(document.body, rootView)
  }

}
