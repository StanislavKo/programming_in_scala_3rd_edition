package ch20

trait Abstract {
  type T
  def transform(x: T): T
  val initial: T
  var current: T
}

class Concrete extends Abstract {
  type T = String
  def transform(x: T): T = x + x
  val initial = "hi"
  var current = initial
}

// def -> val in sub-classes
abstract class Fruit {
  val v: String
  def m: String
}

abstract class Apple extends Fruit {
  val v: String
  val m: String // val now (not def like in Fruit)
}

// initialization of abstract val
trait RationalTrait {
  val numerArg: Int
  val denomArg: Int
  require(denomArg != 0)
}

class Food
abstract class Animal {
  type SuitableFood <: Food
  def eat(food: SuitableFood)
}
class Grass extends Food
class Cow extends Animal {
	type SuitableFood = Grass
	override def eat(food: Grass) = {}
}

object ch20 {
  println("Welcome to the Scala worksheet")       //> Welcome to the Scala worksheet

  try {
    new RationalTrait {
      val numerArg = 1
      val denomArg = 2
    }
  } catch {
    case ex: IllegalArgumentException => println(ex.getMessage)
  }                                               //> requirement failed
                                                  //| res0: Any = ()
  new {
    val numerArg = 1
    val denomArg = 2
  } with RationalTrait                            //> res1: ch20.RationalTrait{} = ch20.ch20$$anon$2@2f7c7260

  object TwoThirds extends {
    val numerArg = 1
    val denomArg = 2
  } with RationalTrait

  object DemoLazy {
    lazy val x = { println("initializing x"); "done" }
  }
  DemoLazy                                        //> res2: ch20.ch20.DemoLazy.type = ch20.ch20$DemoLazy$2$@2d209079
  DemoLazy.x                                      //> initializing x
                                                  //| res3: String = done
  DemoLazy.x                                      //> res4: String = done
}