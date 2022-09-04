package test.home.dp

object P_10_BestSum_Tabulation {

  //based on recursive but no memoization.
  //Step 1: Setup an List[Int] array from 0 to inputNumber.
  //Step 2: Initialize (0 index) to be List.empty
  //Step 3: Set T to each valueSet index position relative from current position whenever value at the current position is nonEmpty. But also, make sure the shortest length is used.
  def bestSum(inputNumber: Int, valueSet: List[Int]): List[Int] = {
    val table = Array.fill[List[Int]](inputNumber+1)( List.empty) //Step 1
    table(0) = List.empty //Step 2
    for { i <- 0 to inputNumber} {
      if (i == 0 || table(i).nonEmpty) {
        val currValue = table(i)
        valueSet.foreach { v =>
          val updated = currValue :+ v
          if (i+v <= inputNumber)  {
            if (table(i+v).isEmpty) table(i+v) = updated
            else table(i+v) = if (updated.length < table(i+v).length) updated else table(i+v)
          }
        }
      }
    }
    table.last
  }


  def main(args: Array[String]): Unit = {
    val s = System.currentTimeMillis()
    println(bestSum(7, List(2,3)))
    println(bestSum(7, List(5,3,4,7)))
    println(bestSum(7, List(2,4)))
    println(bestSum(8, List(2,3,5)))
    println(bestSum(300, List(7,14)))
    println(System.currentTimeMillis() - s)
  }
}