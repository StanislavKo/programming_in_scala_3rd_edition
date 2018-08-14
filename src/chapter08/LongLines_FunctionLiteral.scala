package chapter08

import scala.io.Source

object LongLines_FunctionLiteral {
  def processFile(filename: String, width: Int) = {
    val func = (line: String) => {
      if (line.length() > width) {
        println(line.length() + " : " + line)
      }
    }
    val source = Source.fromFile(filename)
    for (line <- source.getLines()) {
      func(line)
    }
  }

}