package ch18

class Time {
	var h: Int = _
	var m: Int = _
	override def toString() = s"$h:$m"
}

object ch18 {
  println("Welcome to the Scala worksheet")       //> Welcome to the Scala worksheet
  var time = new Time                             //> time  : ch18.Time = 0:0
  time.h_=(12)
  time                                            //> res0: ch18.Time = 12:0
}