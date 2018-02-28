import javax.servlet.ServletContext

import org.scalatra.LifeCycle
import treino.servlets.{ProductServlet, VariantServlet}
import treino.models.Tables


class ScalatraBootstrap extends LifeCycle {

  System.setProperty("run.mode", "banco")

  override def init(context: ServletContext): Unit = {
    Tables.initialize
    context.mount(new ProductServlet, "/produtos/*")
    context.mount(new VariantServlet, "/variant/*")
  }

  override def destroy(context: ServletContext): Unit = {
    Tables.cleanup
  }
}