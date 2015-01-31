package Variables

import org.apache.spark.{SparkContext, SparkConf}
import utils.MyUtil

/**
 * Created by siv on 1/30/15.
 */


//TODO unable to make this program work.
object Accumulator extends App{

  val util = new MyUtil()
  util.printSeparator(50)
  val conf = new SparkConf().setAppName("Accumulator")
  val accum = sc.accumulator(0)(SparkContext.IntAccumulatorParam)
  val sc = new SparkContext(conf)
  val rdd = sc.parallelize(List(1,2,3))

  rdd.foreach(x=>accum+=x)

  util.printLine("The accum value is :"+accum.value)

}
