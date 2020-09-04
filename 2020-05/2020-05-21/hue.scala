object Solution {

  case class ConnectedValue(horizontal: Int, vertical: Int, diagonal: Int)

  def memoize[I, O](f: I => O): I => O = new scala.collection.mutable.HashMap[I, O]() {
    override def apply(key: I): O = getOrElseUpdate(key, f(key))
  }

  def countSquares(matrix: Array[Array[Int]]): Int = {
    lazy val dp: ((Int, Int)) => ConnectedValue = memoize {
      case (row, col) if row < 0 || col < 0 => ConnectedValue(0, 0, 0)
      case (row, col) if matrix(row)(col) == 0 => ConnectedValue(0, 0, 0)
      case (row, col) => {
        val horizontal = dp(row, col - 1).horizontal + 1
        val vertical = dp(row - 1, col).vertical + 1
        val diag = dp(row - 1, col - 1).diagonal + 1

        val diagRet = List(vertical, horizontal, diag).min
        ConnectedValue(horizontal, vertical, diagRet)
      }
    }
    
    val ret =
      for {
        i <- matrix.indices
        j <- matrix(0).indices
      } yield {
        dp(i, j)
      }.diagonal

    ret.sum
  }
}
