package test.home.dp
import scala.collection.mutable.Map

//Given an input string and a word_bank, is it possible to construct the input string from the word_bank?
object P_4_CanConstruct_Recusive {
  def canConstructV1(input: String, wordBank: List[String]): Boolean = {
    if (input.isEmpty) return true
    val results = for {
      word <- wordBank if input.startsWith(word)
    } yield {
      canConstructV1(input.drop(word.length), wordBank)
    }
    results.contains(true)
  }

  def canConstructV2(input: String, wordBank: List[String], mem: Map[String, Boolean] = Map.empty): Boolean = {
    if (input.isEmpty) return true
    if (mem.contains(input)) return mem(input)
    val results = for {
      word <- wordBank if input.startsWith(word)
    } yield {
      val res = canConstructV2(input.drop(word.length), wordBank, mem)
      if (res) mem.put(input, res)
      res
    }
    mem.put(input, results.contains(true))
    results.contains(true)
  }

  def main(args: Array[String]): Unit = {
    println(canConstructV2("abcdef", List("ab", "abc", "def", "abcd")))
    println(canConstructV2("skateboard", List("bo", "rd", "ate", "t", "ska", "sk", "boar")))
    println(canConstructV2("enterpotentpot", List("a", "p", "ent", "enter", "ot", "o", "t")))
    println(canConstructV2("eeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeef", List("e", "eee", "eeeee", "eeeeee", "eeeeeee", "eeeeeeee")))
  }
}
