package chapter09

object chapter9 {
  println("Welcome to the Scala worksheet")       //> Welcome to the Scala worksheet
  FileMatcher.filesEnding("xml")                  //> res0: Array[java.io.File] = Array(.\artifacts.xml)

  FileMatcher.filesContaining(".")                //> res1: Array[java.io.File] = Array(.\.eclipseproduct, .\artifacts.xml, .\ecli
                                                  //| pse.exe, .\eclipse.ini, .\eclipsec.exe)
  ContainsNeg.containsNeg(List(1, 2, 3, 4))
  ContainsNeg.containsNeg(List(1, 2, -3, 4))
  
}