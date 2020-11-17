import scala.annotation.tailrec

object Solution {

  def mirrorReflection(p: Int, q: Int): Int = {
    val gcd = getGCD(p, q)
    (p / gcd, q / gcd) match {
      case (k, _) if k % 2 == 0 => 2
      case (_, m) if m % 2 == 0 => 0
      case _ => 1
    }
  }

  @tailrec
  def getGCD(a: Int, b: Int): Int = {
    if(a < b) {
      getGCD(b, a)
    } else if(b == 0) {
      a
    } else {
      getGCD(b, a % b)
    }
  }
}
