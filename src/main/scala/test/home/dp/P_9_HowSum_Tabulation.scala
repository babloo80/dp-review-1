package test.home.dp

object P_9_HowSum_Tabulation {

  //based on recursive but no memoization.
  //Step 1: Setup an List[Int] array from 0 to inputNumber.
  //Step 2: Initialize (0 index) to be List.empty
  //Step 3: Set T to each valueSet index position relative from current position whenever value at the current position is T.
  def howSum(inputNumber: Int, valueSet: List[Int]): List[Int] = {
    val table = Array.fill[List[Int]](inputNumber+1)( List.empty) //Step 1
    table(0) = List.empty //Step 2
    for { i <- 0 to inputNumber} {
      if (i == 0 || table(i).nonEmpty) {
        val currValue = table(i)
        valueSet.foreach { v =>
          if (i+v <= inputNumber) table(i+v) = currValue :+ v
        }
      }
    }
    table.last
  }


  def main(args: Array[String]): Unit = {
    val s = System.currentTimeMillis()
    println(howSum(7, List(2,3)))
    println(howSum(7, List(5,3,4,7)))
    println(howSum(7, List(2,4)))
    println(howSum(8, List(2,3,5)))
    println(howSum(300, List(7,14)))
    println(System.currentTimeMillis() - s)
  }
}