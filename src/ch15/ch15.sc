package ch15

object ch15 {
  println("Welcome to the Scala worksheet")       //> Welcome to the Scala worksheet
  val v = Var("x")                                //> v  : ch15.Var = Var(x)
  val op = BinOp("+", Number(4), v)               //> op  : ch15.BinOp = BinOp(+,Number(4.0),Var(x))
  v.name                                          //> res0: String = x

  def simplifyTop(expr: Expr): Expr = expr match {
    case UnOp("-", UnOp("-", e))  => e
    case BinOp("+", e, Number(0)) => e
    case BinOp("*", e, Number(1)) => e
    case _                        => expr
  }                                               //> simplifyTop: (expr: ch15.Expr)ch15.Expr
  simplifyTop(op)                                 //> res1: ch15.Expr = BinOp(+,Number(4.0),Var(x))
  simplifyTop(UnOp("-", UnOp("-", v)))            //> res2: ch15.Expr = Var(x)

  def tupleDemo(expr: Any) = expr match {
    case (a, b, c) => println("Tuple " + a + b + c)
    case s: String => println(s.length)
    case _         => expr
  }                                               //> tupleDemo: (expr: Any)Any
  tupleDemo((1, 2, 3))                            //> Tuple 123
                                                  //| res3: Any = ()

  def simplifyAdd(expr: Expr) = expr match {
    case BinOp("+", x, y) if x == y => BinOp("*", x, Number(2))
    case _                          => expr
  }                                               //> simplifyAdd: (expr: ch15.Expr)ch15.Expr
  simplifyAdd(BinOp("+", v, v))                   //> res4: ch15.Expr = BinOp(*,Var(x),Number(2.0))

  val tuple = ("abc", 123)                        //> tuple  : (String, Int) = (abc,123)
  val (str, number) = tuple                       //> str  : String = abc
                                                  //| number  : Int = 123

  val binOp = BinOp("*", Number(5), Number(1))    //> binOp  : ch15.BinOp = BinOp(*,Number(5.0),Number(1.0))
  val BinOp(op2, left2, right2) = binOp           //> op2  : String = *
                                                  //| left2  : ch15.Expr = Number(5.0)
                                                  //| right2  : ch15.Expr = Number(1.0)

  val partialFunc: PartialFunction[List[Int], Int] = {
    case x :: y :: _ => y
  }                                               //> partialFunc  : PartialFunction[List[Int],Int] = <function1>
  partialFunc.isDefinedAt(List(1, 2, 3))          //> res5: Boolean = true
  partialFunc.isDefinedAt(List())                 //> res6: Boolean = false
}