object Solution {
  def search(nums: Array[Int], target: Int): Int = {
    search(nums, target, 0, nums.length)
  }

  @scala.annotation.tailrec
  def search(nums: Array[Int], target: Int, lo: Int, hi: Int): Int = {
    if(lo + 1 == hi) {
      if(nums(lo) == target) lo else -1
    } else {
      val mi = (lo + hi) / 2
      if(target >= nums(mi)) {
        search(nums, target, mi, hi)
      } else {
        search(nums, target, lo, mi)
      }
    }
  }
}
