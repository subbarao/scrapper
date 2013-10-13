package controllers

import play.api.libs.json.Json

import play.api.libs.json.Json.toJsFieldJsValueWrapper
import play.api.mvc.Action
import play.api.mvc.Controller
import play.api.libs.json.JsObject
import play.api.libs.json.JsArray
import parsers.ManatelgumoviesParser

object Movies extends Controller {
  def index(name: Option[String]) = Action {
    val test = new ManatelgumoviesParser()
    Ok(Json.toJson(test.findByName(name.getOrElse(""))))
  }
}