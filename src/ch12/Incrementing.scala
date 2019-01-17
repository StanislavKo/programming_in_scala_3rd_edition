package ch12

trait Incrementing extends IntQueue {
  abstract override def put(value: Int) = super.put(value + 1)
}