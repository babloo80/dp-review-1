package test.home.dp

import scala.collection.mutable.Map

//Given an input string and a word_bank, is it possible to construct the input string from the word_bank?
object P_5_AllConstruct_Recusive {
  def allConstructV1(input: String, wordBank: List[String]): List[List[String]] = {
    if (input.isEmpty) return List(List.empty)
    val results = for {
      word <- wordBank if input.startsWith(word)
    } yield {
      allConstructV1(input.drop(word.length), wordBank).map(v => v :+  word)
    }
    results.flatten.distinct
    //results.find(_.nonEmpty).getOrElse(List.empty)
  }

  def allConstructV2(input: String, wordBank: List[String], mem: Map[String, List[List[String]]] = Map.empty): List[List[String]] = {
    if (input.isEmpty) return List(List.empty)
    if (mem.contains(input)) return mem(input)
    val results = for {
      word <- wordBank if input.startsWith(word)
    } yield {
      val result = allConstructV2(input.drop(word.length), wordBank).map(v => v :+  word)
      if (result.nonEmpty) mem.put(input, result)
      result
    }
    val result = results.flatten.distinct
    mem.put(input, result)
    result
  }

  def main(args: Array[String]): Unit = {
    println(allConstructV2("purple", List("p", "ur", "purp",  "le", "purpl")))
    println(allConstructV2("abcdef", List("ab", "abc", "def", "abcd")))
    println(allConstructV2("abcdef", List("ab", "abc", "cd", "def", "abcd", "ef", "c")))
    println(allConstructV2("skateboard", List("bo", "rd", "ate", "t", "ska", "sk", "boar")))
    println(allConstructV2("enterpotentpot", List("a", "p", "ent", "enter", "ot", "o", "t")))
    println(allConstructV2("eeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeef", List("e", "eee", "eeeee", "eeeeee", "eeeeeee", "eeeeeeee"))) //broken!
  }
}
