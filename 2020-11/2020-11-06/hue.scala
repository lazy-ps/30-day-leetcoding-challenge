import scala.annotation.tailrec


object Solution {

  def smallestDivisor(nums: Array[Int], threshold: Int): Int = {
    getOpt(nums, threshold, 1, nums.max)
  }

  @tailrec
  def getOpt(nums: Array[Int], threshold: Int, lo: Int, hi: Int): Int = {
    val mi = (lo + hi) / 2
    if(lo + 1 >= hi) {
      if(getDecision(lo, threshold, nums)) {
        lo
      } else {
        hi
      }
    } else if(getDecision(mi, threshold, nums)) {
      getOpt(nums, threshold, lo, mi)
    } else {
      getOpt(nums, threshold, mi, hi)
    }
  }

  def getDecision(divisior: Int, threshold: Int, nums: Array[Int]): Boolean = {
    nums.map(_ + divisior - 1).map(_ / divisior).sum <= threshold
  }

}
