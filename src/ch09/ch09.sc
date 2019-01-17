package ch09

object ch09 {
  println("Welcome to the Scala worksheet")       //> Welcome to the Scala worksheet

  def filesHere = (new java.io.File("g:\\")).listFiles()
                                                  //> filesHere: => Array[java.io.File]
  def filesMatching(query: String, matches: (String, String) => Boolean) = {
    for (file <- filesHere; if (matches(file.getName, query)))
      yield file
  }                                               //> filesMatching: (query: String, matches: (String, String) => Boolean)Array[ja
                                                  //| va.io.File]
  def filesEnding = filesMatching(".txt", _.endsWith(_))
                                                  //> filesEnding: => Array[java.io.File]
  
  filesEnding                                     //> res0: Array[java.io.File] = Array(g:\1.txt, g:\readme.txt, g:\task_planner.t
                                                  //| xt.txt, g:\traces.txt, g:\upwork_01.txt)
  def newSum(x: Int)(y: Int) = x + y              //> newSum: (x: Int)(y: Int)Int
  newSum(1)(2)                                    //> res1: Int = 3
}