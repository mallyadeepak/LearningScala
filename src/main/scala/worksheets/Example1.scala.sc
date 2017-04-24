val arr = Array(1, 2, 3, 4)

arr.foreach(println)
arr.take(3).foreach(println)
object HelloWorld {
  def main(args: Array[String]) {
    println("Hello, world!")
  }
}
HelloWorld.main(null)
val addOne = (x: Int) => x + 1
addOne(100)

def timesTwo(i: Int): Int = {
  println("hello world")
  i * 2
}

timesTwo(10)


object exercise {
  def fact(num: Int, currProd: Int): Int = {
    if (num == 1) {
      return currProd;
    } else {
      return fact(num - 1, num * currProd);
    }
  }
}
exercise.fact(5, 1);

// fact(3, 4) -> fact(2, 12) -> fact(1, 24)

def sort(list: List[Int]): List[Int] = {
  return list.sortWith { (i, j) =>
    i > j;
  }
}
sort(List(1, 4, 6, 7, 0))

object RecursiveSum {
  def recsum(n : Int) : Int = {
    if (n == 1) 1 else n + recsum(n - 1);
  }
}

RecursiveSum.recsum(10)


import scala.collection.BitSet
import scala.collection.mutable.ListBuffer

val im = Map(1->1.0, 2->3.0)
val mm = collection.mutable.Map[Int,Double]() ++= im
val mm3 = collection.mutable.Map[Int, Double]() ++= mm
println(mm3)
val imm = collection.immutable.Map[Int, Double]() ++ mm3
val map = Map(1 -> "deepak", 2 -> "blah", 3 -> "foo")
val newMap = map.filterKeys(k => k.equals(1))
println(newMap)

val m1 = Map("a" -> 1, "b" -> 2)
val m2 = Map("a" -> 3, "b" -> 3, "c" -> 3)

val newList = m1.toList ++ m2.toList
val resultMap = newList.groupBy(elem => elem._1)
resultMap.foreach(map => {
  print(map._1 + " -> ")
  val list = map._2
  print(list)
  println()
})

val mapList = newList.map(elem => elem._2)
val flatMapList = newList.flatMap(elem => {
  val tempList = ListBuffer[Int](1)
  tempList += elem._2
  tempList
})

// Creating a list
val list1 = 1 :: 2 :: 3 :: Nil
val list2 = List(1, 2, 3)

val list3 = List.range(0, 10)
val list4 = List.range(0, 10, 3)
val list5 = List.fill(5)("deepak")

val list6 = List.tabulate(5)(n => n * n)

val y = 0 :: list1
val z = list1 ::: list2
val concat = List.concat(list1, list2)

concat.foreach {println}

var sum = 0
concat.foreach(sum += _)
println(sum)

for (num <- concat if num > 2) {
  println(num)
}

val primebits = BitSet(2, 3, 5, 7, 11)
val evenBits =  BitSet(0, 2, 4, 6, 8, 10)
val evenSet = Set(0, 2, 4, 6, 8, 10);
println(primebits & evenBits)  // BitSet(2)
println(primebits & evenSet)  // BitSet(2)


// merge two sorted lists and return final sorted List.
def mergeLists(list1: List[Int],
               list2: List[Int]) : List[Int] = {
  var newListBuffer = ListBuffer[Int]()

  var f = 0
  var s = 0
  while (f < list1.size && s < list2.size) {
    if (list1(f) <= list2(s)) {
      newListBuffer += list1(f)
      f = f + 1
    } else {
      newListBuffer += list2(s)
      s = s + 1
    }
  }

  while (f < list1.size) {
    newListBuffer += list1(f)
    f = f + 1
  }

  while (s < list2.size) {
    newListBuffer += list2(s)
    s = s + 1
  }
  newListBuffer.toList
}


val outputList = mergeLists(List(1, 5, 9), List(2, 3, 10))
outputList
