package ch19

class Queue1[T] private (private val leading: List[T], private val trailing: List[T])

object Queue1 {
  def apply[T](xs: T*) = new Queue1[T](xs.toList, Nil)
                                                  //> apply: [T](xs: T*)ch19.Queue1[T]
}

trait Queue2[T] {
  def head: T
  def tail: Queue2[T]
  def enqueue(x: T): Queue2[T]
}
object Queue2 {
  def apply[T](xs: T*): Queue2[T] =
    new QueueImpl[T](xs.toList, Nil)
  private class QueueImpl[T](
    private val leading:  List[T],
    private val trailing: List[T]) extends Queue2[T] {
    def mirror =
      if (leading.isEmpty)
        new QueueImpl(trailing.reverse, Nil)
      else
        this
    def head: T = mirror.leading.head
    def tail: QueueImpl[T] = {
      val q = mirror
      new QueueImpl(q.leading.tail, q.trailing)
    }
    def enqueue(x: T) =
      new QueueImpl(leading, x :: trailing)
  }
}

trait Queue3[+T] {}
trait Queue4[-T] {}

class Queue5[+T](
  private val leading:  List[T],
  private val trailing: List[T]) {
  def enqueue[U >: T](x: U) = new Queue5[U](leading, x :: trailing) // ...
}

trait Function1[-S, +T] {
  def apply(x: S): T
}



object ch19 {
  println("Welcome to the Scala worksheet")

  def doesCompile(q: Queue2[AnyRef]) = {}
}