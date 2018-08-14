package chapter12

class Point(val x: Int, val y: Int)
class Rectangle(val topLeft: Point, val bottomRight: Point) {
	def left = topLeft.x
	def right = bottomRight.x
	def width = right - left
	override def toString = "[width:" + width + "]"
}

object chapter12 {
  println("Welcome to the Scala worksheet")       //> Welcome to the Scala worksheet
  val r1: Rectangle = new Rectangle(new Point(1,2), new Point(4, 5))
                                                  //> r1  : chapter12.Rectangle = [width:3]
}