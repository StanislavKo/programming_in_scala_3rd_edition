package ch02

object ch02 {
  println("Welcome to the Scala worksheet")       //> Welcome to the Scala worksheet
  val val01 = 1 + 2                               //> val01  : Int = 3
  val01 * 3                                       //> res0: Int = 9
  val val02: String = "asdf"                      //> val02  : String = asdf

  def max(a: Int, b: Int): Int = {
    if (a > b) a else b
  }                                               //> max: (a: Int, b: Int)Int
  def max2(a: Int, b: Int) = if (a > b) a else b  //> max2: (a: Int, b: Int)Int

  max(1, 2)                                       //> res1: Int = 2
  max2(1, 2)                                      //> res2: Int = 2

  var i = 0                                       //> i  : Int = 0
  while (i < 5) {
    println(i)
    i += 1
  }                                               //> 0
                                                  //| 1
                                                  //| 2
                                                  //| 3
                                                  //| 4
  val args = List("scala", "is", "fun")           //> args  : List[String] = List(scala, is, fun)
  args.foreach(println)                           //> scala
                                                  //| is
                                                  //| fun
  args.foreach((arg: String) => println(arg))     //> scala
                                                  //| is
                                                  //| fun
}