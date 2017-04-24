import scala.collection.mutable.ListBuffer

/**
 * Created by deepakp on 5/17/15.
 */
object GroupSum {

  def groupSum(start : Int, nums : List[Int], targetSum : Int, group : ListBuffer[Int]) : Boolean = {
    for (i <- start to nums.length - 1) {
      if (targetSum == nums(i)) {
        group += nums(i);
        println(group);
        group -= nums(i);
      } else {
        group += nums(i);
        groupSum(i + 1, nums, targetSum - nums(i), group)
        group -= nums(i);
      }
    }
    return true; // not needed.
  }

  def main(args : Array[String]) {
    var resultList = new ListBuffer[Int];
    println(GroupSum.groupSum(0, List(2, 4 ,8), 10, resultList));
    //println(resultList);
    resultList.clear();
    println(GroupSum.groupSum(0, List(2, 4 ,8), 3, resultList));
    //println(resultList);
    resultList.clear();
    println(GroupSum.groupSum(0, List(2, 4 ,1, -1, 3, 0), 0, resultList));
    //println(resultList);
    //resultList.clear();
    //println(GroupSum.groupSum(0, List(1, -1, 3), 0, resultList));
    resultList.clear();
  }
}

