package test.home.dp

import scala.collection.mutable.Map

//Given an input string and a word_bank, is it possible to construct the input string from the word_bank?
object P_12_AllConstruct_Tabulation {


  //Step 1: table List[String] elements with input.length+1.
  //Step 2: setup seed value at index 0 to be List(List.empty)
  def allConstruct(input: String, wordBank: List[String]): List[List[String]] = {
    val table = Array.fill[List[List[String]]](input.length+1)( List.empty) //Step 1
    table(0) = List(List.empty)
    for {
      i <- 0 to input.length
    } {
      if (table(i).nonEmpty) {
        val currInput = input.drop(i)
        val wList = wordBank.filter(w => currInput.startsWith(w))
        wList.foreach { w =>
          val res: List[List[String]] = table(i).map(v => v:+w) //copy down value from current index with inclusion of word (from word_bank).
          table(i + w.length) ++= res
        }
      }
    }
    table.last
  }

  def main(args: Array[String]): Unit = {
    println(allConstruct("purple", List("p", "ur", "purp",  "le", "purpl")))
    println(allConstruct("abcdef", List("ab", "abc", "def", "abcd")))
    println(allConstruct("abcdef", List("ab", "abc", "cd", "def", "abcd", "ef", "c")))
    println(allConstruct("skateboard", List("bo", "rd", "ate", "t", "ska", "sk", "boar")))
    println(allConstruct("enterpotentpot", List("a", "p", "ent", "enter", "ot", "o", "t")))
    println(allConstruct("eeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeef", List("e", "eee", "eeeee", "eeeeee", "eeeeeee", "eeeeeeee"))) //broken!
  }
}
