object Solution {
  def flipAndInvertImage(A: Array[Array[Int]]): Array[Array[Int]] = {
    A.map(_.reverse.map(v => if(v == 1) 0 else 1))
  }
}
