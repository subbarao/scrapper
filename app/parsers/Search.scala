package parsers

import scala.collection.mutable.HashMap

trait Search {
  def parse: HashMap[String, String]
  def findByName(search: String): Array[String] = {
		println(search)
    parse.keySet.filter(_.startsWith(search)).toArray

  }
}