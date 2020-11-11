object Solution {
  def validSquare(p1: Array[Int], p2: Array[Int], p3: Array[Int], p4: Array[Int]): Boolean = {
    if((p1 sameElements p2) && (p1 sameElements p3) && (p1 sameElements p4)) false
    else {
      List(p1, p2, p3, p4).combinations(3).forall { li =>
        val List(pa, pb, pc) = li
        isRightIsoscelesTriangle(pa, pb, pc)
      }
    }
  }

  def isRightIsoscelesTriangle(p1: Array[Int], p2: Array[Int], p3: Array[Int]): Boolean = {
    val sideList = List(getDistanceSquare(p1, p2), getDistanceSquare(p2, p3), getDistanceSquare(p3, p1)).sorted
    val List(a, b, c) = sideList
    a == b && a + b == c
  }

  def getDistanceSquare(p1: Array[Int], p2: Array[Int]): Int = {
    val (x1, y1, x2, y2) = (p1(0), p1(1), p2(0), p2(1))
    (x1 - x2) * (x1 - x2) + (y1 - y2) * (y1 - y2)
  }
}
