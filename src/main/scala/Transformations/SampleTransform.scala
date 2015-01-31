package Transformations

import org.apache.spark.{SparkContext, SparkConf}
import org.apache.spark.SparkContext._
/**
 * Created by siv on 1/30/15.
 */
object SampleTransform extends App{

  val file1 = System.getProperty("user.dir")+"/src/test/resources/README.md"

  val conf = new SparkConf().setAppName("SampleTransform")
  val sc= new SparkContext(conf)

  printSeparator()

  val mapped1RDD = sc.textFile(file1).flatMap(line=>line.split(" ")).filter(_.contains("Apache")).map(word=>(word,word.length))
  val mapped2RDD = sc.textFile(file1).flatMap(line=>line.split(" ")).filter(_.contains("Spark")).map(word=>(word,word.length))
  val coGroupedRDD = mapped1RDD.cogroup(mapped2RDD)
  printSeparator()
  mapped1RDD.foreach(i=>println("\n               The RDD with ab's match is ::     ---->"+i+"\n"))
  printSeparator()
  mapped2RDD.foreach(i=>println("\n               The RDD with ac's match is ::     ---->"+i+"\n"))
  coGroupedRDD.foreach(i=>println("\n               The co group value is ::     ---->"+i+"\n"))
  printSeparator()


  def printSeparator(): Unit ={
    val runFor= 1 to 5
    runFor.foreach(r=>println("                                       "))
  }

}
