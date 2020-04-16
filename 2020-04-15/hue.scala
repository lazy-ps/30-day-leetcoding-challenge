object Solution {
  def productExceptSelf(nums: Array[Int]): Array[Int] = {
    
    val preProdLeft = nums.foldLeft(List(1))((li, value) => (value * li.head) :: li ).reverse.toIndexedSeq
    val preProdRight = nums.foldRight(List(1))((value, li) => (value * li.head) :: li ).toIndexedSeq

    nums.indices.map { idx => preProdLeft(idx) * preProdRight(idx + 1) }.toArray
  }
}
