object Solution {
  def longestMountain(A: Array[Int]): Int = {
    if(A.length < 3) {
      0
    } else {
      // (left, right)
      lazy val getMountainsLength: Int => (Int, Int, Int) = memoize {
        case 0 => (1, 0, 0)
        case idx if A(idx - 1) > A(idx) =>
          val (_, preCenter, preRight) = getMountainsLength(idx - 1)
          val rightTemp = math.max(preCenter + 1, preRight + 1)
          (1, 0, if(rightTemp > 2) rightTemp else 0)
        case idx if A(idx - 1) == A(idx) =>
          (1, 0, 0)
        case idx if A(idx - 1) < A(idx) =>
          val (preLeft, _, _) = getMountainsLength(idx - 1)
          (preLeft + 1, preLeft + 1, 0)
      }
      A.indices.map(getMountainsLength).foreach(println)
      A.indices.map(getMountainsLength).map(_._3).max
    }
  }

  def memoize[I, O](f: I => O): I => O = new scala.collection.mutable.HashMap[I, O]() {
    override def apply(key: I): O = getOrElseUpdate(key, f(key))
  }
}
