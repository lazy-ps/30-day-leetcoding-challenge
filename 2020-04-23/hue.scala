object Solution {
  def rangeBitwiseAnd(m: Int, n: Int): Int = {
    val pow = getLargestPow(n - m + 1, 0)
    fillZero(m&n, pow)
  }

  def fillZero(ret: Int, toZeroPow: Int): Int = {
    ret - (ret & ((1 << toZeroPow) - 1))
  }

  // integer 오버플로우를 막기위해 중간에 Long 으로 형변환하는 사술을 사용
  @scala.annotation.tailrec
  def getLargestPow(n: Int, pow: Int): Int = {
    if (n <= (1l << pow)) {
      pow
    } else {
      getLargestPow(n, pow + 1)
    }
  }
}
