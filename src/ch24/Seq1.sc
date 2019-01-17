package ch24

case class Obj(id: Int, name: String)

object Seq1 {
  println("Welcome to the Scala worksheet")       //> Welcome to the Scala worksheet
  val xs = Seq(1, 2, 3, 4, 5, 6, 7, 8)            //> xs  : Seq[Int] = List(1, 2, 3, 4, 5, 6, 7, 8)
  val ys = Seq("a", "b", "c", "d")                //> ys  : Seq[String] = List(a, b, c, d)
  val xs2 = List(4, 5)                            //> xs2  : List[Int] = List(4, 5)
  val xsObj = List(Obj(1, "One"), Obj(2, "Two"), Obj(3, "Three"))
                                                  //> xsObj  : List[ch24.Obj] = List(Obj(1,One), Obj(2,Two), Obj(3,Three))
  val fEven: Int => Boolean = { x => x % 2 == 0 } //> fEven  : Int => Boolean = ch24.Seq1$$$Lambda$11/3447021@1a407d53
  val fOdd: Int => Boolean = { x => x % 2 == 1 }  //> fOdd  : Int => Boolean = ch24.Seq1$$$Lambda$12/1032616650@5ebec15
  val fLessThan: ((Int, Int) => Boolean) = _ > _  //> fLessThan  : (Int, Int) => Boolean = ch24.Seq1$$$Lambda$13/2052915500@3fb6a4
                                                  //| 47

  // Indexing and length:
  xs(2)                                           //> res0: Int = 3
  xs isDefinedAt 10                               //> res1: Boolean = false
  xs.length                                       //> res2: Int = 8
  xs lengthCompare 3                              //> res3: Int = 1
  xs.indices                                      //> res4: scala.collection.immutable.Range = Range 0 until 8

  // Index search:
  xs indexOf 4                                    //> res5: Int = 3
  xs lastIndexOf 4                                //> res6: Int = 3
  xs indexOfSlice xs2                             //> res7: Int = 3
  xs lastIndexOfSlice xs2                         //> res8: Int = 3
  xs indexWhere fEven                             //> res9: Int = 1
  xs segmentLength (fEven, 3)                     //> res10: Int = 1
  xs segmentLength (fEven, 4)                     //> res11: Int = 0
  xs prefixLength fEven                           //> res12: Int = 0
  xs prefixLength fOdd                            //> res13: Int = 1

  // Additions:
  1 +: xs                                         //> res14: Seq[Int] = List(1, 1, 2, 3, 4, 5, 6, 7, 8)
  xs :+ 1                                         //> res15: Seq[Int] = List(1, 2, 3, 4, 5, 6, 7, 8, 1)
  xs padTo (10, 1)                                //> res16: Seq[Int] = List(1, 2, 3, 4, 5, 6, 7, 8, 1, 1)

  // Updates:
  xs patch (1, ys, 2)                             //> res17: Seq[Any] = List(1, a, b, c, d, 4, 5, 6, 7, 8)
  // patch -> 2 doesn't change anything
  xs updated (1, 10)                              //> res18: Seq[Int] = List(1, 10, 3, 4, 5, 6, 7, 8)
  //  xs(1) = 10

  // Sorting:
  xs.sorted                                       //> res19: Seq[Int] = List(1, 2, 3, 4, 5, 6, 7, 8)
  xs sortWith fLessThan                           //> res20: Seq[Int] = List(8, 7, 6, 5, 4, 3, 2, 1)
  // xs.sortBy[Int](_)
  // xs.sortBy[Int](Int => Int = {x => x + 1})
  xsObj.sortBy(_.id)(scala.math.Ordering[Int].reverse)
                                                  //> res21: List[ch24.Obj] = List(Obj(3,Three), Obj(2,Two), Obj(1,One))

  // Reversals:
	xs.reverse                                //> res22: Seq[Int] = List(8, 7, 6, 5, 4, 3, 2, 1)
	xs.reverseIterator                        //> res23: Iterator[Int] = non-empty iterator
	xsObj.reverseMap(_.id)                    //> res24: List[Int] = List(3, 2, 1)
	
	// Comparisons:
	xs startsWith xs2                         //> res25: Boolean = false
	xs endsWith xs2                           //> res26: Boolean = false
	xs contains 4                             //> res27: Boolean = true
	xs containsSlice xs2                      //> res28: Boolean = true
	(xs corresponds ys)(_ > 2 && _ == "d")    //> res29: Boolean = false
	
	// Multiset operations:
	xs intersect xs2                          //> res30: Seq[Int] = List(4, 5)
	xs diff xs2                               //> res31: Seq[Int] = List(1, 2, 3, 6, 7, 8)
	xs union xs2                              //> res32: Seq[Int] = List(1, 2, 3, 4, 5, 6, 7, 8, 4, 5)
	xs.distinct                               //> res33: Seq[Int] = List(1, 2, 3, 4, 5, 6, 7, 8)
}