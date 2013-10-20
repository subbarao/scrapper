package controllers

import play.api._

import play.api.mvc._
import parsers.ManatelgumoviesParser
import parsers.VideoMastiParser
import play.GlobalSettings

object Application extends Controller {
  def index = Action {
    Ok(views.html.index("Your new application is ready."))
  }
}

class Global extends GlobalSettings {
  @Override
  def onStart(app: Application) {
    parsers.ManatelgumoviesParser.instance ! "d"
  }
  
  @Override
  def onStop(app: Application) {
  }
}