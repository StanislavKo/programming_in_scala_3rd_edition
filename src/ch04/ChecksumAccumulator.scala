package ch04

import scala.collection.mutable

class ChecksumAccumulator {
  private var sum = 0

  def add(b: Byte): Unit = {
    sum += b
  }
  def add2(b: Byte): Unit = sum += b
  def add3(b: Byte) = sum += b

  def checksum(): Int = {
    return ~(sum & 0xFF)
  }
  def checksum2(): Int = {
    ~(sum & 0xFF)
  }
  def checksum3(): Int = ~(sum & 0xFF)
  def checksum4() = ~(sum & 0xFF)
}

object ChecksumAccumulator {
  private val cache = mutable.Map[String, Int]() //> cache  : scala.collection.mutable.Map[String,Int] = Map()

  def calculate(s: String): Int = {
    if (cache.contains(s))
      cache(s)
    else {
      val acc = new ChecksumAccumulator
      for (c <- s)
        acc.add(c.toByte)
      cache += (s -> acc.checksum())
      acc.checksum()
    }
  } //> calculate: (s: String)Int
}

