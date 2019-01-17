package ch17

import scala.collection.mutable.ListBuffer
import scala.collection.mutable.ArrayBuffer
import scala.collection.immutable.TreeSet

object ch17 {
  println("Welcome to the Scala worksheet")       //> Welcome to the Scala worksheet
  val colors = List("red", "blue", "green")       //> colors  : List[String] = List(red, blue, green)

  val buf = new ListBuffer[Int]                   //> buf  : scala.collection.mutable.ListBuffer[Int] = ListBuffer()
  buf += 2                                        //> res0: ch17.ch17.buf.type = ListBuffer(2)
  buf += 3                                        //> res1: ch17.ch17.buf.type = ListBuffer(2, 3)
  1 +=: buf                                       //> res2: ch17.ch17.buf.type = ListBuffer(1, 2, 3)
  buf.toList                                      //> res3: List[Int] = List(1, 2, 3)

  val buf2 = new ArrayBuffer[Int]                 //> buf2  : scala.collection.mutable.ArrayBuffer[Int] = ArrayBuffer()
  buf2 += 12                                      //> res4: ch17.ch17.buf2.type = ArrayBuffer(12)
  buf2 += 15                                      //> res5: ch17.ch17.buf2.type = ArrayBuffer(12, 15)
  buf2(0)                                         //> res6: Int = 12

  val treeSet = TreeSet[String]() ++ colors       //> treeSet  : scala.collection.immutable.TreeSet[String] = TreeSet(blue, green,
                                                  //|  red)
  
  val tuple = ("brown", 1)                        //> tuple  : (String, Int) = (brown,1)
  tuple._1                                        //> res7: String = brown
  val (word, idx) = tuple                         //> word  : String = brown
                                                  //| idx  : Int = 1
}