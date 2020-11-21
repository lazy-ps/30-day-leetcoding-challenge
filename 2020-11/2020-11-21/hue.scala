object Solution {
  def atMostNGivenDigitSetT(digits: Array[String], n: String): Int = {
    val firstDigit = n.substring(0, 1)
    digits.map{ digit =>
      if(digit > firstDigit) {
        0
      } else if(digit == firstDigit) {
        if(n.length == 1) {
          1
        } else {
          atMostNGivenDigitSetT(digits, n.substring(1, n.length))
        }
      } else {
        digitCalc(digits.length, n.length)
      }
    }.sum
  }

  def atMostNGivenDigitSet(digits: Array[String], n: Int): Int = {
    if(n / 10 == 0) {
      atMostNGivenDigitSetT(digits, n.toString)
    } else {
      atMostNGivenDigitSetT(digits, n.toString) + Range(2, n.toString.length + 1).map(ln => digitCalc(digits.length, ln)).sum
    }
  }

  def digitCalc(size: Int, numberOfDigits: Int): Int = {
    if(numberOfDigits == 1) 1
    else {
      size * digitCalc(size, numberOfDigits - 1)
    }
  }
}
