package test.home.dp

object P_7_GridTraveller_Tabulation {

  def printTable(table: Array[Array[Int]]) = {
    for { v <- table} {
      println(v.mkString(" "))
    }
    println()
  }

  //O(n)
  //Step 1: Tablulate -- 2-D
  //Step 2: Size the table -- rxc with zero bound for init.
  //Step 3: Seed value: 0
  //Step 4: Init value: (1, 1 => 1) because it takes one step to visit to the first element.
  //Step 5: Process elements to right and bottom of current element.
  //Step 6: Answer is last element in (r,c).
  def gridTraveller(r: Int, c: Int) = {
    val table = Array.fill[Int](r+1, c+1)( 0) //Array.ofDim[Int](r, c)
    table(1)(1) = 1

    for{ i <- 0 to r
         j <- 0 to c
    } {
      val curr = table(i)(j)
      if (i +1 <= r) table(i+1)(j) += curr
      if (j +1 <= c) table(i)(j+1) += curr
    }
    table
  }

  def main(args: Array[String]): Unit = {
    printTable(gridTraveller(1, 1))
    printTable(gridTraveller(2, 3))
    printTable(gridTraveller(3, 2))
    printTable(gridTraveller(3, 3))
    printTable(gridTraveller(18, 18))

  }
}
