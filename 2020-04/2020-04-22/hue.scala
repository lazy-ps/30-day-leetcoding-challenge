object Solution {
  def subarraySum(nums: Array[Int], k: Int): Int = {
    val preSumArray = getPreSumArray(nums)
    val preSumHashMap = new scala.collection.mutable.HashMap[Int, Int]
    preSumArray.map { value =>
      val ret = preSumHashMap.getOrElseUpdate(value - k, 0)
      preSumHashMap(value) = preSumHashMap.getOrElseUpdate(value, 0) + 1
      ret
    }.sum
  }

  // size 가 1 더 큰 preSum 배열 생성
  def getPreSumArray(nums: Array[Int]): Array[Int] = {
    nums.foldLeft(List(0))((accLi, value) =>
      accLi.head + value :: accLi
    ).reverse.toArray
  }
}
