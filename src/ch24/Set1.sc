package ch24

object Set1 {
  println("Welcome to the Scala worksheet")       //> Welcome to the Scala worksheet
  val xs1 = Set(1, 2, 3, 4)                       //> xs1  : scala.collection.immutable.Set[Int] = Set(1, 2, 3, 4)
  val ys1 = Set(3, 4)                             //> ys1  : scala.collection.immutable.Set[Int] = Set(3, 4)
  val xs = scala.collection.mutable.Set(1, 2, 3, 4)
                                                  //> xs  : scala.collection.mutable.Set[Int] = Set(1, 2, 3, 4)
  val fSmall: (Int => Boolean) = x => x < 10      //> fSmall  : Int => Boolean = ch24.Set1$$$Lambda$11/610984013@62043840

  // Tests:
  xs1 contains 3                                  //> res0: Boolean = true
  xs1(3)                                          //> res1: Boolean = true
  xs1 subsetOf ys1                                //> res2: Boolean = false
  ys1 subsetOf xs1                                //> res3: Boolean = true

  // Additions:
  xs1 + 10                                        //> res4: scala.collection.immutable.Set[Int] = Set(10, 1, 2, 3, 4)
  xs1 + (10, 11, 12)                              //> res5: scala.collection.immutable.Set[Int] = Set(10, 1, 2, 12, 3, 11, 4)
  xs1 ++ ys1                                      //> res6: scala.collection.immutable.Set[Int] = Set(1, 2, 3, 4)

  // Removals:
  xs1 - 4                                         //> res7: scala.collection.immutable.Set[Int] = Set(1, 2, 3)
  xs1 - (1, 2, 3)                                 //> res8: scala.collection.immutable.Set[Int] = Set(4)
  xs1 -- ys1                                      //> res9: scala.collection.immutable.Set[Int] = Set(1, 2)
  xs1.empty                                       //> res10: scala.collection.immutable.Set[Int] = Set()

  // Binary operations:
  xs1 & ys1                                       //> res11: scala.collection.immutable.Set[Int] = Set(3, 4)
  xs1 intersect ys1                               //> res12: scala.collection.immutable.Set[Int] = Set(3, 4)
  xs1 | ys1                                       //> res13: scala.collection.immutable.Set[Int] = Set(1, 2, 3, 4)
  xs1 union ys1                                   //> res14: scala.collection.immutable.Set[Int] = Set(1, 2, 3, 4)
  xs1 &~ ys1                                      //> res15: scala.collection.immutable.Set[Int] = Set(1, 2)
  xs1 diff ys1                                    //> res16: scala.collection.immutable.Set[Int] = Set(1, 2)

  // ********** mutable ***********
  // Additions:
  xs += 10                                        //> res17: ch24.Set1.xs.type = Set(1, 2, 3, 10, 4)
  xs += (10, 11, 12)                              //> res18: ch24.Set1.xs.type = Set(12, 1, 2, 3, 10, 4, 11)
  xs ++= ys1                                      //> res19: ch24.Set1.xs.type = Set(12, 1, 2, 3, 10, 4, 11)
  xs add 20                                       //> res20: Boolean = true
  xs                                              //> res21: scala.collection.mutable.Set[Int] = Set(12, 1, 2, 20, 3, 10, 4, 11)

  // Removals:
  xs -= 10                                        //> res22: ch24.Set1.xs.type = Set(12, 1, 2, 20, 3, 4, 11)
  xs -= (10, 11, 12)                              //> res23: ch24.Set1.xs.type = Set(1, 2, 20, 3, 4)
  xs --= ys1                                      //> res24: ch24.Set1.xs.type = Set(1, 2, 20)
  xs remove 10                                    //> res25: Boolean = false
  xs retain fSmall
  xs                                              //> res26: scala.collection.mutable.Set[Int] = Set(1, 2)
  xs.clear()
  xs                                              //> res27: scala.collection.mutable.Set[Int] = Set()

  // Update:
  xs(1) = true
  xs                                              //> res28: scala.collection.mutable.Set[Int] = Set(1)
  xs.update(2, true)
  xs                                              //> res29: scala.collection.mutable.Set[Int] = Set(1, 2)

  // Cloning:
  xs.clone                                        //> res30: scala.collection.mutable.Set[Int] = Set(1, 2)
}