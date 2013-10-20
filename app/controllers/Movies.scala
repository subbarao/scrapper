package controllers

import play.api.libs.json.Json
import play.api.libs.json.Json.toJsFieldJsValueWrapper
import play.api.mvc.Action
import play.api.mvc.Controller
import play.api.libs.json.JsObject
import play.api.libs.json.JsArray
import parsers.ManatelgumoviesParser
import play.libs.Akka
import akka.actor.Props
import akka.pattern.ask
import play.api.Logger
import scala.concurrent.Await
import akka.pattern.ask
import akka.util.Timeout
import scala.concurrent.duration._
import scala.concurrent.ExecutionContext

object Movies extends Controller {
  implicit val timeout = Timeout(5 seconds)
  def index(name: Option[String]) = Action.async {
    implicit val context = akka.dispatch.ExecutionContexts.global
    val future = (parsers.ManatelgumoviesParser.instance ? name.getOrElse(""))
    future map { result =>
      Ok(Json.toJson(result.asInstanceOf[Array[String]]))
    }
  }
}