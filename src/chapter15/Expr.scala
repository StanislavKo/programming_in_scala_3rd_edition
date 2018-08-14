package chapter15

abstract class Expr
case class Var(name: String) extends Expr
case class Number(num: Double) extends Expr
case class UnOp(op: String, arg: Expr) extends Expr
case class BinOp(op: String, left: Expr, right: Expr) extends Expr

object Expr {
  def simplifyTop(expr: Expr): Expr = expr match {
    case UnOp("-", UnOp("-", e))  => e
    case BinOp("+", e, Number(0)) => e
    case BinOp("*", e, Number(1)) => e
    case _                        => expr
  } //> simplifyTop: (expr: chapter15.Expr)chapter15.Expr
  
}

