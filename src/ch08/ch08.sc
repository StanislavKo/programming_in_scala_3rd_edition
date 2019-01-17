package ch08

class Member(val args: Array[String], width: Int) {
  private def processFile(filename: String) = {
    val file = scala.io.Source.fromFile(filename)
    for (line <- file.getLines()) {
      if (line.length > width) {
        println(s"$filename : $line.trim")
      }
    }
  }

  def processFiles() = {
    for (filename <- args) {
      processFile(filename)
    }
  }
}

class Member2() {
  private def processFile(filename: String, width: Int) = {
    val file = scala.io.Source.fromFile(filename)
    for (line <- file.getLines()) {
      if (line.length > width) {
        println(s"$filename : $line.trim")
      }
    }
  }

  def processFiles(args: Array[String], width: Int) = {
    for (filename <- args) {
      processFile(filename, width)
    }
  }
}

class LocalFunction() {
  def processFiles(args: Array[String], width: Int) = {
    def processFile(filename: String) = {
      val file = scala.io.Source.fromFile(filename)
      for (line <- file.getLines()) {
        if (line.length > width) {
          println(s"$filename : $line.trim")
        }
      }
    }

    for (filename <- args) {
      processFile(filename)
    }
  }
}

object ch08 {
  println("Welcome to the Scala worksheet")       //> Welcome to the Scala worksheet
  val args = Array("140", "g:\\task_planner.txt.txt", "g:\\traces.txt")
                                                  //> args  : Array[String] = Array(140, g:\task_planner.txt.txt, g:\traces.txt)
                                                  //| 
  val width = args(0).toInt                       //> width  : Int = 140
  val filenames = args.tail                       //> filenames  : Array[String] = Array(g:\task_planner.txt.txt, g:\traces.txt)
                                                  //| 
  new Member(filenames, width).processFiles()     //> g:\traces.txt :   at com.google.android.finsky.receivers.PackageMonitorRece
                                                  //| iver$ReferrerRebroadcaster.broadcastInstallReferrer(PackageMonitorReceiver.
                                                  //| java:236).trim
  new Member2().processFiles(filenames, width)    //> g:\traces.txt :   at com.google.android.finsky.receivers.PackageMonitorRece
                                                  //| iver$ReferrerRebroadcaster.broadcastInstallReferrer(PackageMonitorReceiver.
                                                  //| java:236).trim

  new LocalFunction().processFiles(filenames, width)
                                                  //> g:\traces.txt :   at com.google.android.finsky.receivers.PackageMonitorRece
                                                  //| iver$ReferrerRebroadcaster.broadcastInstallReferrer(PackageMonitorReceiver.
                                                  //| java:236).trim
  val numbers = Array(0, 1, 2, 10)                //> numbers  : Array[Int] = Array(0, 1, 2, 10)
  numbers.filter((x: Int) => x > 5)               //> res0: Array[Int] = Array(10)
  numbers.filter((x) => x > 5)                    //> res1: Array[Int] = Array(10)
  numbers.filter(x => x > 5)                      //> res2: Array[Int] = Array(10)
  numbers.filter(_ > 5)                           //> res3: Array[Int] = Array(10)
  numbers.foreach(print _)                        //> 01210
  numbers.foreach(print)                          //> 01210

  def sum(a: Int, b: Int, c: Int = 3) = a + b + c //> sum: (a: Int, b: Int, c: Int)Int
  val a1 = sum _                                  //> a1  : (Int, Int, Int) => Int = ch08.ch08$$$Lambda$29/310656974@3dd3bcd
  sum(1, 2, 3)                                    //> res4: Int = 6
  a1(1, 2, 3)                                     //> res5: Int = 6
  a1.apply(1, 2, 3)                               //> res6: Int = 6
  val a2 = sum(1, _: Int, 3)                      //> a2  : Int => Int = ch08.ch08$$$Lambda$30/2136344592@69d9c55
  a2(2)                                           //> res7: Int = 6

  def repeat(args: String*) = { args.foreach(println) }
                                                  //> repeat: (args: String*)Unit
  repeat("1", "2")                                //> 1
                                                  //| 2
  sum(c = 3, b = 2, a = 1)                        //> res8: Int = 6
  sum(1, 2)                                       //> res9: Int = 6

  def boom(x: Int): Int = {
    if (x <= 0) throw new Exception("boom exception")
    else boom(x - 1)
  }                                               //> boom: (x: Int)Int
  boom(3)                                         //> java.lang.Exception: boom exception
                                                  //| 	at ch08.ch08$.boom$1(ch08.ch08.scala:85)
                                                  //| 	at ch08.ch08$.$anonfun$main$1(ch08.ch08.scala:88)
                                                  //| 	at org.scalaide.worksheet.runtime.library.WorksheetSupport$.$anonfun$$ex
                                                  //| ecute$1(WorksheetSupport.scala:76)
                                                  //| 	at org.scalaide.worksheet.runtime.library.WorksheetSupport$.redirected(W
                                                  //| orksheetSupport.scala:65)
                                                  //| 	at org.scalaide.worksheet.runtime.library.WorksheetSupport$.$execute(Wor
                                                  //| ksheetSupport.scala:76)
                                                  //| 	at ch08.ch08$.main(ch08.ch08.scala:54)
                                                  //| 	at ch08.ch08.main(ch08.ch08.scala)
}