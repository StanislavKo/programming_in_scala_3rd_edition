package ch04

object ch04 {
  println("Welcome to the Scala worksheet")       //> Welcome to the Scala worksheet
  val cl01 = new ChecksumAccumulator              //> cl01  : ch04.ChecksumAccumulator = ch04.ChecksumAccumulator@129a8472
  println(cl01.checksum)                          //> -1
  println(cl01.checksum2)                         //> -1
  println(cl01.checksum3)                         //> -1
  println(cl01.checksum4)                         //> -1
  println(cl01.add(1))                            //> ()
  println(cl01.add3(1))                           //> ()
  ChecksumAccumulator.calculate("1")              //> res0: Int = -50
}