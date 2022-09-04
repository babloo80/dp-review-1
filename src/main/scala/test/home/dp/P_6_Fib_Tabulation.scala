package test.home.dp
import scala.collection.mutable.Buffer

object P_6_Fib_Tabulation {

  //O(n)
  def fib(n: Int): Int = {
    val table = Array.fill[Int](n+1)( 0) //Array.ofDim[Int](n)
    for(i <- 0 to n) {
      table(i) = 0
    }
    table(1) = 1
    for (i <- 0 until n) {
      if (table.length > i+1) table(i+1) += table(i)
      if (table.length > i+2) table(i+2) += table(i)
    }
    table(n)
  }

  def main(args: Array[String]): Unit = {
    println(fib(6))
    println(fib(7))
    println(fib(8))
    println(fib(50))
  }
}
