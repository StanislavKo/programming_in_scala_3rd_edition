package ch07

import java.io.File
import scala.io.Source
import java.io.FileNotFoundException
import java.io.FileReader
import scala.util.control.Breaks._
import java.io.InputStreamReader
import java.io.BufferedReader

object ch07 {
  println("Welcome to the Scala worksheet")       //> Welcome to the Scala worksheet
  def main(args: Array[String]): Unit = {
    val filename = if (!args.isEmpty) args(0) else "default.txt"
  }                                               //> main: (args: Array[String])Unit
  main(List("asdf.txt").toArray)
  () == main(Array[String]())                     //> res0: Boolean = true

  def fileLines(file: File, enc: String) = {
    scala.io.Source.fromFile(file, enc).getLines()
  }                                               //> fileLines: (file: java.io.File, enc: String)Iterator[String]

  val files = new File("g:\\temp").listFiles      //> files  : Array[java.io.File] = Array(g:\temp\01ffmpeg, g:\temp\08_18, g:\tem
                                                  //| p\1.xt, g:\temp\10, g:\temp\12, g:\temp\14, g:\temp\15, g:\temp\2, g:\temp\2
                                                  //| .txt, g:\temp\222, g:\temp\3, g:\temp\4, g:\temp\9, g:\temp\android, g:\temp
                                                  //| \android-files, g:\temp\apk, g:\temp\Database.db.zip, g:\temp\DatabaseJob.kd
                                                  //| b, g:\temp\dblook.log, g:\temp\derby.log, g:\temp\easy-rsa, g:\temp\executab
                                                  //| les, g:\temp\html, g:\temp\JEE_Test_JSF.war, g:\temp\KEYPASS.DAT, g:\temp\lo
                                                  //| g.txt, g:\temp\log1.txt, g:\temp\log2.txt, g:\temp\log4.txt, g:\temp\logAll.
                                                  //| txt, g:\temp\n360_5_retail_ug.pdf, g:\temp\nix-РґРѕСЃСѓРґРµР±РЅРѕРµ-РїРёСЃСЊ
                                                  //| РјРѕ - РєРѕРїРёСЏ=.txt, g:\temp\nix-РґРѕСЃСѓРґРµР±РЅРѕРµ-РїРёСЃСЊРјРѕ.txt, g
                                                  //| :\temp\rootsupd.exe, g:\temp\run_derby_ij.bat, g:\temp\svn_apps, g:\temp\svn
                                                  //| _libs, g:\temp\temp-classloader.txt, g:\temp\temp.txt, g:\temp\test.wpl, g:\
                                                  //| temp\tomcat.jks, g:\temp\virtualbox_share, g:\temp\vpn, g:\temp\WebServiceTe
                                                  //| st_01.zip, g:\temp\wget,
                                                  //| Output exceeds cutoff limit.
  val logs = for { file <- files; if (file.getName.endsWith(".log")) } yield file
                                                  //> logs  : Array[java.io.File] = Array(g:\temp\dblook.log, g:\temp\derby.log)
  var count = 0l;                                 //> count  : Long = 0
  for {
    file <- files
    if file.getName.endsWith(".xt")
    line <- fileLines(file, "ISO-8859-1")
  } count += 1
  println(count)                                  //> 2382

  def method01() = {
    try {
      val fr = new FileReader("g:\\asdf123.txt")
      fr.skip(1)
      fr.close()
      val i = 1 / 0
    } catch {
      case ex: FileNotFoundException => println("FileNFE")
      case ex: Exception             => println("Exception")
    }
  }                                               //> method01: ()Unit
  method01()                                      //> FileNFE

  def method02(args: Array[String]) = {
    val arg0 = if (args.length > 0) args(0) else ""
    println(arg0 match {
      case "salt"  => "pepper"
      case "chips" => "salsa"
      case _       => "huh?"
    })
  }                                               //> method02: (args: Array[String])Unit
  method02(Array(""))                             //> huh?
  method02(Array("salt"))                         //> pepper

  val in = new BufferedReader(new InputStreamReader(System.in))
                                                  //> in  : java.io.BufferedReader = java.io.BufferedReader@52af6cff
  breakable {
    var i = 1
    while (i < 10) {
      if (i >= 3) break
      println(s"$i")
      i += 1
    }
  }                                               //> 1
                                                  //| 2

  for (i <- 1 to 10) {
    breakable {
      if (i >= 3) break
      println(s"$i")
    }                                             //> 1
                                                  //| 2
  }

  def makeColumn(row: Int, col: Int) = {
    val prod = col * row
    print(f"${prod}%3d|")
  }                                               //> makeColumn: (row: Int, col: Int)Unit

  def makeRow(row: Int) = {
    print("|")
    for (col <- 1 to 10)
      yield makeColumn(row, col)
    println
  }                                               //> makeRow: (row: Int)Unit

  def makeTable() = {
    for (row <- 1 to 10)
      yield makeRow(row)
  }                                               //> makeTable: ()scala.collection.immutable.IndexedSeq[Unit]

  makeTable                                       //> |  1|  2|  3|  4|  5|  6|  7|  8|  9| 10|
                                                  //| |  2|  4|  6|  8| 10| 12| 14| 16| 18| 20|
                                                  //| |  3|  6|  9| 12| 15| 18| 21| 24| 27| 30|
                                                  //| |  4|  8| 12| 16| 20| 24| 28| 32| 36| 40|
                                                  //| |  5| 10| 15| 20| 25| 30| 35| 40| 45| 50|
                                                  //| |  6| 12| 18| 24| 30| 36| 42| 48| 54| 60|
                                                  //| |  7| 14| 21| 28| 35| 42| 49| 56| 63| 70|
                                                  //| |  8| 16| 24| 32| 40| 48| 56| 64| 72| 80|
                                                  //| |  9| 18| 27| 36| 45| 54| 63| 72| 81| 90|
                                                  //| | 10| 20| 30| 40| 50| 60| 70| 80| 90|100|
                                                  //| res1: scala.collection.immutable.IndexedSeq[Unit] = Vector((), (), (), (), 
                                                  //| (), (), (), (), (), ())
}