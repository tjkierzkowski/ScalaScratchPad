val x = new Rational(1, 3)
val y = new Rational(5, 7)
val z = new Rational(3, 2)
val test = new Rational(1)
x.numer
x.denom
x.sub(y).sub(z)
y.add(y)
x.less(y)
x.max(y)
x.max(z)
//Fails because it breaks the requirement
//val strange = new Rational(1, 0)
//strange.add(strange)
test.add(x)

class Rational (x: Int, y: Int) {
  require(y != 0, "The denominator must be nonzero")

  def this(x: Int) = this(x, 1)

  private def gcd(a: Int, b: Int): Int =
    if (b == 0) a else gcd(b, a % b)

  private val g = gcd(x, y)
  def numer = x
  def denom = y
  //def numer = x / g
  //def denom = y / g

  def less(that: Rational) =
    numer * that.denom < that.numer * denom

  def max(that: Rational) =
    if (this.less(that)) that else this

  def add(that: Rational): Rational =
    new Rational (
      numer * that.denom + that.numer * denom,
      denom * that.denom)

  def neg: Rational = new Rational(-numer, denom)

  def sub(that: Rational): Rational = add(that.neg)

  //override def toString = numer + "/" + denom
  override def toString = numer/g + "/" + denom/g

}

