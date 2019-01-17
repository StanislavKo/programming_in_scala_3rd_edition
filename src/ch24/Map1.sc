package ch24

object Map1 {
  println("Welcome to the Scala worksheet")       //> Welcome to the Scala worksheet
  val ms1 = Map(1 -> "one", 2 -> "two", 3 -> "three", 4 -> "four")
                                                  //> ms1  : scala.collection.immutable.Map[Int,String] = Map(1 -> one, 2 -> two, 
                                                  //| 3 -> three, 4 -> four)
  val ms = scala.collection.mutable.Map(1 -> "one", 2 -> "two", 3 -> "three", 4 -> "four")
                                                  //> ms  : scala.collection.mutable.Map[Int,String] = Map(2 -> two, 4 -> four, 1 
                                                  //| -> one, 3 -> three)

  val kvs1 = Map(3 -> "three", 4 -> "four")       //> kvs1  : scala.collection.immutable.Map[Int,String] = Map(3 -> three, 4 -> fo
                                                  //| ur)
  val fEven: Int => Boolean = { x => x % 2 == 0 } //> fEven  : Int => Boolean = ch24.Map1$$$Lambda$12/2091156596@337d0578
  val fOdd: Int => Boolean = { x => x % 2 == 1 }  //> fOdd  : Int => Boolean = ch24.Map1$$$Lambda$13/1508395126@61a485d2
  val fOdd2: (Int, String) => Boolean = { (k, v) => k % 2 == 1 }
                                                  //> fOdd2  : (Int, String) => Boolean = ch24.Map1$$$Lambda$14/1007251739@5cc7c2a
                                                  //| 6

  // Lookups:
  ms1 get 2                                       //> res0: Option[String] = Some(two)
  ms1(2)                                          //> res1: String = two
  ms1 getOrElse (2, "default")                    //> res2: String = two
  ms1 contains 2                                  //> res3: Boolean = true
  ms1 isDefinedAt 2                               //> res4: Boolean = true

  // Additions and updates:
  ms1 + (10 -> "ten")                             //> res5: scala.collection.immutable.Map[Int,String] = Map(10 -> ten, 1 -> one, 
                                                  //| 2 -> two, 3 -> three, 4 -> four)
  ms1 + (10 -> "ten", 11 -> "eleven")             //> res6: scala.collection.immutable.Map[Int,String] = Map(10 -> ten, 1 -> one, 
                                                  //| 2 -> two, 3 -> three, 11 -> eleven, 4 -> four)
  ms1 ++ kvs1                                     //> res7: scala.collection.immutable.Map[Int,String] = Map(1 -> one, 2 -> two, 3
                                                  //|  -> three, 4 -> four)
  ms1 updated (10, "ten")                         //> res8: scala.collection.immutable.Map[Int,String] = Map(10 -> ten, 1 -> one, 
                                                  //| 2 -> two, 3 -> three, 4 -> four)

  // Removals:
  ms1 - 2                                         //> res9: scala.collection.immutable.Map[Int,String] = Map(1 -> one, 3 -> three,
                                                  //|  4 -> four)
  ms1 - (2, 3)                                    //> res10: scala.collection.immutable.Map[Int,String] = Map(1 -> one, 4 -> four)
                                                  //| 
  ms1 -- Set(2, 3)                                //> res11: scala.collection.immutable.Map[Int,String] = Map(1 -> one, 4 -> four)
                                                  //| 

  // Subcollections:
  ms1.keys                                        //> res12: Iterable[Int] = Set(1, 2, 3, 4)
  ms1.keySet                                      //> res13: scala.collection.immutable.Set[Int] = Set(1, 2, 3, 4)
  ms1.keysIterator                                //> res14: Iterator[Int] = non-empty iterator
  ms1.values                                      //> res15: Iterable[String] = MapLike.DefaultValuesIterable(one, two, three, fou
                                                  //| r)
  ms1.valuesIterator                              //> res16: Iterator[String] = non-empty iterator

  // Transformation:
  ms1 filterKeys fEven                            //> res17: scala.collection.immutable.Map[Int,String] = Map(2 -> two, 4 -> four)
                                                  //| 
  ms1 mapValues { _.length == 3 }                 //> res18: scala.collection.immutable.Map[Int,Boolean] = Map(1 -> true, 2 -> tru
                                                  //| e, 3 -> false, 4 -> false)

  // ********** mutable ***********
  // Additions and updates:
  ms(10) = "ten"
  ms                                              //> res19: scala.collection.mutable.Map[Int,String] = Map(2 -> two, 4 -> four, 
                                                  //| 10 -> ten, 1 -> one, 3 -> three)
  ms += (11 -> "eleven")                          //> res20: ch24.Map1.ms.type = Map(11 -> eleven, 2 -> two, 4 -> four, 10 -> ten
                                                  //| , 1 -> one, 3 -> three)
  ms += (11 -> "eleven", 12 -> "twelve")          //> res21: ch24.Map1.ms.type = Map(11 -> eleven, 2 -> two, 4 -> four, 10 -> ten
                                                  //| , 1 -> one, 12 -> twelve, 3 -> three)
  ms ++= kvs1                                     //> res22: ch24.Map1.ms.type = Map(11 -> eleven, 2 -> two, 4 -> four, 10 -> ten
                                                  //| , 1 -> one, 12 -> twelve, 3 -> three)
  ms put (10, "TEN")                              //> res23: Option[String] = Some(ten)
  ms getOrElseUpdate (20, "default")              //> res24: String = default

  // Removals:
  ms -= 10                                        //> res25: ch24.Map1.ms.type = Map(20 -> default, 11 -> eleven, 2 -> two, 4 -> 
                                                  //| four, 1 -> one, 12 -> twelve, 3 -> three)
  ms -= (10, 11, 12)                              //> res26: ch24.Map1.ms.type = Map(20 -> default, 2 -> two, 4 -> four, 1 -> one
                                                  //| , 3 -> three)
  ms --= Set(10, 20)                              //> res27: ch24.Map1.ms.type = Map(2 -> two, 4 -> four, 1 -> one, 3 -> three)
  ms remove 4                                     //> res28: Option[String] = Some(four)
  ms retain fOdd2                                 //> res29: ch24.Map1.ms.type = Map(1 -> one, 3 -> three)
  ms.clone.clear()
  ms                                              //> res30: scala.collection.mutable.Map[Int,String] = Map(1 -> one, 3 -> three)
                                                  //| 

  // Transformation and cloning:
  ms.transform((k, v) => v + "!!!")               //> res31: ch24.Map1.ms.type = Map(1 -> one!!!, 3 -> three!!!)
}