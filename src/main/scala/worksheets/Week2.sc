class Rational(x : Int, y : Int) {
  def numer = x
  def denom = y

  def add(that : Rational) = {
    new Rational(numer * that.denom + denom * that.numer, denom * that.denom)
  }

  def neg : Rational = new Rational(-numer, denom)

  def sub(that : Rational) = {
    add(that.neg)
  }

  override def toString() = numer + "/" + denom
}

val x = new Rational(1, 3)
val y = new Rational(5, 7)
val z = new Rational(3, 2)
x.sub(y).sub(z)

class Foo(val name: String, val age: Int, val sex: Symbol) {
  override def toString(): String = {
    name + " " + age + " " + sex
  }
}

object Foo {
  def apply(name: String, age: Int, sex: Symbol) = new Foo(name, age, sex)
}