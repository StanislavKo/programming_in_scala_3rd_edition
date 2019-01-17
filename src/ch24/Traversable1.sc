package ch24

import scala.collection.mutable.ListBuffer

object Traversable1 {
  println("Welcome to the Scala worksheet")       //> Welcome to the Scala worksheet
  val xs = List(1, 2, 3, 4)                       //> xs  : List[Int] = List(1, 2, 3, 4)
  val ys = List(11, 12, 13)                       //> ys  : List[Int] = List(11, 12, 13)
  val ss = List(xs, ys)                           //> ss  : List[List[Int]] = List(List(1, 2, 3, 4), List(11, 12, 13))
  val fUnit: Int => Unit = println _              //> fUnit  : Int => Unit = ch24.Traversable1$$$Lambda$11/905544614@7f690630
  val fEdit: Int => Int = _ + 1                   //> fEdit  : Int => Int = ch24.Traversable1$$$Lambda$12/357863579@6bf256fa
  val fEven: Int => Boolean = { x => x % 2 == 0 } //> fEven  : Int => Boolean = ch24.Traversable1$$$Lambda$13/1789550256@3498ed
  val fOdd: Int => Boolean = { x => x % 2 == 1 }  //> fOdd  : Int => Boolean = ch24.Traversable1$$$Lambda$14/440434003@3d8c7aca
  val fSum: ((Int, Int) => Int) = _ + _           //> fSum  : (Int, Int) => Int = ch24.Traversable1$$$Lambda$15/1020923989@7a5d012
                                                  //| c

  xs foreach fUnit                                //> 1
                                                  //| 2
                                                  //| 3
                                                  //| 4
  val xys = xs ++ ys                              //> xys  : List[Int] = List(1, 2, 3, 4, 11, 12, 13)
  xs map fEdit                                    //> res0: List[Int] = List(2, 3, 4, 5)
  ss flatMap { xs => xs }                         //> res1: List[Int] = List(1, 2, 3, 4, 11, 12, 13)
  val pf: PartialFunction[Int, String] = {
    case x if x % 2 == 0 => x + " is even"
  }                                               //> pf  : PartialFunction[Int,String] = <function1>
  xys collect pf                                  //> res2: List[String] = List(2 is even, 4 is even, 12 is even)

  // Conversions:
  xs.toArray                                      //> res3: Array[Int] = Array(1, 2, 3, 4)
  xs.toList                                       //> res4: List[Int] = List(1, 2, 3, 4)
  xs.toIterable                                   //> res5: Iterable[Int] = List(1, 2, 3, 4)
  xs.toSeq                                        //> res6: scala.collection.immutable.Seq[Int] = List(1, 2, 3, 4)
  xs.toIndexedSeq                                 //> res7: scala.collection.immutable.IndexedSeq[Int] = Vector(1, 2, 3, 4)
  xs.toStream                                     //> res8: scala.collection.immutable.Stream[Int] = Stream(1, ?)
  xs.toSet                                        //> res9: scala.collection.immutable.Set[Int] = Set(1, 2, 3, 4)
  // xs.toMap

  // Copying:
  val buf = ListBuffer[Int]()                     //> buf  : scala.collection.mutable.ListBuffer[Int] = ListBuffer()
  val arr = Array[Int](5, 6, 7)                   //> arr  : Array[Int] = Array(5, 6, 7)
  xs copyToBuffer buf
  buf                                             //> res10: scala.collection.mutable.ListBuffer[Int] = ListBuffer(1, 2, 3, 4)
  val start = 1; val len = 2                      //> start  : Int = 1
                                                  //| len  : Int = 2
  xs.copyToArray(arr, start, len)
  xs                                              //> res11: List[Int] = List(1, 2, 3, 4)
  arr                                             //> res12: Array[Int] = Array(5, 1, 2)

  // Size info
  xs.isEmpty                                      //> res13: Boolean = false
  xs.nonEmpty                                     //> res14: Boolean = true
  xs.size                                         //> res15: Int = 4
  xs.hasDefiniteSize                              //> res16: Boolean = true

  // Element retrieval:
  xs.head                                         //> res17: Int = 1
  xs.headOption                                   //> res18: Option[Int] = Some(1)
  xs.last                                         //> res19: Int = 4
  xs.lastOption                                   //> res20: Option[Int] = Some(4)
  xs find fEven                                   //> res21: Option[Int] = Some(2)

  // Subcollections:
  xs.tail                                         //> res22: List[Int] = List(2, 3, 4)
  xs.init                                         //> res23: List[Int] = List(1, 2, 3)
  xs slice (1, 3)                                 //> res24: List[Int] = List(2, 3)
  xs take 2                                       //> res25: List[Int] = List(1, 2)
  xs drop 2                                       //> res26: List[Int] = List(3, 4)
  xs takeWhile fOdd                               //> res27: List[Int] = List(1)
  xs dropWhile fOdd                               //> res28: List[Int] = List(2, 3, 4)
  xs filter fEven                                 //> res29: List[Int] = List(2, 4)
  xs withFilter fEven                             //> res30: scala.collection.generic.FilterMonadic[Int,List[Int]] = scala.collec
                                                  //| tion.TraversableLike$WithFilter@5056dfcb
  xs filterNot fEven                              //> res31: List[Int] = List(1, 3)

  // Subdivisions:
  xs splitAt 2                                    //> res32: (List[Int], List[Int]) = (List(1, 2),List(3, 4))
  xs span fOdd                                    //> res33: (List[Int], List[Int]) = (List(1),List(2, 3, 4))
  xs partition fEven                              //> res34: (List[Int], List[Int]) = (List(2, 4),List(1, 3))
  xs groupBy fEdit                                //> res35: scala.collection.immutable.Map[Int,List[Int]] = Map(2 -> List(1), 5 
                                                  //| -> List(4), 4 -> List(3), 3 -> List(2))

  // Element conditions
  xs forall fEven                                 //> res36: Boolean = false
  xs exists fEven                                 //> res37: Boolean = true
  xs count fEven                                  //> res38: Int = 2

  // Folds:
  val z = 1                                       //> z  : Int = 1
  (z /: xs)(fSum)                                 //> res39: Int = 11
  (xs :\ z)(fSum)                                 //> res40: Int = 11
  xs.foldLeft(z)(fSum)                            //> res41: Int = 11
  xs.foldRight(z)(fSum)                           //> res42: Int = 11
  xs reduceLeft fSum                              //> res43: Int = 10
  xs reduceRight fSum                             //> res44: Int = 10

  // Specific folds
  xs.sum                                          //> res45: Int = 10
  xs.product                                      //> res46: Int = 24
  xs.min                                          //> res47: Int = 1
  xs.max                                          //> res48: Int = 4

  // Strings:
  val sb = new StringBuilder                      //> sb  : StringBuilder = 
  xs addString (sb, "<", "-", ">")                //> res49: StringBuilder = <1-2-3-4>
  sb                                              //> res50: StringBuilder = <1-2-3-4>
  xs mkString ("<", "-", ">")                     //> res51: String = <1-2-3-4>
  xs.toString()                                   //> res52: String = List(1, 2, 3, 4)
  xs.stringPrefix                                 //> res53: String = List

  // Views:
  xs.view                                         //> res54: scala.collection.SeqView[Int,List[Int]] = SeqView(...)
  xs view (1, 2)                                  //> res55: scala.collection.SeqView[Int,List[Int]] = SeqViewS(...)
}