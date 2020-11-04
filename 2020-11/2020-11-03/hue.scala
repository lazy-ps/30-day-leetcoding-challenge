object Solution {
  def maxPower(s: String): Int = {
    s.zipWithIndex
        .groupBy(_._1)
        .values
        .map(_.zipWithIndex)
        .flatMap(_.groupBy { case ((_, idx), refidx) => refidx - idx }.mapValues(_.size).values)
        .max
  }
}
