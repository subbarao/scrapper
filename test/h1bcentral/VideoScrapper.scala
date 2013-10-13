package h1bcentral

import org.specs2.mutable.Specification

import co.freeside.betamax.Recorder
import co.freeside.betamax.proxy.jetty.ProxyServer
import parsers.VideoMastiParser

class VideoScrapper extends Specification {
  def withTape(tapeName: String, functionUnderTest: () => Any) = {
    synchronized {
      val recorder = new Recorder
      val proxyServer = new ProxyServer(recorder)
      recorder.insertTape(tapeName)
      proxyServer.start()
      try {
        functionUnderTest()
      } finally {
        recorder.ejectTape()
        proxyServer.stop()
      }
    }
  }

  "The 'Hello world' string" should {
    "contain 11 characters" in {
      val parser = new VideoMastiParser()
      println(parser.parse)
      
      
      "Hello world" must have size (11)
    }
  }
}