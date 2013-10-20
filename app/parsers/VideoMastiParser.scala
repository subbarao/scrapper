package parsers

import scala.collection.mutable.HashMap

import org.jsoup.Jsoup
import play.Logger

object VideoMastiParser extends Search {
  private var allLetters = "abcdefghijklmnopqrstuvwxyz"

  val url = "http://videomasti.net/telugu-movie-index-a/"
  lazy val parse = {
    val allMovies = new HashMap[String, String]
    val iter = Jsoup.connect(url).get.select(".azindex li a").iterator
    while (iter.hasNext) {
      val element = iter.next
      allMovies.put(element.select("span").first.text, element.attr("href"))
    }
    this.allLetters.map(add)
    for (letter <- this.allLetters.iterator; iter = getMoviesIterator(letter)) {
      while (iter.hasNext) {
        val element = iter.next
        val link = element.select("a").first
        allMovies.put(link.text, link.attr("href"))
      }
    }
    allMovies
  }

  private def add(c: Char): HashMap[String, String] = {
    val allMovies = new HashMap[String, String]
  
    val iter = this.getMoviesIterator(c)
    while (iter.hasNext) {
      val element = iter.next
      val link = element.select("a").first
      allMovies.put(link.text, link.attr("href"))
    }
    allMovies
  }

  private def getMoviesIterator(c: Char) = {
    Jsoup.connect("http://videomasti.net/telugu-movie-index-$c/").get.select(".azindex li a").iterator
  }
}

