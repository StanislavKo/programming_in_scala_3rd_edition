package chapter8

object chapter8 {
  println("Welcome to the Scala worksheet")       //> Welcome to the Scala worksheet
  LongLines.processFile("g:\\temp\\14\\com.google.android.gcm.xml", 50)
                                                  //> 56 : <?xml version='1.0' encoding='utf-8' standalone='yes' ?>
                                                  //| 149 : <string name="regId">APA91bF14d9OVHAcprYbVbpU9eBhtNZDOPNwT_Z32GnI5bAn4
                                                  //| hw8AV8aAMZJ2Ay2lZc9IRe1u1Xhzq70eYn_1k98EWkAhwexHHbl11odzPLIQobFkjtZjXU</stri
                                                  //| ng>
  LongLines_LocalFunction.processFile("g:\\temp\\14\\com.google.android.gcm.xml", 50)
                                                  //> 56 : <?xml version='1.0' encoding='utf-8' standalone='yes' ?>
                                                  //| 149 : <string name="regId">APA91bF14d9OVHAcprYbVbpU9eBhtNZDOPNwT_Z32GnI5bAn4
                                                  //| hw8AV8aAMZJ2Ay2lZc9IRe1u1Xhzq70eYn_1k98EWkAhwexHHbl11odzPLIQobFkjtZjXU</stri
                                                  //| ng>

  LongLines_FunctionLiteral.processFile("g:\\temp\\14\\com.google.android.gcm.xml", 50)
                                                  //> 56 : <?xml version='1.0' encoding='utf-8' standalone='yes' ?>
                                                  //| 149 : <string name="regId">APA91bF14d9OVHAcprYbVbpU9eBhtNZDOPNwT_Z32GnI5bAn4
                                                  //| hw8AV8aAMZJ2Ay2lZc9IRe1u1Xhzq70eYn_1k98EWkAhwexHHbl11odzPLIQobFkjtZjXU</stri
                                                  //| ng>

  val list = List(-11, -10, -5, 0, 5, 10)         //> list  : List[Int] = List(-11, -10, -5, 0, 5, 10)
  list.filter(x => x > 0)                         //> res0: List[Int] = List(5, 10)
  list.filter(_ > 0)                              //> res1: List[Int] = List(5, 10)
  val list2 = List(5, 10)                         //> list2  : List[Int] = List(5, 10)
  list2.foreach { println _ }                     //> 5
                                                  //| 10
  list2.foreach { println }                       //> 5
                                                  //| 10

  def sum(x: Int, y: Int) = x + y                 //> sum: (x: Int, y: Int)Int
  val a = sum(5, _: Int)                          //> a  : Int => Int = <function1>
  a(10)                                           //> res2: Int = 15
  SpecialFunction.asterisk(5, 10, 11)             //> 5
                                                  //| 10
                                                  //| 11
  SpecialFunction.namedSubtraction(y = 5, x = 10) //> res3: Int = 5
  SpecialFunction.deafultTime()                   //> 1484253270
  SpecialFunction.deafultTime(1)                  //> 1484253270730
  try {
    TailRecursion.boom(4)
  } catch {
    case e: Exception => e.printStackTrace()
  }                                               //> java.lang.Exception: boom!
                                                  //| 	at chapter8.TailRecursion$.boom(TailRecursion.scala:5)
                                                  //| 	at chapter8.TailRecursion$.boom(TailRecursion.scala:6)
                                                  //| 	at chapter8.TailRecursion$.boom(TailRecursion.scala:6)
                                                  //| 	at chapter8.TailRecursion$.boom(TailRecursion.scala:6)
                                                  //| 	at chapter8.TailRecursion$.boom(TailRecursion.scala:6)
                                                  //| 	at chapter8.chapter8$$anonfun$main$1.apply$mcV$sp(chapter8.chapter8.scal
                                                  //| a:25)
                                                  //| 	at org.scalaide.worksheet.runtime.library.WorksheetSupport$$anonfun$$exe
                                                  //| cute$1.apply$mcV$sp(WorksheetSupport.scala:76)
                                                  //| 	at org.scalaide.worksheet.runtime.library.WorksheetSupport$.redirected(W
                                                  //| orksheetSupport.scala:65)
                                                  //| 	at org.scalaide.worksheet.runtime.library.WorksheetSupport$.$execute(Wor
                                                  //| ksheetSupport.scala:75)
                                                  //| 	at chapter8.chapter8$.main(chapter8.chapter8.scala:3)
                                                  //| 	at chapter8.chapter8.main(chapter8.chapter8.scala)
                                                  //| res4: AnyVal = ()
  try {
     TailRecursion.boomTailRecursion(4)
  } catch {
    case e: Exception => e.printStackTrace()
  }                                               //> java.lang.Exception: boom!
                                                  //| 	at chapter8.TailRecursion$.boomTailRecursion(TailRecursion.scala:8)
                                                  //| 	at chapter8.chapter8$$anonfun$main$1.apply$mcV$sp(chapter8.chapter8.scal
                                                  //| a:30)
                                                  //| 	at org.scalaide.worksheet.runtime.library.WorksheetSupport$$anonfun$$exe
                                                  //| cute$1.apply$mcV$sp(WorksheetSupport.scala:76)
                                                  //| 	at org.scalaide.worksheet.runtime.library.WorksheetSupport$.redirected(W
                                                  //| orksheetSupport.scala:65)
                                                  //| 	at org.scalaide.worksheet.runtime.library.WorksheetSupport$.$execute(Wor
                                                  //| ksheetSupport.scala:75)
                                                  //| 	at chapter8.chapter8$.main(chapter8.chapter8.scala:3)
                                                  //| 	at chapter8.chapter8.main(chapter8.chapter8.scala)
                                                  //| res5: AnyVal = ()
}