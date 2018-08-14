package chapter09

object FileMatcher {
  val filesHere = new java.io.File(".").listFiles()
  def filesEnding(extension: String) = {
//    for (file <- filesHere; if file.getName().endsWith(extension))
//      yield file
    filesByQuery((x: String, y: String) => x.endsWith(y), extension)
  }
  def filesContaining(substring: String) = {
//    for (file <- filesHere; if file.getName().contains(substring))
//      yield file
    filesByQuery((x: String, y: String) => x.contains(y), substring)
  }
  def filesByQuery(comparisonFund: (String, String) => Boolean, query: String) = {
    for (file <- filesHere; if comparisonFund(file.getName(), query))
      yield file
  }
}