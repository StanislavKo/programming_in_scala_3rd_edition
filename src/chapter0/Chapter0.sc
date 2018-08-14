package chapter0

import com.sun.org.apache.xpath.internal.compiler.Lexer

object Chapter0 {
	def max(x: Int, y: Int): Int = {
		if (x > y) x
		else y
	}                                         //> max: (x: Int, y: Int)Int

  println("Welcome to the Scala worksheet")       //> Welcome to the Scala worksheet
  val res0: Int = 1 + 2                           //> res0  : Int = 3
  res0 * 3                                        //> res0: Int = 9
  var msg: String = "Hello, world!"               //> msg  : String = Hello, world!
  println(msg.getClass)                           //> class java.lang.String
  println(msg)                                    //> Hello, world!
  max(2, 3)                                       //> res1: Int = 3
  max(3, 2)                                       //> res2: Int = 3
  
  var x = 0;                                      //> x  : Int = 0
  while (x < 5) {
  	println(x)
  	x += 1
  }                                               //> 0
                                                  //| 1
                                                  //| 2
                                                  //| 3
                                                  //| 4
  
  val args = Array("Scala", "is", "a", "tremendous", "fun")
                                                  //> args  : Array[String] = Array(Scala, is, a, tremendous, fun)
  x = 0;
  while (x < args.length) {
  	println(args(x))
  	x += 1
  }                                               //> Scala
                                                  //| is
                                                  //| a
                                                  //| tremendous
                                                  //| fun
  msg = ""
  args.foreach ( x => msg += (x + " ") )
  println(msg)                                    //> Scala is a tremendous fun 
  
  for (arg <- args)
  	println(arg)                              //> Scala
                                                  //| is
                                                  //| a
                                                  //| tremendous
                                                  //| fun
  
  for (x <- 0 to args.length - 1)
  	print(args(x) + " " )                     //> Scala is a tremendous fun 
 	println()                                 //> 
 	
 
 	val tuple = (11, "Tuple")                 //> tuple  : (Int, String) = (11,Tuple)
 	println(tuple._1)                         //> 11
 	
 	val map = Map(1 -> "I", 2 -> "II", 3 -> "III")
                                                  //> map  : scala.collection.immutable.Map[Int,String] = Map(1 -> I, 2 -> II, 3 -
                                                  //| > III)
  println(map(2))                                 //> II
  map.mkString(", ")                              //> res3: String = 1 -> I, 2 -> II, 3 -> III
  map.map{case(k,v) => k}                         //> res4: scala.collection.immutable.Iterable[Int] = List(1, 2, 3)
  
  val maxLength1 = args.maxBy[Int] ( x => x.length() ).length
                                                  //> maxLength1  : Int = 10
  val maxLength2 = args.reduceLeft((a, b) => if (a.length() > b.length()) a else b).length
                                                  //> maxLength2  : Int = 10
  def getCharsLength(s: String) = s.length()      //> getCharsLength: (s: String)Int
  val maxCharsLength = getCharsLength(maxLength1.toString())
                                                  //> maxCharsLength  : Int = 2
                                                  
  for (arg <- args) {
  	val charsLength = getCharsLength(arg.length().toString())
  	val paddingLength = maxCharsLength - charsLength;
  	val padding = " " * paddingLength;
  	println(padding + arg.length() + " | " + arg)
  }                                               //>  5 | Scala
                                                  //|  2 | is
                                                  //|  1 | a
                                                  //| 10 | tremendous
                                                  //|  3 | fun
}