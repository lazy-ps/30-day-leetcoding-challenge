/**
 * // This is the BinaryMatrix's API interface.
 * // You should not implement it, or speculate about its implementation
 * class BinaryMatrix {
 *     def get(x: Int, y: Int): Int = {}
 *     def dimensions(): Array[Int] = {}
 * }
 */

object Solution {
  def leftMostColumnWithOne(binaryMatrix: BinaryMatrix): Int = {
    val dimension = binaryMatrix.dimensions()
    val (rowSize, colSize) = (dimension(0), dimension(1))

    val ret = (0 until rowSize).map(getLeftMostOneIdx(_, colSize, binaryMatrix)).min

    if(ret == colSize) -1 else ret
  }

  def getLeftMostOneIdx(row: Int, colSize: Int, binaryMatrix: BinaryMatrix): Int = {
    getLeftMostOneIdx(row, -1, colSize, binaryMatrix)
  }

  @scala.annotation.tailrec
  def getLeftMostOneIdx(row: Int, lo: Int, hi: Int, binaryMatrix: BinaryMatrix): Int = {
    if(lo + 1 == hi) {
      hi
    } else {
      val mi = (lo + hi) / 2
      if(binaryMatrix.get(row, mi) == 1) {
        getLeftMostOneIdx(row, lo, mi, binaryMatrix)
      } else {
        getLeftMostOneIdx(row, mi, hi, binaryMatrix)
      }
    }
  }
}
