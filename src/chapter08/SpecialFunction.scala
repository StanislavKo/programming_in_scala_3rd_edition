package chapter08

object SpecialFunction {
  def asterisk(args: Int*) = {
    args.foreach { println }
  }
  def namedSubtraction(x: Int, y: Int) = x - y
  def deafultTime(divisor: Int = 1000) = println(System.currentTimeMillis()/divisor)
}