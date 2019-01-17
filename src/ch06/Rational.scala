package ch06

class Rational(val numerator: Int, val denominator: Int) {

  require(denominator != 0)
  
  def this(i: Int) = this(i, 1)
  
  def +(r: Rational) = normalize(new Rational(r.numerator * this.denominator + this.numerator * r.denominator, commonDenominator(r, this)))

  def -(r: Rational) = normalize(new Rational(r.numerator * this.denominator - this.numerator * r.denominator, commonDenominator(r, this)))

  def *(r: Rational) = normalize(new Rational(r.numerator * this.numerator, this.denominator * r.denominator))

  def /(r: Rational) = normalize(new Rational(r.numerator * this.denominator, this.numerator * r.denominator))

  def +(i: Int) = normalize(new Rational(i * this.denominator + this.numerator * 1, this.denominator))

  def -(i: Int) = normalize(new Rational(i * this.denominator - this.numerator * 1, this.denominator))

  def *(i: Int) = normalize(new Rational(i * this.numerator, this.denominator * 1))

  def /(i: Int) = normalize(new Rational(i * this.denominator, this.numerator * 1))

  def commonDenominator(r1: Rational, r2: Rational) = r1.denominator * r2.denominator

  def normalize(r: Rational): Rational = {
    if (r.numerator == r.denominator) {
      new Rational(1, 1)
    } else if (r.numerator % r.denominator == 0) {
      new Rational(r.numerator / r.denominator, r.denominator / r.denominator)
    } else if (r.numerator != 0 && r.denominator % r.numerator == 0) {
      new Rational(r.numerator / r.numerator, r.denominator / r.numerator)
    } else {
      r
    }
  }

  override def toString() = s"$numerator/$denominator"

}