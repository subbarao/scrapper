package controllers

import play.api.libs.json.Json
import play.api.libs.json.Json.toJsFieldJsValueWrapper
import play.api.mvc.Action
import play.api.mvc.Controller
import play.api.libs.json.JsObject

object Movies extends Controller {
  def index = Action {
    Ok(Json.toJson(Map("id" -> Json.toJson(1), "name" -> Json.toJson("Kiki"))))
  }
}