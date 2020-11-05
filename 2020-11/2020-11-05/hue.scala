object Solution {
  def minCostToMoveChips(position: Array[Int]): Int = {
    val evenNums = position.count(_ % 2 == 0)
    val oddNums = position.length - evenNums
    math.min(evenNums, oddNums)
  }
}
