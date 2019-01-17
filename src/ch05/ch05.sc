package ch05

object ch05 {
  println("Welcome to the Scala worksheet")       //> Welcome to the Scala worksheet
  val name = "stas"                               //> name  : String = stas
  val str = """|stas
  |stas2""".stripMargin                           //> str  : String = stas
                                                  //| stas2
  println(s"Hello, $name!")                       //> Hello, stas!
  println(s"6*7=${6 * 7}")                        //> 6*7=42
  f"${math.Pi}%.3f"                               //> res0: String = 3,142
  1.+(2)                                          //> res1: Int(3) = 3
  name indexOf 'a'                                //> res2: Int = 2
  name indexOf ('s', 1)                           //> res3: Int = 3
  
//  -2.0
	(2.0).unary_-                             //> res4: Double = -2.0
	
	println                                   //> 
	name toLowerCase                          //> res5: String = stas
}