package h1bcentral

import org.specs2.mutable.Specification
import parsers.VideoMastiParser
import parsers.ManatelgumoviesParser

class VideoScrapper extends Specification {
  "The 'Hello world' string" should {
    "contain 11 characters" in {
      val parser = new ManatelgumoviesParser()
      println(parser.findByName("Antamkadidi"))
      println(parser.findByName("A"))

      "Hello world" must have size (11)
    }
  }
}