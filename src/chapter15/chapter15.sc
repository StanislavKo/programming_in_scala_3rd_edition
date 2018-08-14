package chapter15

import chapter15._
import Math.{ E, PI }

object chapter15 {
  def describe(x: Any) = x match {
    case 0             => "zero"
    case E             => "E"
    case PI            => "PI"
    case somethingElse => "not zero: " + somethingElse
  }                                               //> describe: (x: Any)String
  def isStringArray(x: Any) = x match {
    case a: Array[String] => "yes"
    case _             => "no"
  }                                               //> isStringArray: (x: Any)String
  def generalSize(x: Any) = x match {
  	case s: String => s.length()
  	case m: Map[_, _] => m.size
  	case (a, b, c) => 3
  	case _ => -1
  }                                               //> generalSize: (x: Any)Int
  def simplifyAdd(x: Any) = x match {
  	case BinOp("+", x, y) if x == y => BinOp("*", x, Number(2))
  	case e => e
  }                                               //> simplifyAdd: (x: Any)Any
  def describe2(x: Expr) = (x: @unchecked) match {
  	case Var(_) => "var"
  	case Number(_) => "number"
  }                                               //> describe2: (x: chapter15.Expr)String

  println("Welcome to the Scala worksheet")       //> Welcome to the Scala worksheet
  val v = Var("x")                                //> v  : chapter15.Var = Var(x)
  v.name                                          //> res0: String = x
  val op = BinOp("+", Number(1), v)               //> op  : chapter15.BinOp = BinOp(+,Number(1.0),Var(x))
  println(op)                                     //> BinOp(+,Number(1.0),Var(x))
  val op2 = op.copy(op = "-")                     //> op2  : chapter15.BinOp = BinOp(-,Number(1.0),Var(x))
  val opComplex = UnOp("-", UnOp("-", Number(1))) //> opComplex  : chapter15.UnOp = UnOp(-,UnOp(-,Number(1.0)))
  Expr.simplifyTop(opComplex)                     //> res1: chapter15.Expr = Number(1.0)
  describe(1)                                     //> res2: String = not zero: 1
  describe(E)                                     //> res3: String = E
  isStringArray(Array("abc", "def"))              //> res4: String = yes
  generalSize("asdf")                             //> res5: Int = 4
  generalSize(Map(1 -> "a", 2 -> "b"))            //> res6: Int = 2
  describe2(UnOp("+", Number(1)))                 //> scala.MatchError: UnOp(+,Number(1.0)) (of class chapter15.UnOp)
                                                  //| 	at chapter15.chapter15$$anonfun$main$1.describe2$1(chapter15.chapter15.s
                                                  //| cala:27)
                                                  //| 	at chapter15.chapter15$$anonfun$main$1.apply$mcV$sp(chapter15.chapter15.
                                                  //| scala:45)
                                                  //| 	at org.scalaide.worksheet.runtime.library.WorksheetSupport$$anonfun$$exe
                                                  //| cute$1.apply$mcV$sp(WorksheetSupport.scala:76)
                                                  //| 	at org.scalaide.worksheet.runtime.library.WorksheetSupport$.redirected(W
                                                  //| orksheetSupport.scala:65)
                                                  //| 	at org.scalaide.worksheet.runtime.library.WorksheetSupport$.$execute(Wor
                                                  //| ksheetSupport.scala:75)
                                                  //| 	at chapter15.chapter15$.main(chapter15.chapter15.scala:6)
                                                  //| 	at chapter15.chapter15.main(chapter15.chapter15.scala)
}