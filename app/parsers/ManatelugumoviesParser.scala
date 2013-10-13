package parsers

import org.jsoup.Jsoup
import scala.collection.mutable.HashMap

class ManatelgumoviesParser extends Search {
  val url = "http://www.tube.manatelugumovies.net/search/label/A?max-results=1000"
  lazy val parse = {
    val allMovies = new HashMap[String, String]

    val iter = Jsoup.connect(url).get.select(".post-body.entry-content").iterator
    while (iter.hasNext) {
      val element = iter.next
      val link = element.select("a").first
      allMovies.put(link.text, link.attr("href"))
    }
    
    allMovies
  }
}