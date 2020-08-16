object Solution {
  def maxProfit(prices: Array[Int]): Int = {
    if(prices.isEmpty) {
      0
    } else {
      val leftProfits = prices.foldLeft(List(0), prices.head){
        case ((acc, minVal), price) =>
          val lastProfit = acc.head
          val profit = math.max(lastProfit, price - minVal)
          val newMinVal = math.min(price, minVal)
          (profit :: acc, newMinVal)
      }._1.init

      val rightProfits = prices.foldRight(List(0), prices.last){
        case (price, (acc, maxVal)) =>
          val lastProfit = acc.head
          val profit = math.max(lastProfit, maxVal - price)
          val newMaxVal = math.max(price, maxVal)
          (profit :: acc, newMaxVal)
      }._1.init.reverse

      leftProfits.zip(rightProfits).map{ case (left, right) => left + right }.max
    }
  }

  def main(args: Array[String]): Unit = {
    println(maxProfit(Array(1,2,4,2,5,7,2,4,9,0)))
    assert(maxProfit(Array(1,2,4,2,5,7,2,4,9,0)) == 13)
    println(maxProfit(Array(3,3,5,0,0,3,1,4)))
    assert(maxProfit(Array(3,3,5,0,0,3,1,4)) == 6)
    assert(maxProfit(Array(1,2,3,4,5)) == 4)
    assert(maxProfit(Array(7,6,4,3,1)) == 0)
  }
}
