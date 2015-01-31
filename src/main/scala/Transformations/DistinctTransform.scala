package Transformations

import org.apache.spark.{SparkContext, SparkConf}

/**
 * Created by siv on 1/30/15.
 */
object DistinctTransform extends App{

  printSeparator(50)
  val file1 = System.getProperty("user.dir")+"/src/test/resources/README.md"

  val conf = new SparkConf().setAppName("CartesianTransform")
  val sc= new SparkContext(conf)

  printSeparator(3)

  val mapped1RDD = sc.textFile(file1).flatMap(line=>line.split(" ")).filter(_.contains("ab")).map(word=>(word,word.length))
  mapped1RDD.foreach(i=>println("\n               The RDD with a's match is (before)::     ---->"+i+"\n"))
  val distinctRDD = mapped1RDD.distinct()
  printSeparator(3)
  mapped1RDD.foreach(i=>println("\n               The RDD with a's match is ::     ---->"+i+"\n"))
  printSeparator(3)
  distinctRDD.foreach(i=>println("\n               The distinct value is ::     ---->"+i+"\n"))
  printSeparator(3)
  println("The final RDD count value is  ----------->:"+distinctRDD.count())
  println("The final RDD cahce is  ----------->:"+distinctRDD.cache())
 // println("The final RDD in debug print is  ----------->:"+distinctRDD.checkpoint())
  println("The final collected RDD  is  ----------->:"+distinctRDD.collect().foreach(i=>println("       The collect output is ---->"+i)))
  println("The final RDD context is  ----------->:"+distinctRDD.context)
  println("The final first() in RDD  is  ----------->:"+distinctRDD.first())
  //println("The final RDD checkpointFile  is  ----------->:"+distinctRDD.getCheckpointFile)
  println("The final RDD  storage level is  ----------->:"+distinctRDD.getStorageLevel)
  println("The final RDD in glomed is  ----------->:"+distinctRDD.glom().foreach(i=>println("The glommed elements are :"+i)))
  println("The final RDD  glomed count is  ----------->:"+distinctRDD.glom().count())
  println("The final RDD in toString is  ----------->:"+distinctRDD.toString)
  println("The final RDD in debug print is  ----------->:"+distinctRDD.toDebugString)

  def printSeparator(n:Int): Unit ={
    val runFor= 1 to n
    runFor.foreach(r=>println("                                       "))
  }
}
