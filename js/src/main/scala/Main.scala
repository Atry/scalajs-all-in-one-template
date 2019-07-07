// package examples
import com.thoughtworks.binding._, Binding._
import org.scalajs.dom._
import typings.leftDashPadLib.leftDashPadMod
import buildinfo.BuildInfo

object Main {

  @dom
  def rootView: Binding[Node] = {
    val showBuildInfo = Var(false)
    <form>
      <input id="buildCheckBox" type="checkbox" onclick={ _: Event =>
        showBuildInfo.value = buildCheckBox.checked
      }/>
      <label for="buildCheckBox">Build <span class="info" data:aria-label="i"></span>nfo</label>
      {
        if (showBuildInfo.bind) {
          <pre>
            {leftDashPadMod("Name", 15)} {BuildInfo.name}
            {leftDashPadMod("Version", 15)} {BuildInfo.version}
            {leftDashPadMod("Scala Version", 15)} {BuildInfo.scalaVersion}
            {leftDashPadMod("Sbt Version", 15)} {BuildInfo.sbtVersion}
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
