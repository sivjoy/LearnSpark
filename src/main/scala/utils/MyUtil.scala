package utils

/**
 * Created by siv on 1/30/15.
 */
class MyUtil {

  def printLine(any:Any): Unit ={
    println("\n\t\t"+any+"\n")
  }

  def printSeparator(n:Int): Unit ={
    val runFor= 1 to n
    runFor.foreach(r=>println("\n"))
  }
}
