package chapter08

object TailRecursion {
  def boom(x: Int): Int =
    if (x == 0) throw new Exception("boom!")
    else boom(x - 1) + 1
  def boomTailRecursion(x: Int): Int =
    if (x == 0) throw new Exception("boom!")
    else boomTailRecursion(x - 1)
}