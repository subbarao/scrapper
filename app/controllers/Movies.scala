package controllers

import play.api.libs.json.Json
import play.api.libs.json.Json.toJsFieldJsValueWrapper
import play.api.mvc.Action
import play.api.mvc.Controller
import play.api.libs.json.JsObject
import play.api.libs.json.JsArray

object Movies extends Controller {
  def index = Action {
    Ok(Json.arr("movies"))
  }
}