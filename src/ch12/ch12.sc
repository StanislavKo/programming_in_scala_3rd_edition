package ch12

object ch12 {
  println("Welcome to the Scala worksheet")       //> Welcome to the Scala worksheet
  val d1 = new BasicIntQueue with Doubling        //> d1  : ch12.BasicIntQueue with ch12.Doubling = ch12.ch12$$anon$2@43a25848
  d1 put 10
  d1 get                                          //> res0: Int = 20
  val d2 = new BasicIntQueue with Doubling with Incrementing
                                                  //> d2  : ch12.BasicIntQueue with ch12.Doubling with ch12.Incrementing = ch12.ch
                                                  //| 12$$anon$1@30c7da1e
  d2 put 10
  d2 get                                          //> res1: Int = 22
}