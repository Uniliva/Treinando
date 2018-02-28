package treino.servlets

import com.typesafe.scalalogging.LazyLogging
import org.json4s
import org.json4s.JsonAST.JValue
import org.json4s.{DefaultFormats, Formats}
import org.scalatra.{CorsSupport, ScalatraServlet}
import org.scalatra.json.JacksonJsonSupport
import treino.models._
import com.github.aselab.activerecord.dsl._


class ProductServlet extends ScalatraServlet with JacksonJsonSupport with CorsSupport with LazyLogging {

  protected implicit lazy val jsonFormats: Formats = DefaultFormats

  protected override def transformResponseBody(body: JValue): JValue = body.underscoreKeys

  before() {
    contentType = formats("json")
  }

  options("/*") {
    response.setHeader(
      "Access-Control-Allow-Headers", request.getHeader("Access-Control-Request-Headers")
    )
  }


  get("/") {
    val produto = Produto.all
    Map("msg" -> "sucess", "dados" -> produto.asJson)
  }
  get("/:id") {
    val id = params("id").toLong
    val produto = Produto.find(id).get

    Map(
      "msg" -> "Sucess",
      "dados" -> (produto.toMap + ("variants" -> produto.variant.asJson))
    )
  }
  post("/"){
    val body = parsedBody.extract[Map[String, Any]]
    val name = body("nome").toString
    val brand = body("comentario").toString


    val produto = Produto(name, brand)

    produto.save()

    Map("msg" -> "Sucess", "dado" -> produto.asJson)
  }

}
