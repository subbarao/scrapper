package parsers

import org.jsoup.Jsoup

class VideoMastiParser {
  val url = "http://videomasti.net/telugu-movie-index-a/"
  def parse = {
    
    Jsoup.connect(url).get.select(".azindex li a").getClass
  }
}