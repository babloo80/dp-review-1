package test.home.dp

import scala.collection.mutable.Map

//Given an input string and a word_bank, is it possible to construct the input string from the word_bank?
object P_11_CanConstruct_Tabulation {

  //Step 1: Create a table of 1-D boolean.
  // Input: canConstruct("abcdef", List("ab", "abc", "cd", "def", "abcd"))
  //   [T, F, F, F, F, F  F]
  //    a  b  c  d  e  f  |
  // Note, last position is the result.
  //Step 2:
  // index 0 is T so, work_bank matching prefix is checked.
  // ab =>    [T, F, T, F, F, F  F]
  // abc =>   [T, F, T, T, F, F  F]
  // abcd =>  [T, F, T, T, T, F, F]
  // ---
  // index 1 is F so, the word_bank check would be skipped.
  def canConstruct(input: String, wordBank: List[String]): Boolean = {
    val table = Array.fill[Boolean](input.length+1)( false) //Step 1
    table(0) = true
    for {
      i <- 0 to input.length
    } {
      if (table(i) == true) {
        val currInput = input.drop(i)
        val wList = wordBank.filter(w => currInput.startsWith(w))
        wList.foreach { w =>
          table(i+w.length) = true
        }
      }
    }
    table.last
  }

  def main(args: Array[String]): Unit = {
    println(canConstruct("abcdef", List("ab", "abc", "cd", "def", "abcd")))
    println(canConstruct("skateboard", List("bo", "rd", "ate", "t", "ska", "sk", "boar")))
    println(canConstruct("enterpotentpot", List("a", "p", "ent", "enter", "ot", "o", "t")))
    println(canConstruct("eeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeef", List("e", "eee", "eeeee", "eeeeee", "eeeeeee", "eeeeeeee")))
  }
}
