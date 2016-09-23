package pirates

/** Sparar olika ord och räknar antalet förekomster. */
class WordCounter {

  var wordCounter = scala.collection.mutable.Map[String, Int]()

  /** Lägger till ordet word och räknar upp antalet förekomster. */
  def addWord(word: String): Unit = {
    if (wordCounter.contains(word)) {
      wordCounter(word) += 1
    } else {
      wordCounter(word) = 1
    }
  }

  /** Ger det vanligaste ordet och antalet förekomster. */
  def mostCommonWord: (String, Int) = {
    wordCounter.maxBy(_._2)
  }

  /** Skriver ut det vanligaste ordet och dess antal*/
  override def toString(): String = {
    val mostCommon = mostCommonWord
    mostCommon._1 + " : " + mostCommon._2
  }
}
