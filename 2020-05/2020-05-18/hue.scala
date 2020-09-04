object Solution {
  def checkInclusion(s1: String, s2: String): Boolean = {
    val s1Map = s1.groupBy(_.toChar).mapValues(_.length).toMap
    s2.foldLeft(Map[Char, Int](), - s1.length, false) { case ((fM, deleteIdx, ret), charVal) =>
      val nextMap = getNextMap(s2, fM, deleteIdx, charVal)
      (nextMap, deleteIdx + 1, ret || checkIsAvailable(nextMap, s1Map))
    }._3
  }

  def getNextMap(s2: String, currentFM: Map[Char, Int], deleteIdx: Int, charVal: Char): Map[Char, Int] = {
    val currentVal = currentFM.getOrElse(charVal, 0)
    val addedMap = currentFM.updated(charVal, currentVal + 1)

    s2.lift(deleteIdx)
      .map(deleteChar => addedMap.updated(deleteChar, addedMap(deleteChar) - 1))
      .getOrElse(addedMap)
  }

  def checkIsAvailable(fM: Map[Char, Int], s1Map: Map[Char, Int]): Boolean = {
    !s1Map.map { case (charVal, frequency) =>
      fM.getOrElse(charVal, 0) >= frequency
    }.exists(_ == false)
  }
}
