object Solution {

  def memoize[I, O](f: I => O): I => O = new scala.collection.mutable.HashMap[I, O]() {
    override def apply(key: I) = getOrElseUpdate(key, f(key))
  }

  def maxUncrossedLines(A: Array[Int], B: Array[Int]): Int = {
    lazy val getLCS: ((Int, Int)) => Int = memoize {
      case (i, j) if i < 0 || j < 0 => 0
      case (i, j) => {
        if(A(i) == B(j)) {
          List(getLCS(i - 1, j - 1) + 1, getLCS(i - 1, j), getLCS(i, j - 1)).max
        } else {
          List(getLCS(i - 1, j), getLCS(i, j - 1)).max
        }
      }
    }
    getLCS(A.length - 1, B.length - 1)
  }

  def main(args: Array[String]): Unit = {
    println("a" * 5)
  }
}
