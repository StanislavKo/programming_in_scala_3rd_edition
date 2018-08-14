package chapter6

//import chapter6.Rational

object Chapter6 {
  println("Welcome to the Scala worksheet")       //> Welcome to the Scala worksheet
  val r1: Rational = new Rational(1, 2)           //> r1  : chapter6.Rational = 1/2
  val r2: Rational = new Rational(2, 3)           //> r2  : chapter6.Rational = 2/3
  //  val r3: Rational = new Rational(2, 0)
  val r4 = new Rational(66, 42)                   //> r4  : chapter6.Rational = 11/7

  r1 + r2                                         //> res0: chapter6.Rational = 7/6
  r1 / 2                                          //> res1: chapter6.Rational = 1/4
  r1 < r2                                         //> res2: Boolean = true
  r1.max(r2)                                      //> res3: chapter6.Rational = 2/3
  r1 * r2                                         //> res4: chapter6.Rational = 1/3
  r1 * 2                                          //> res5: chapter6.Rational = 1/1

  implicit def intToRational(x: Int) = new Rational(x, 1)
                                                  //> intToRational: (x: Int)chapter6.Rational
  2 * r1                                          //> res6: chapter6.Rational = 1/1
}