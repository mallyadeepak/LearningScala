/**
 * Created by deepakp on 5/20/15.
 */
object RecursiveExamples {

  def recursiveSum(n : Int) : Int = {
    if (n == 1) 1 else n + recursiveSum(n - 1);
  }

  def tailRecursiveSum(n : Int) : Int = {
    def loop(n : Int, acc : Int) : Int = {
      if (n == 0) acc else loop(n - 1, n + acc)
    }
    loop(n, 0)
  }

  def mapReduce(f : Int => Int, combine : (Int, Int) => Int, zero : Int)(a : Int, b: Int): Int = {
    if (a > b) zero;
    else combine(f(a), mapReduce(f, combine, zero) (a + 1, b))
  }

  def product2(f : Int => Int)(a : Int, b : Int): Int = mapReduce(f, (x, y) => x * y, 1) (a, b)

  def product(f : Int => Int)(a : Int, b : Int): Int = {
    if (a > b) 1;
    else f(a) * product(f)(a + 1, b);
  }

  def factInTermsOfProduct(n : Int) : Int = {
    return product(x => x) (1, n);
  }

  def recursiveSum(list: List[Int]): Int = {
    list.length match {
      case 0 => 0
      case default => list(list.length - 1) + recursiveSum(list.take(list.length - 1))
    }
  }

  def tailRecursiveSum(list: List[Int], accum: Int): Int = {
    list.length match {
      case 0 => accum
      case default => tailRecursiveSum(list.take(list.length - 1), accum + list(list.length - 1))
    }
  }

  def recursiveProduct(list: List[Int]): Int = {
    list.length match {
      case 0 => 1
      case default => list(list.length - 1) * recursiveProduct(list.take(list.length - 1))
    }
  }

  def tailRecursiveProduct(list: List[Int], accum: Int): Int = {
    list.length match {
      case 0 => accum
      case default => tailRecursiveProduct(list.take(list.length - 1), accum * list(list.length - 1))
    }
  }

  def main(args : Array[String]) : Unit = {
    //println(RecursiveExamples.recursiveSum(100));
    //println(RecursiveExamples.recursiveSum(5));
    //println(RecursiveExamples.tailRecursiveSum(100));
    //println(RecursiveExamples.product(x => x * 5) (1, 3));
    //println(RecursiveExamples.factInTermsOfProduct(5));
    //println(RecursiveExamples.product2(x => x * 5) (1, 3));
    println("Sum = " + recursiveSum(List(1, 2, 3, 4)))
    println("Sum = " + tailRecursiveSum(List(1, 2, 3, 4), 0))
    println("Product = " + recursiveProduct(List(1, 2, 3, 4)))
    println("Product = " + tailRecursiveProduct(List(1, 2, 3, 4), 1))
  }
}

