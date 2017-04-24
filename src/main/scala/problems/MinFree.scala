package problems

/**
  * Created by deepakp on 6/27/16.
  */
object MinFree {

  def main(args: Array[String]) {
    println(getSlots(List(1, 4, 9), 2))
  }

  def getSlots(usedSlots: List[Int], numSlots: Int): List[Int] = {
    // [1 4 9], 2
    val newSlots = List()
    var prevSlot = 0
    for (currSlot <- 0 to (usedSlots.size - 1)) {
      if (usedSlots(currSlot) - usedSlots(prevSlot) > numSlots) {
        for (sl <- (prevSlot + 1) to (prevSlot + 1 + numSlots)) {
          if (sl < usedSlots.size) {
            newSlots :+ usedSlots(sl)
          }
        }
        return newSlots
      } else {
        prevSlot = currSlot
      }
    }
    return newSlots
  }

}
