package parsers

import scala.collection.mutable.HashMap

trait Search {
  def parse: HashMap[String, String]
  def findByName(search: String) = {
    parse.keySet.filter(_.startsWith(search)).map(parse.get)
  }
}