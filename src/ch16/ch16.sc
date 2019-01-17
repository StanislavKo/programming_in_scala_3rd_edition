package ch16

import scala.util.control.Breaks._

object ch16 {
  println("Welcome to the Scala worksheet")       //> Welcome to the Scala worksheet
  val fruits: List[String] = List("apples", "oranges", "pears")
                                                  //> fruits  : List[String] = List(apples, oranges, pears)
  val empty = List()                              //> empty  : List[Nothing] = List()
  val fruits2 = "apples" :: "oranges" :: "pears" :: Nil
                                                  //> fruits2  : List[String] = List(apples, oranges, pears)
  Nil.isEmpty                                     //> res0: Boolean = true
  // Nil.tail

  def isort1(list: List[Int]): List[Int] = {
    var result: List[Int] = List()
    for (numIn <- list) {
      if (result == Nil) result = List(numIn)
      else
        breakable {
          for (i <- 0 to result.size) {
            if (i == result.size) {
              result = result :+ numIn
              break
            } else if (numIn < result(i)) {
              result = result.slice(0, i) ::: (numIn :: result.slice(i, result.size))
              break
            }
          }
        }
    }
    result
  }                                               //> isort1: (list: List[Int])List[Int]

  def isort2(list: List[Int]): List[Int] = {
    var result: List[Int] = List()
    for (numIn <- list) {
      result = insert2(result, numIn)
    }
    result
  }                                               //> isort2: (list: List[Int])List[Int]
  def insert2(result: List[Int], numIn: Int): List[Int] = {
    if (result == Nil) List(numIn)
    else {
      for (i <- 0 to result.size) {
        if (i == result.size) {
          return result :+ numIn
        } else if (numIn < result(i)) {
          return result.slice(0, i) ::: (numIn :: result.slice(i, result.size))
        }
      }
      result
    }
  }                                               //> insert2: (result: List[Int], numIn: Int)List[Int]

  def isort3(list: List[Int]): List[Int] = {
    if (list == Nil) Nil
    else insert3(list.head, isort3(list.tail))
  }                                               //> isort3: (list: List[Int])List[Int]
  def insert3(numIn: Int, result: List[Int]): List[Int] = {
    if (result == Nil || numIn <= result.head) numIn :: result
    else result.head :: insert3(numIn, result.tail)
  }                                               //> insert3: (numIn: Int, result: List[Int])List[Int]

  def isort4(list: List[Int]): List[Int] = list match {
    case Nil => Nil
    case _   => insert4(list.head, isort4(list.tail))
  }                                               //> isort4: (list: List[Int])List[Int]
  def insert4(numIn: Int, result: List[Int]): List[Int] = result match {
    case Nil                   => numIn :: result
    case y :: ys if numIn <= y => numIn :: result
    case y :: ys               => y :: insert4(numIn, ys)
  }                                               //> insert4: (numIn: Int, result: List[Int])List[Int]

  val isort1method = isort1 _                     //> isort1method  : List[Int] => List[Int] = ch16.ch16$$$Lambda$11/1811044090@6
                                                  //| cd8737
  val isort2method = isort2 _                     //> isort2method  : List[Int] => List[Int] = ch16.ch16$$$Lambda$12/586617651@13
                                                  //| 969fbe
  val isort3method = isort3 _                     //> isort3method  : List[Int] => List[Int] = ch16.ch16$$$Lambda$13/1789550256@3
                                                  //| 498ed
  val isort4method = isort4 _                     //> isort4method  : List[Int] => List[Int] = ch16.ch16$$$Lambda$14/440434003@3d
                                                  //| 8c7aca

  val sorts = List(isort1method, isort2method, isort3method, isort4method)
                                                  //> sorts  : List[List[Int] => List[Int]] = List(ch16.ch16$$$Lambda$11/18110440
                                                  //| 90@6cd8737, ch16.ch16$$$Lambda$12/586617651@13969fbe, ch16.ch16$$$Lambda$13
                                                  //| /1789550256@3498ed, ch16.ch16$$$Lambda$14/440434003@3d8c7aca)
  for (method <- sorts) {
    println(method(List()))
    println(method(List(1)))
    println(method(List(1, 2)))
    println(method(List(2, 1)))
    println(method(List(1, 2, 3)))
    println(method(List(3, 2, 1)))
    println(method(List(4, 3, 2, 1)))
  }                                               //> List()
                                                  //| List(1)
                                                  //| List(1, 2)
                                                  //| List(1, 2)
                                                  //| List(1, 2, 3)
                                                  //| List(1, 2, 3)
                                                  //| List(1, 2, 3, 4)
                                                  //| List()
                                                  //| List(1)
                                                  //| List(1, 2)
                                                  //| List(1, 2)
                                                  //| List(1, 2, 3)
                                                  //| List(1, 2, 3)
                                                  //| List(1, 2, 3, 4)
                                                  //| List()
                                                  //| List(1)
                                                  //| List(1, 2)
                                                  //| List(1, 2)
                                                  //| List(1, 2, 3)
                                                  //| List(1, 2, 3)
                                                  //| List(1, 2, 3, 4)
                                                  //| List()
                                                  //| List(1)
                                                  //| List(1, 2)
                                                  //| List(1, 2)
                                                  //| List(1, 2, 3)
                                                  //| List(1, 2, 3)
                                                  //| List(1, 2, 3, 4)

  val l1 = List(1, 2)                             //> l1  : List[Int] = List(1, 2)
  val l2 = List(3, 4, 5)                          //> l2  : List[Int] = List(3, 4, 5)
  l1 ::: l2                                       //> res1: List[Int] = List(1, 2, 3, 4, 5)

  def append[T](xs: List[T], ys: List[T]): List[T] = xs match {
    case Nil      => ys
    case x :: xs2 => x :: append(xs2, ys)
  }                                               //> append: [T](xs: List[T], ys: List[T])List[T]
  append(l1, l2)                                  //> res2: List[Int] = List(1, 2, 3, 4, 5)
  List(1, 2, 3).length                            //> res3: Int = 3
  List(1, 2, 3).init                              //> res4: List[Int] = List(1, 2)
  List(1, 2, 3).last                              //> res5: Int = 3
  List(1, 2, 3).reverse                           //> res6: List[Int] = List(3, 2, 1)
  List(1, 2, 3, 4, 5) take 2                      //> res7: List[Int] = List(1, 2)
  List(1, 2, 3, 4, 5) drop 2                      //> res8: List[Int] = List(3, 4, 5)
  List(1, 2, 3, 4, 5) splitAt 2                   //> res9: (List[Int], List[Int]) = (List(1, 2),List(3, 4, 5))
  List(1, 2, 3, 4, 5) apply 2                     //> res10: Int = 3
  List(1, 2, 3, 4, 5)(2)                          //> res11: Int = 3
  List(List(1, 2), List(4, 5)).flatten            //> res12: List[Int] = List(1, 2, 4, 5)
  val abcde = List('a', 'b', 'c', 'd', 'e')       //> abcde  : List[Char] = List(a, b, c, d, e)
  abcde.indices zip abcde                         //> res13: scala.collection.immutable.IndexedSeq[(Int, Char)] = Vector((0,a), (
                                                  //| 1,b), (2,c), (3,d), (4,e))
  abcde.toArray                                   //> res14: Array[Char] = Array(a, b, c, d, e)
  abcde.toArray.toList                            //> res15: List[Char] = List(a, b, c, d, e)
 
 
 
 
  List(1, 2, 3).map(x => x.toByte)                //> res16: List[Byte] = List(1, 2, 3)
  List(1, 2, 3).map(_ + 1)                        //> res17: List[Int] = List(2, 3, 4)
  List(List(1, 2), List(4, 5)).flatMap(x => x)    //> res18: List[Int] = List(1, 2, 4, 5)
  List(1, 2, 3, 4, 5) find (_ % 2 == 0)           //> res19: Option[Int] = Some(2)
  List(1, 2, 3, 4, 5) partition (_ % 2 == 0)      //> res20: (List[Int], List[Int]) = (List(2, 4),List(1, 3, 5))
  List(1, 2, 3, -4, 5) takeWhile { _ > 0 }        //> res21: List[Int] = List(1, 2, 3)
  List(1, 2, 3, -4, 5) span { _ > 0 }             //> res22: (List[Int], List[Int]) = (List(1, 2, 3),List(-4, 5))
  List(1, 2, 3, -4, 5) forall { _ > 0 }           //> res23: Boolean = false
  List(1, 2, 3, -4, 5) exists { _ > 0 }           //> res24: Boolean = true
  (0 /: List(1, 2, 3, 4, 5)) (_ + _)              //> res25: Int = 15
  (1 /: List(1, 2, 3, 4, 5)) (_ * _)              //> res26: Int = 120
  (List(1, 2, 3, 4, 5) :\ 0) (_ + _)              //> res27: Int = 15
  List(1, 2, 3, -4, 5) sortWith(_ < _)            //> res28: List[Int] = List(-4, 1, 2, 3, 5)
  
  
  
  
  List.fill(5)('a')                               //> res29: List[Char] = List(a, a, a, a, a)
  List.tabulate(5)(_ * 2)                         //> res30: List[Int] = List(0, 2, 4, 6, 8)
  List.concat(List('a', 'b'), List('c'))          //> res31: List[Char] = List(a, b, c)
  (List(10, 20), List(3, 4, 5)).zipped.map(_ * _) //> res32: List[Int] = List(30, 80)
  (List("abc", "de"), List(3, 2)).zipped.forall(_.length == _)
                                                  //> res33: Boolean = true
}