package ch12

import scala.collection.mutable.ArrayBuffer

class BasicIntQueue extends IntQueue {
  private val buf = new ArrayBuffer[Int]
  def get: Int = buf.remove(0)
  def put(value: Int) = buf += value
}