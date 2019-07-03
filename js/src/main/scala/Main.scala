import com.thoughtworks.binding._
import org.scalajs.dom._

object Main {

  @dom
  def rootView: Binding[html.Span] = <span class="hello">Hello, World!</span>

  def main(args: Array[String]): Unit = {
    dom.render(document.body, rootView)
  }

}