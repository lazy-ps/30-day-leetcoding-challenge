object Solution {
  def frequencySort(s: String): String = {
    val groupMap = s.groupBy(_.toChar).mapValues(_.length)
    groupMap.toList.sortBy(-_._2).foldLeft(new StringBuilder("")){ case (acc, (charVal, length)) =>
      acc.append((charVal.toString * length))
    }.toString
  }
}
