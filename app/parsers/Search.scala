package parsers

import scala.collection.mutable.HashMap
import akka.actor.Actor
import play.api.Logger

trait Search extends Actor {
  def parse: HashMap[String, String]

  def findByName(search: String): Array[String] = {
    parse.keySet.filter(_.matches("(?i:.*" + search + ".*)")).toArray
  }

  def receive = {
    case movie: String =>
      sender ! this.findByName(movie)
    case _ =>
      sender ! Array("")
  }

  override def preStart() = {
    Logger.info("Starting parser")
    this.parse.keySet
  }
}