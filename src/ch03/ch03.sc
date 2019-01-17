package ch03

import scala.collection.mutable

object ch03 {
  println("Welcome to the Scala worksheet")       //> Welcome to the Scala worksheet
  val _123 = 1 :: 2 :: 3 :: Nil                   //> _123  : List[Int] = List(1, 2, 3)
  val _123_1 = 1 :: 2 :: 3 :: List()              //> _123_1  : List[Int] = List(1, 2, 3)
  val _123_2 = 1 :: List(2, 3)                    //> _123_2  : List[Int] = List(1, 2, 3)
  val _1234 = List(1, 2) ::: List(3, 4)           //> _1234  : List[Int] = List(1, 2, 3, 4)
  val tuple = (1, 2, "3")                         //> tuple  : (Int, Int, String) = (1,2,3)
  println(tuple._1)                               //> 1
  println(tuple._3)                               //> 3
  val jetSet1 = scala.collection.mutable.Set("Boeing", "Airbus")
                                                  //> jetSet1  : scala.collection.mutable.Set[String] = Set(Airbus, Boeing)
  println(jetSet1.getClass)                       //> class scala.collection.mutable.HashSet
  var jetSet2 = jetSet1 += "Sukhoi"               //> jetSet2  : scala.collection.mutable.Set[String] = Set(Sukhoi, Airbus, Boeing
                                                  //| )
  jetSet2 = scala.collection.mutable.Set("Boeing", "Airbus", "Sukhoi")
  println(jetSet2.getClass)                       //> class scala.collection.mutable.HashSet
  println(jetSet1 == jetSet2)                     //> true

  val aMap = mutable.Map[Int, String]()           //> aMap  : scala.collection.mutable.Map[Int,String] = Map()
  val tuple2 = (1, "1")                           //> tuple2  : (Int, String) = (1,1)
  println(tuple2.getClass)                        //> class scala.Tuple2
  aMap += tuple2                                  //> res0: ch03.ch03.aMap.type = Map(1 -> 1)
  aMap += (2 -> "2")                              //> res1: ch03.ch03.aMap.type = Map(2 -> 2, 1 -> 1)
  aMap += scala.Tuple2(3, "3")                    //> res2: ch03.ch03.aMap.type = Map(2 -> 2, 1 -> 1, 3 -> 3)

	

}