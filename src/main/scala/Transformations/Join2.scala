package Transformations

/**
 * Created by siv on 1/29/15.
 */

import org.apache.spark.SparkContext._
import org.apache.spark.{SparkConf, SparkContext}
object Join2 extends App{



  val file1 = System.getProperty("user.dir")+"/src/test/resources/README.md"
  val file2 = System.getProperty("user.dir")+"/src/test/resources/README1.md"

  val conf = new SparkConf().setAppName("JoinHelpFiles")
  val sc= new SparkContext(conf)

  printSeparator()

  val mapped1RDD = sc.textFile(file1).flatMap(line=>line.split(" ")).filter(_=="Spark").map(word=>(word,1))
  val filtered1RDD = mapped1RDD.reduceByKey(_+_)
  printSeparator()
  mapped1RDD.foreach(j=>println("\n               The RDD1 match is ::     ---->"+j+"\n"))
  printSeparator()
  filtered1RDD.foreach(i=>println("\n               The RDD1 value is ::     ---->"+i+"\n"))
  printSeparator()

  val mapped2RDD = sc.textFile(file2).flatMap(line=>line.split(" ")).filter(_.contains("ar")).map(word=>(word,1))
  val filtered2RDD = mapped2RDD.reduceByKey(_+_)
  printSeparator()
  mapped2RDD.foreach(j=>println("\n               The RDD2 match is ::     ---->"+j+"\n"))
  printSeparator()
  filtered2RDD.foreach(i=>println("\n               The RDD2 value is ::     ---->"+i+"\n"))
  printSeparator()

  println(filtered1RDD.join(filtered2RDD).foreach(i=>println("\n               The value is ::     ---->"+i+"\n")))
  filtered1RDD.join(filtered2RDD).collect().map(arrayLine=>println(arrayLine))
  printSeparator()

  def printSeparator(): Unit ={
    val runFor= 1 to 5
    runFor.foreach(r=>println("                                       "))
  }

}
