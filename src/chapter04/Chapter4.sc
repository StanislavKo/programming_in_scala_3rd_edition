package chapter04

class OperatorMiscallaneous {
	var sum: Int = 10
	def unary_!(): Unit = sum = -sum
	def show(): Int = sum
}

object Chapter4 {
  println("Welcome to the Scala worksheet")       //> Welcome to the Scala worksheet
  val acc = new ChecksumAccumulator1              //> acc  : chapter04.ChecksumAccumulator1 = chapter04.ChecksumAccumulator1@1fbc7
                                                  //| afb
  acc.add(3)
  acc.checksum()                                  //> res0: Int = 3

  ChecksumAccumulator2.calculate("123")           //> res1: Int = 150
  println(ChecksumAccumulator2.getClass)          //> class chapter04.ChecksumAccumulator2$
  
  val om = new OperatorMiscallaneous              //> om  : chapter04.OperatorMiscallaneous = chapter04.OperatorMiscallaneous@7a5d
                                                  //| 012c
  !om
  om.show                                         //> res2: Int = -10
  
  def salt() = { println("salt"); false }         //> salt: ()Boolean
  def pepper() = { println("pepper"); true }      //> pepper: ()Boolean
  pepper() && salt()                              //> pepper
                                                  //| salt
                                                  //| res3: Boolean = false
  salt() && pepper()                              //> salt
                                                  //| res4: Boolean = false
  
}