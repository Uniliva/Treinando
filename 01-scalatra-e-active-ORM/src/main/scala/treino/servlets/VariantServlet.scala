package treino.servlets

import org.scalatra.{CorsSupport, ScalatraServlet}
import org.json4s._
import treino.models._
import org.scalatra.json.JacksonJsonSupport
import com.github.aselab.activerecord.dsl._
import org.json4s.JsonAST.JValue

class VariantServlet extends ScalatraServlet with JacksonJsonSupport with CorsSupport {
  protected implicit lazy val jasonFormats: Formats = DefaultFormats
  protected override def transformRequestBody(body: JValue): JValue = body.underscoreKeys

  protected implicit lazy val jsonFormats: Formats = DefaultFormats

  protected override def transformResponseBody(body: JValue): JValue = body.underscoreKeys

  before() {
    contentType = formats("json")
  }

  get("/:id"){
    val id = params("id").toLong
    val variante = Variante.find(id).get
    Map(
      "msg"->"Sucess",
      "data"-> (
        variante.toMap + ("Produtos"->variante.produto.toMap)
        )
    )
  }

}
