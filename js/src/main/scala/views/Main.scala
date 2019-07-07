package views
import com.thoughtworks.binding._, Binding._
import org.scalajs.dom._
import typings.leftDashPadLib.{leftDashPadMod => leftPad}
import buildinfo.BuildInfo

object Main {

  /** The root view of the main page.
    *
    * @example Given a root view,
    *          {{{
    *          import org.scalajs.dom._
    *          import com.thoughtworks.binding._
    *          //val container = document.createElement("div")
    *          dom.render(document.body, views.Main.rootView)
    *          }}}
    *          
    *          then it should not contain the build information in the beginning.
    * 
    *          {{{
    *          document.getElementById("buildInfo") should be(null)
    *          }}}
    * 
    *          When the "Build info" check box is clicked,
    * 
    *          {{{
    *          val buildCheckBox = document.getElementById("buildCheckBox").asInstanceOf[html.Input]
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
  @dom
  def rootView: Binding[Node] = {
    val showBuildInfo = Var(false)
    <form>
      <input id="buildCheckBox" type="checkbox" onchange={ _: Event =>
        showBuildInfo.value = buildCheckBox.checked
      }/>
      <label for="buildCheckBox">Build <span class="info" data:aria-label="i"></span>nfo</label>
      {
        if (showBuildInfo.bind) {
          <pre id="buildInfo">
            {leftPad("Name", 15)} {BuildInfo.name}
            {leftPad("Version", 15)} {BuildInfo.version}
            {leftPad("Scala Version", 15)} {BuildInfo.scalaVersion}
            {leftPad("Sbt Version", 15)} {BuildInfo.sbtVersion}
          </pre>
        } else {
          <!-- Build info is hidden -->
        }
      }
    </form>
  }

  def main(args: Array[String]): Unit = {
    // typings.padLib.padLibRequire
    dom.render(document.body, rootView)
  }

}
