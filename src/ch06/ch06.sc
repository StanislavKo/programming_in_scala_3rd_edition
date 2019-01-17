package ch06

object ch06 {
  println("Welcome to the Scala worksheet")       //> Welcome to the Scala worksheet

  val r1 = new Rational(1, 2)                     //> r1  : ch06.Rational = 1/2
  val r2 = new Rational(2, 3)                     //> r2  : ch06.Rational = 2/3
  val r3 = new Rational(1, 2)                     //> r3  : ch06.Rational = 1/2
  val r4 = new Rational(3)                        //> r4  : ch06.Rational = 3/1
  r1 + r2                                         //> res0: ch06.Rational = 7/6
  r1 + r3                                         //> res1: ch06.Rational = 1/1
  r1 * r3                                         //> res2: ch06.Rational = 1/4
  r1 / r3                                         //> res3: ch06.Rational = 1/1
  (r1 + 2)                                        //> res4: ch06.Rational = 5/2

  implicit def intToRational(i: Int) = new Rational(i, 1)
                                                  //> intToRational: (i: Int)ch06.Rational

  2 + r1                                          //> res5: ch06.Rational = 5/2

}