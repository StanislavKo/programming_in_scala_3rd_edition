package ch12

trait Doubling extends IntQueue {
  abstract override def put(value: Int) = super.put(value * 2)
}