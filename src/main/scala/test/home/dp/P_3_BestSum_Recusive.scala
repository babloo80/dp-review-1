package test.home.dp

import scala.collection.mutable.Map

object P_3_BestSum_Recusive {

  //based on recursive and memoization
  def bestSum(inputNumber: Int, valueSet: List[Int], memoizedResults: collection.mutable.Map[Int, Option[List[Int]]] = Map.empty): Option[List[Int]] = {
    if (memoizedResults.contains(inputNumber)) return memoizedResults(inputNumber)
    if (inputNumber == 0) return Some(List.empty)
    if (inputNumber < 0) return Option.empty
    val results = for {
      value <- valueSet
      nextInput = inputNumber - value if nextInput >= 0
    } yield {
      val result = bestSum(nextInput, valueSet, memoizedResults).map(v => v :+ value)
      if (result.nonEmpty && nextInput != 0) {
        memoizedResults.put(inputNumber, result)
      }
      result
    }
    val bestResult = results.flatten.sortBy(_.length).find(_.nonEmpty)
    memoizedResults.put(inputNumber, bestResult)
    memoizedResults(inputNumber)
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