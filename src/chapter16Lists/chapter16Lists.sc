package chapter16

object chapter16Lists {
  println("Welcome to the Scala worksheet")       //> Welcome to the Scala worksheet
  val array1 = List(1, 2, 3)                      //> array1  : List[Int] = List(1, 2, 3)
  val array2 = List("1", "2", "3")                //> array2  : List[String] = List(1, 2, 3)
  val array3 = 1 :: (2 :: (3 :: Nil))             //> array3  : List[Int] = List(1, 2, 3)
  array1 == array3                                //> res0: Boolean = true

  def isort01(xs: List[Int]): List[Int] = {
    if (xs.isEmpty) Nil
    else {
      insert01(xs.head, isort01(xs.tail))
    }
  }                                               //> isort01: (xs: List[Int])List[Int]
  def insert01(x: Int, xs: List[Int]): List[Int] = {
    if (xs.isEmpty || x < xs.head) x :: xs
    else xs.head :: insert01(x, xs.tail)
  }                                               //> insert01: (x: Int, xs: List[Int])List[Int]
  val array4 = List(5, 4, 3, 2, 1)                //> array4  : List[Int] = List(5, 4, 3, 2, 1)
  isort01(array4)                                 //> res1: List[Int] = List(1, 2, 3, 4, 5)

  def isort02(xs: List[Int]): List[Int] = xs match {
    case Nil     => Nil
    case x :: xs => insert02(x, isort02(xs))
  }                                               //> isort02: (xs: List[Int])List[Int]
  def insert02(x: Int, xs: List[Int]): List[Int] = xs match {
    case Nil     => x :: xs
    case y :: ys => if (x < y) x :: xs else y :: insert02(x, ys)
  }                                               //> insert02: (x: Int, xs: List[Int])List[Int]
  isort02(array4)                                 //> res2: List[Int] = List(1, 2, 3, 4, 5)

  def append[T](xs: List[T], ys: List[T]): List[T] = xs match {
    case Nil      => ys
    case x :: xs1 => x :: append(xs1, ys)
  }                                               //> append: [T](xs: List[T], ys: List[T])List[T]
  append(array1, array4)                          //> res3: List[Int] = List(1, 2, 3, 5, 4, 3, 2, 1)

  def reverseConcat[T](xs: List[T]): List[T] = xs match {
    case Nil     => xs
    case x :: ys => reverseConcat(ys) ::: List(x)
  }                                               //> reverseConcat: [T](xs: List[T])List[T]
  reverseConcat(array1)                           //> res4: List[Int] = List(3, 2, 1)

  array1.mkString(",")                            //> res5: String = 1,2,3
  array1.mkString                                 //> res6: String = 123

  def msort[T](less: (T, T) => Boolean)(xs: List[T]): List[T] = {
    def merge(xs: List[T], ys: List[T]): List[T] = {
      (xs, ys) match {
        case (Nil, _) => ys
        case (_, Nil) => xs
        case (x :: xs1, y :: ys1) =>
          if (less(x, y)) x :: merge(xs1, ys)
          else y :: merge(xs, ys1)
      }
    }

    val n = xs.length / 2
    if (n == 0) xs
    else {
      val (ys, zs) = xs splitAt n
      merge(msort(less)(ys), msort(less)(zs))
    }
  }                                               //> msort: [T](less: (T, T) => Boolean)(xs: List[T])List[T]
  msort((x: Int, y: Int) => x < y)(array4)        //> res7: List[Int] = List(1, 2, 3, 4, 5)

  array4 map (_ + 1)                              //> res8: List[Int] = List(6, 5, 4, 3, 2)
  array4 flatMap { x => List(x + 1) }             //> res9: List[Int] = List(6, 5, 4, 3, 2)
  val array5 = List("the", "quick", "brown", "fox")
                                                  //> array5  : List[String] = List(the, quick, brown, fox)
  array5 flatMap { x => x.toList }                //> res10: List[Char] = List(t, h, e, q, u, i, c, k, b, r, o, w, n, f, o, x)
  List.range(1, 5) flatMap { i => List.range(1, i) map { j => (j, i) } }
                                                  //> res11: List[(Int, Int)] = List((1,2), (1,3), (2,3), (1,4), (2,4), (3,4))
  for (i <- List.range(1, 5); j <- List.range(1, i)) yield (j, i)
                                                  //> res12: List[(Int, Int)] = List((1,2), (1,3), (2,3), (1,4), (2,4), (3,4))

  var sum = 0                                     //> sum  : Int = 0
  array4.foreach(x => sum = x + sum)
  println(sum)                                    //> 15

  array4 filter (_ % 2 == 0)                      //> res13: List[Int] = List(4, 2)
  List(1, 2, 3, -4, 5, -2, 7, 8) takeWhile { _ > 0 }
                                                  //> res14: List[Int] = List(1, 2, 3)
  List(1, 2, 3, -4, 5, -2, 7, 8) dropWhile { _ > 0 }
                                                  //> res15: List[Int] = List(-4, 5, -2, 7, 8)
  List(1, 2, 3, -4, 5, -2, 7, 8) span (_ > 0)     //> res16: (List[Int], List[Int]) = (List(1, 2, 3),List(-4, 5, -2, 7, 8))
  def sumM(xs: List[Int]): Int = (0 /: xs)(_ + _) //> sumM: (xs: List[Int])Int
  sumM(array1)                                    //> res17: Int = 6

  def reverseLeft[T](xs: List[T]): List[T] = (List[T]() /: xs) { (ys, y) => y :: ys }
                                                  //> reverseLeft: [T](xs: List[T])List[T]
  reverseLeft(array1)                             //> res18: List[Int] = List(3, 2, 1)
}