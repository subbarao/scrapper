package parsers

import scala.collection.mutable.HashMap
import org.jsoup.Jsoup
import play.api.Logger
import play.libs.Akka
import akka.actor.Props
import akka.actor.Actor
import scala.concurrent.ExecutionContext

class ManatelgumoviesParser extends Search {
  private var allLetters = "ABCDEFGHIJKLMNOPQRSTUVWXYZ"
  val url = "http://www.tube.manatelugumovies.net/search/label/A?max-results=1000"
  lazy val parse = {
    val allMovies = new HashMap[String, String]
    for (letter <- this.allLetters.iterator; iter = getMoviesIterator(letter)) {
      while (iter.hasNext) {
        val element = iter.next
        val link = element.select("a").first
        allMovies.put(link.text, link.attr("href"))
      }
    }
    allMovies
  }

  private def getMoviesIterator(c: Char) = {
    Jsoup.connect("http://www.tube.manatelugumovies.net/search/label/" + c + "?max-results=1000").get.select(".post-body.entry-content").iterator
  }
}

object ManatelgumoviesParser {
  val instance = Akka.system.actorOf(Props[ManatelgumoviesParser])
}