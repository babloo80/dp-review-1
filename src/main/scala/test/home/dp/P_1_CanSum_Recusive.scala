package test.home.dp

import scala.collection.mutable.Map

//given an input number and set of numbers, can there be a combination of input number that can be based on zero or more results of addition of the elements from set with replacement.

object P_1_CanSum_Recusive {
  //based on recursive but no memoization.
  def canSumV1(inputNumber: Int, valueSet: List[Int]): Boolean = {
    if (inputNumber == 0) return true
    val results = for {
      value <- valueSet if (inputNumber - value) >= 0
    } yield {
      canSumV1(inputNumber - value, valueSet)
    }
    results.contains(true)
  }

  //based on recursive and memoization
  def canSumV2(inputNumber: Int, valueSet: List[Int], memoizedResults: collection.mutable.Map[Int, Boolean] = Map.empty): Boolean = {
    if (memoizedResults.contains(inputNumber)) return memoizedResults(inputNumber)
    if (inputNumber == 0) return true
    val results = for {
      value <- valueSet if (inputNumber - value) >= 0
    } yield {
      val nextInput = inputNumber - value
      val result = canSumV2(nextInput, valueSet, memoizedResults)
      memoizedResults.put(nextInput, result)
      result
    }
    memoizedResults.put(inputNumber, results.contains(true))
    memoizedResults(inputNumber)
  }

  def main(args: Array[String]): Unit = {
    val s = System.currentTimeMillis()
    println(canSumV2(7, List(2,3)))
    println(canSumV2(7, List(5,3,4,7)))
    println(canSumV2(7, List(2,4)))
    println(canSumV2(8, List(2,3,5)))
    println(canSumV2(300, List(7,14)))
    println(System.currentTimeMillis() - s)
  }
}