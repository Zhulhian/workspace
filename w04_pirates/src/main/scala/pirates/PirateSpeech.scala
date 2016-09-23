package pirates

object PirateSpeech {
  def main(argh: Array[String]): Unit = {
    val filename = if (!argh.isEmpty) argh(0) else "skattkammaron.txt"
    // add your tests here!!!

    readBook("skattkammaron.txt")

  }

  def readBook(bookFile: String): Map[String, WordCounter] = {
  	val words = FileUtils.readWords(bookFile) // ("herr", "trelawney", "doktor", "livesey", "och", ...)
  	val wordSet = words.toSet //all words only once

    
  	val counterMap = wordSet.map(word => word -> new WordCounter).toMap

    counterMap.foreach(println)
    
  	??? // go through the book looking at two words at a time 
    
    counterMap // return the map
  }

  /* Optional */
  def readBook(bookFile: String, saveToFile: String):  Unit = ???

  /* Optional */
  def testSpeech(file: String): Unit = ???
}