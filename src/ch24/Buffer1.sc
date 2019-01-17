package ch24

import scala.collection.mutable.ListBuffer

object Buffer1 {
  println("Welcome to the Scala worksheet")       //> Welcome to the Scala worksheet
  val xs = Seq(1, 2, 3, 4, 5, 6, 7, 8)            //> xs  : Seq[Int] = List(1, 2, 3, 4, 5, 6, 7, 8)
  val buf = ListBuffer(1, 2, 3, 4, 5, 6, 7, 8)    //> buf  : scala.collection.mutable.ListBuffer[Int] = ListBuffer(1, 2, 3, 4, 5, 
                                                  //| 6, 7, 8)

  // Additions:
  buf += 10                                       //> res0: ch24.Buffer1.buf.type = ListBuffer(1, 2, 3, 4, 5, 6, 7, 8, 10)
  buf += (10, 11, 12)                             //> res1: ch24.Buffer1.buf.type = ListBuffer(1, 2, 3, 4, 5, 6, 7, 8, 10, 10, 11,
                                                  //|  12)
  buf ++= xs                                      //> res2: ch24.Buffer1.buf.type = ListBuffer(1, 2, 3, 4, 5, 6, 7, 8, 10, 10, 11,
                                                  //|  12, 1, 2, 3, 4, 5, 6, 7, 8)
  10 +=: buf                                      //> res3: ch24.Buffer1.buf.type = ListBuffer(10, 1, 2, 3, 4, 5, 6, 7, 8, 10, 10,
                                                  //|  11, 12, 1, 2, 3, 4, 5, 6, 7, 8)
  xs ++=: buf                                     //> res4: ch24.Buffer1.buf.type = ListBuffer(1, 2, 3, 4, 5, 6, 7, 8, 10, 1, 2, 3
                                                  //| , 4, 5, 6, 7, 8, 10, 10, 11, 12, 1, 2, 3, 4, 5, 6, 7, 8)
  val buf2 = ListBuffer(1, 2, 3, 4, 5, 6, 7, 8)   //> buf2  : scala.collection.mutable.ListBuffer[Int] = ListBuffer(1, 2, 3, 4, 5,
                                                  //|  6, 7, 8)
  buf2 insert (3, 10)
  buf2                                            //> res5: scala.collection.mutable.ListBuffer[Int] = ListBuffer(1, 2, 3, 10, 4, 
                                                  //| 5, 6, 7, 8)
  buf2 insertAll (3, xs)
  buf2                                            //> res6: scala.collection.mutable.ListBuffer[Int] = ListBuffer(1, 2, 3, 1, 2, 3
                                                  //| , 4, 5, 6, 7, 8, 10, 4, 5, 6, 7, 8)

  // Removals:
  buf2 -= 10                                      //> res7: ch24.Buffer1.buf2.type = ListBuffer(1, 2, 3, 1, 2, 3, 4, 5, 6, 7, 8, 4
                                                  //| , 5, 6, 7, 8)
  buf2 remove 3                                   //> res8: Int = 1
  buf2                                            //> res9: scala.collection.mutable.ListBuffer[Int] = ListBuffer(1, 2, 3, 2, 3, 4
                                                  //| , 5, 6, 7, 8, 4, 5, 6, 7, 8)
  buf2 remove (3, xs.length)
  buf2                                            //> res10: scala.collection.mutable.ListBuffer[Int] = ListBuffer(1, 2, 3, 5, 6, 
                                                  //| 7, 8)
  buf2 trimStart 3
  buf2                                            //> res11: scala.collection.mutable.ListBuffer[Int] = ListBuffer(5, 6, 7, 8)
  buf2 trimEnd 3
  buf2                                            //> res12: scala.collection.mutable.ListBuffer[Int] = ListBuffer(5)
  buf2.clear()
  buf2                                            //> res13: scala.collection.mutable.ListBuffer[Int] = ListBuffer()

  // Cloning:
  buf.clone                                       //> res14: scala.collection.mutable.ListBuffer[Int] = ListBuffer(1, 2, 3, 4, 5, 
                                                  //| 6, 7, 8, 10, 1, 2, 3, 4, 5, 6, 7, 8, 10, 10, 11, 12, 1, 2, 3, 4, 5, 6, 7, 8)
                                                  //| 
}