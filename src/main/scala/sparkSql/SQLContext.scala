/*
package sparkSql

/**
 * Created by siv on 1/31/15.
 */

import org.apache.spark.{SparkConf,SparkContext}
import org.apache.spark.SparkContext._
import org.apache.spark.sql.SQLContext

case class Record(key:Int,value:String)

object SQLContext extends App{

  val sparkConf = new SparkConf().setAppName("SQLContext")
  val sc = new SparkContext(sparkConf)
  val sqlContext = new SQLContext(sc)

  import sqlContext._


}
*/
