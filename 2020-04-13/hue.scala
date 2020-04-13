object Solution {
  // 배열을 한번 순회하면서 map(해당 값을 갖는 가장 빠른 idx) 을 업데이트 O(n)
  def findMaxLength(nums: Array[Int]): Int = {
    nums.zipWithIndex.foldLeft(Map[Int, Int](0 -> -1), 0, 0){ case ((map: Map[Int, Int], prevPreSum: Int, maxSubarraySize), (value: Int, idx: Int)) =>
      val currentPreSum = prevPreSum + (if(value == 1) 1 else - 1)
      map.get(currentPreSum).map { prevIdx =>
        val currentSubwArraySize = idx - prevIdx
        (map, currentPreSum, math.max(maxSubarraySize, currentSubwArraySize))
      }.getOrElse(map + (currentPreSum -> idx), currentPreSum, maxSubarraySize)
    }._3
  }
}
