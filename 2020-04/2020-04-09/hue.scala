// 연산된 결과를 equal로 비교
object Solution {
  def backspaceCompare(S: String, T: String): Boolean = {
    getFinalString(S) == getFinalString(T)
  }

  def getFinalString(str: String): String = {
    str.foldLeft("")((li, x) =>
      x match {
        case '#' if li.isEmpty => li
        case '#' => li.tail
        case _ => x + li
      }
    ).reverse
  }
}
