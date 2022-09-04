package test.home.dp

import scala.collection.mutable.Map

object P_2_HowSum_Recusive {

  //O(n^m)
  def howSumV1(inputNumber: Int, valueSet: List[Int]): Option[List[Int]] = {
    if (inputNumber < 0) return Option.empty
    if (inputNumber == 0) return Some(List.empty)
    val results = for {
      value <- valueSet
    } yield {
      val nextInput = inputNumber - value
      val result = howSumV1(nextInput, valueSet).map(v => v :+ value)
      result
    }
    results.flatten.find(_.nonEmpty)
  }

  //based on recursive and memoization
  //O(n*m)
  def howSumV2(inputNumber: Int, valueSet: List[Int], memo: collection.mutable.Map[Int, Option[List[Int]]] = Map.empty): Option[List[Int]] = {
    if (memo.contains(inputNumber)) return memo(inputNumber)
    if (inputNumber < 0) return Option.empty
    if (inputNumber == 0) return Some(List.empty)
    val results = for {
      value <- valueSet
    } yield {
      val nextInput = inputNumber - value
      val result = howSumV2(nextInput, valueSet, memo).map(v => v :+ value)
      if (result.nonEmpty) {
        memo.put(inputNumber, result )
      }
      result
    }
    memo.put(inputNumber, results.flatten.find(_.nonEmpty))
    results.flatten.find(_.nonEmpty)
  }

  def main(args: Array[String]): Unit = {
    val s = System.currentTimeMillis()
    println(howSumV2(7, List(2,3)))
    println(howSumV2(7, List(5,3,4,7)))
    println(howSumV2(7, List(2,4)))
    println(howSumV2(8, List(2,3,5)))
    println(howSumV2(300, List(7,14)))
    println(System.currentTimeMillis() - s)
  }
}