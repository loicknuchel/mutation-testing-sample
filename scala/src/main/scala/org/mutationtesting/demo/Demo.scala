package org.mutationtesting.demo

object Demo {
  def fizzBuzz(n: Int): String = {
    if (n % 15 == 0) "FizzBuzz"
    else if (n % 3 == 0) "Fizz"
    else if (n % 5 == 0) "Buzz"
    else n.toString
  }

  /**
    * Take a list of item prices and calculate the bill :
    * - if total is higher than 50, apply 10% overall discount
    * - if more than 5 items, apply 100% discount on cheapest one
    * - if many discount apply, use the higher one
    */
  def getPrice(prices: Seq[Double]): Double = {
    val total = sum(prices)
    var disount = 0.0
    if (total >= 50) {
      disount = total * 0.1
    }
    if (prices.length >= 5) {
      val minPrice = min(prices)
      if (minPrice > disount) {
        disount = minPrice
      }
    }
    total - disount
  }

  private def sum(values: Seq[Double]): Double = {
    var sum = 0.0
    var i = 0
    while (i < values.length) {
      sum = sum + values(i)
      i = i + 1
    }
    sum
  }

  private def min(values: Seq[Double]): Double = {
    var result = values.head
    var i = 1
    while (i < values.length) {
      if (result > values(i)) {
        result = values(i)
      }
      i = i + 1
    }
    result
  }
}
