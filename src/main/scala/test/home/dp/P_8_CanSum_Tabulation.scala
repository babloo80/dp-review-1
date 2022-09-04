package test.home.dp

import scala.collection.mutable.Map

//given an input number and set of numbers, can there be a combination of input number that can be based on zero or more results of addition of the elements from set with replacement.

object P_8_CanSum_Tabulation {

  //based on recursive but no memoization.
  //Step 1: Setup an boolean array from 0 to inputNumber.
  //Step 2: Initialize (0 index) to be T
  //Step 3: Set T to each valueSet index position relative from current position whenever value at the current position is T.
  def canSum(inputNumber: Int, valueSet: List[Int]): Boolean = {
    val table = Array.fill[Boolean](inputNumber+1)( false) //Step 1
    table(0) = true //Step 2
    for { i <- 0 to inputNumber} {
      if (table(i) == true) {
        valueSet.foreach { v =>
          if (i+v <= inputNumber) table(i+v) = true
        }
      }
    }
    table.last
  }


  def main(args: Array[String]): Unit = {
    val s = System.currentTimeMillis()
    println(canSum(7, List(2,3)))
    println(canSum(7, List(5,3,4,7)))
    println(canSum(7, List(2,4)))
    println(canSum(8, List(2,3,5)))
    println(canSum(300, List(7,14)))
    println(System.currentTimeMillis() - s)
  }
}