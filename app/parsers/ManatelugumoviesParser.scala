package parsers

import scala.annotation.implicitNotFound
import scala.collection.JavaConversions.asScalaBuffer
import scala.collection.mutable.HashMap
import scala.concurrent.Await
import scala.concurrent.Future
import scala.concurrent.duration.DurationInt

import org.jsoup.Jsoup

import akka.actor.Props
import play.libs.Akka
class ManatelgumoviesParser extends Search {

  private var allLetters = 'A' to 'Z'

  implicit val ec = akka.dispatch.ExecutionContexts.global

  lazy val parse = {
    var futureSum = Future.fold(allLetters.map(extractMovies))(new HashMap[String, String])({ _ ++ _ })
    Await.result(futureSum, 7 seconds)
  }

  private def extractMovies(c: Char): Future[HashMap[String, String]] = Future {
    Jsoup.
      connect("http://www.tube.manatelugumovies.net/search/label/" + c + "?max-results=1000").
      get.select(".post-body.entry-content").foldLeft(new HashMap[String, String]) { (r, element) =>
        val link = element.select("a").first
        r.put(link.text, link.attr("href"))
        r
      }
  }
}

object ManatelgumoviesParser {
  val instance = Akka.system.actorOf(Props[ManatelgumoviesParser])
}