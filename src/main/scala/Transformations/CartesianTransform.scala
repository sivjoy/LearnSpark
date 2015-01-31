package Transformations

import org.apache.spark.SparkContext._
import org.apache.spark.{SparkContext,SparkConf}

/**
 * Created by siv on 1/30/15.
 */
object CartesianTransform extends App{

  val file1 = System.getProperty("user.dir")+"/src/test/resources/README.md"

  val conf = new SparkConf().setAppName("CartesianTransform")
  val sc= new SparkContext(conf)

  printSeparator()

  val mapped1RDD = sc.textFile(file1).flatMap(line=>line.split(" ")).filter(_.contains("ab")).map(word=>(word,word.length))
  val mapped2RDD = sc.textFile(file1).flatMap(line=>line.split(" ")).filter(_.contains("ac")).map(word=>(word,word.length))
  val coGroupedRDD = mapped1RDD.cartesian(mapped2RDD)
  printSeparator()
  mapped1RDD.foreach(i=>println("\n               The RDD with ab's match is ::     ---->"+i+"\n"))
  printSeparator()
  mapped2RDD.foreach(i=>println("\n               The RDD with ac's match is ::     ---->"+i+"\n"))
  coGroupedRDD.foreach(i=>println("\n               The cartesian product value is ::     ---->"+i+"\n"))
  printSeparator()


  def printSeparator(): Unit ={
    val runFor= 1 to 5
    runFor.foreach(r=>println("                                       "))
  }

}
