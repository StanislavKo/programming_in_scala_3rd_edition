package chapter10

import chapter10._

object chapter10 {
  println("Welcome to the Scala worksheet")       //> Welcome to the Scala worksheet
  val elem1: Element  = new ArrayElement(Array("hello", "world"))
                                                  //> elem1  : chapter10.Element = chapter10.ArrayElement@6a5fc7f7
  println(elem1.width)                            //> 5
}