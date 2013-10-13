package parsers

import scala.collection.mutable.HashMap

import org.jsoup.Jsoup

class VideoMastiParser extends Search {
  val url = "http://videomasti.net/telugu-movie-index-a/"
  lazy val parse = {
    val allMovies = new HashMap[String, String]
    val iter = Jsoup.connect(url).get.select(".azindex li a").iterator
    while (iter.hasNext) {
      val element = iter.next
      allMovies.put(element.select("span").first.text, element.attr("href"))
    }

    allMovies
  }
}