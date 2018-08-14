package chapter08

import scala.io.Source

object LongLines_LocalFunction {
  def processFile(filename: String, width: Int) = {
    def processLine(line: String) = {
      if (line.length() > width) {
        println(line.length() + " : " + line)
      }
    }

    val source = Source.fromFile(filename)
    for (line <- source.getLines()) {
      processLine(line)
    }
  }

}