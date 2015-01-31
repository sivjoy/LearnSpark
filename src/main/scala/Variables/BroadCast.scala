package Variables

/**
 * Created by siv on 1/30/15.
 */

import utils.MyUtil
import org.apache.spark.{SparkConf,SparkContext}
import org.apache.spark.SparkContext._

object BroadCast extends App{
  val util = new MyUtil()
  util.printSeparator(50)
  val conf = new SparkConf().setAppName("BroadCast Variables")
  val sc = new SparkContext(conf)
  val broadCastVariable = sc.broadcast(Array(1,2,3))
  util.printSeparator(5)
  broadCastVariable.value.foreach(i=>util.printLine(i))
  util.printLine("toString() :"+broadCastVariable.toString())
}
