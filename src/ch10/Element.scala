package ch10

import scala.math.Ordering

abstract class Element {
  def contents: Array[String]
  def height: Int = contents.length
  def width: Int = contents.maxBy(_.length) length
}

class ArrayElement(conts: Array[String]) extends Element {
  def contents = conts
}

class ArrayElement2(val contents: Array[String]) extends Element

object Element {
  def elem(s: String) = new ArrayElement(Array(s))
  def elem(conts: Array[String]) = new ArrayElement(conts)
}

