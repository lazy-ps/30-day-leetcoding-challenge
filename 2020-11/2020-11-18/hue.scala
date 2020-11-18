object Solution {
  def merge(intervals: Array[Array[Int]]): Array[Array[Int]] = {
    if(intervals.isEmpty) {
      intervals
    } else {
      val pairArray = intervals.map(ar => (ar(0), ar(1))).sortBy(_._1)
      pairArray.tail.foldLeft(pairArray(0)::Nil){ (li, p) =>
        val head = li.head
        if(head._2 >= p._1) {
          (head._1, math.max(head._2, p._2))::li.tail
        } else {
          p::li
        }
      }.map(p => Array(p._1, p._2)).toArray
    }
  }
}
