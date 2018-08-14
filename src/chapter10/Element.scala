package chapter10

abstract class Element {
  def contents: Array[String]
  def height: Int = contents.length
  def width: Int = if (height == 0) 0 else contents(0).length()
}

class ArrayElement(val contents: Array[String]) extends Element {
}

class LineElement(s: String) extends ArrayElement(Array(s)) {
  override def height = 1
  override def width = s.length
}

class UniformElement(ch: Char, override val width: Int, override val height: Int) extends Element {
  private val line: String = ch.toString() * width
  def contents = Array.fill(height)(line)
}

object Element {
  def elem(contents: Array[String]) = new ArrayElement(contents)
  def elem(s: String) = new LineElement(s)
  def elem(ch: Char, width: Int, height: Int) = new UniformElement(ch, width, height)
}