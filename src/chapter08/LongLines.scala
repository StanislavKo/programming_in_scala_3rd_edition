package chapter08

import scala.io.Source

object LongLines {
  def processFile(filename: String, width: Int) = {
    val source = Source.fromFile(filename)
    for (line <- source.getLines()) {
      processLine(width, line)
    }
  }
  private def processLine(width: Int, line: String) = {
    if (line.length() > width) {
      println(line.length() + " : " + line)
    }
  }

}