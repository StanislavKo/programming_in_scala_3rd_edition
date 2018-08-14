package chapter06

class Rational(x: Int, y: Int) {
  require(y != 0)
  private val gcdValue: Int = gcd(x, y)
  val nom: Int = x / gcdValue
  val denom: Int = y / gcdValue

  def this(n: Int) = this(n, 1)

  def +(that: Rational): Rational = new Rational(nom * that.denom + that.nom * denom, denom * that.denom)
  def *(that: Rational): Rational = new Rational(nom * that.nom, denom * that.denom)
  def /(factor: Int): Rational = new Rational(nom, denom + factor)
  def <(that: Rational): Boolean = nom * that.denom < that.nom * denom

  def *(x: Int): Rational = new Rational(this.nom * x, this.denom)
  //def *:(x: Int): Rational = new Rational(this.nom * x, this.denom)

  def max(that: Rational): Rational =
    if (this < that)
      that
    else
      this

  private def gcd(a: Int, b: Int): Int =
    if (b == 0) a else gcd(b, a % b)

  override def toString = nom + "/" + denom
}