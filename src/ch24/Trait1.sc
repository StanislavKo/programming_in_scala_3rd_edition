package ch24

object Trait1 {
  println("Welcome to the Scala worksheet")       //> Welcome to the Scala worksheet
  val xs = List(1, 2, 3, 4, 5, 6, 7, 8)           //> xs  : List[Int] = List(1, 2, 3, 4, 5, 6, 7, 8)

  // iterator
  val it1 = xs.iterator                           //> it1  : Iterator[Int] = non-empty iterator
  it1.next                                        //> res0: Int = 1
  it1.next                                        //> res1: Int = 2
  val it2 = xs grouped 3                          //> it2  : Iterator[List[Int]] = non-empty iterator
  it2.next                                        //> res2: List[Int] = List(1, 2, 3)
  it2.next                                        //> res3: List[Int] = List(4, 5, 6)
  val it3 = xs sliding 3                          //> it3  : Iterator[List[Int]] = non-empty iterator
  it3.next                                        //> res4: List[Int] = List(1, 2, 3)
  it3.next                                        //> res5: List[Int] = List(2, 3, 4)

  // Subcollections:
  xs takeRight 3                                  //> res6: List[Int] = List(6, 7, 8)
  xs dropRight 3                                  //> res7: List[Int] = List(1, 2, 3, 4, 5)

  // Zippers:
  val ys = List("a", "b", "c", "d")               //> ys  : List[String] = List(a, b, c, d)
  xs zip ys                                       //> res8: List[(Int, String)] = List((1,a), (2,b), (3,c), (4,d))
  xs zipAll (ys, 10, "y")                         //> res9: List[(Int, String)] = List((1,a), (2,b), (3,c), (4,d), (5,y), (6,y), (
                                                  //| 7,y), (8,y))
  xs.zipWithIndex                                 //> res10: List[(Int, Int)] = List((1,0), (2,1), (3,2), (4,3), (5,4), (6,5), (7,
                                                  //| 6), (8,7))

  // Comparison:
  xs sameElements ys                              //> res11: Boolean = false
}