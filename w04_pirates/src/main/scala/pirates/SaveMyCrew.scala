package pirates

object SaveMyCrew {
  def main(argh: Array[String]): Unit = {
    // change this code to your tests!

    val filename = if (!argh.isEmpty) argh(0) else "crew.txt"
    //saveCrew(filename)
    readCrew(filename)

  }

  def saveCrew(fileName: String): Unit = {
    val crew = for(_ <- 1 to 5) yield {
      val first = scala.io.StdIn.readLine("First name: ")
      val last = scala.io.StdIn.readLine("Last name: ")
      val rank = scala.io.StdIn.readLine("Rank: ")
      println(" - - - - - - - - - - - - - - - ")

      CrewMember(first, last, rank)
    }

    val crewList = crew.mkString("\n")
    FileUtils.save(crewList, fileName)

  }

  def readCrew(fileName: String): Unit = {
    val crewData = FileUtils.readLines(fileName)
    val crew = for (crewMemberData <- crewData) yield {
      val crewMember = crewMemberData.replaceAllLiterally(",", "").split(' ')

      if (crewMember.length < 3) {
        println("Crew file not formatted correctly! You need a first name, a last name and\n" +
          "a rank; separated by spaces. Commas are optional (just for looks)")
      }
      else {

        val first = crewMember(0)
        val last = crewMember(1)
        val rank = crewMember.drop(2).mkString(" ")

        CrewMember(first, last, rank)
      }
    }

  }
}


// Add your case class here!
case class CrewMember(first: String, last: String, rank: String) {
  override def toString: String = first + " " + last + ", " + rank
}
