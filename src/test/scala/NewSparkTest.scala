/**
 * Created by siv on 1/27/15.
 */

import org.apache.spark.{SparkContext,SparkConf}
import org.scalatest.FlatSpec

class NewSparkTest extends FlatSpec{

  markup (" -------------Apache Spark-----------------")

  val projLoc=System.getProperty("user.dir")
  val sparkEnv="/home/siv/Spark/SetUpFiles/spark-1.2.0-bin-hadoop2.4"
  val fileLoc=projLoc+"/src/test/resources/README.md"
  val jarLoc=projLoc+"/target/scala-2.10/learnspark_2.10-1.0.jar"

    def  start(master:String, appName:String,fileLoc:String) = {
      //val conf = new SparkConf().setMaster(master).setAppName(appName).setJars(jars).setExecutorEnv("SPARK_HOME",env)
      //val sc = new SparkContext(conf)
      //val sc = new SparkContext(master,appName,sparkEnv)
      val conf  = new SparkConf().setAppName("MySparkTest").setMaster("local[4]")
      val sc = new SparkContext(conf)
      sc.addJar(jarLoc)
      val logFile = sc.textFile(fileLoc,2)
      val numAs = logFile filter(x=>x.contains("a")) count()
      val numBs = logFile filter(x=>x.contains("b")) count()
      (numAs,numBs)
    }

  "Spark count" should "print number of a's and b's" in {
    info("The jar location is :"+jarLoc)
    info("The read file location is :"+ fileLoc)
    info("The env variable for Spark is located at : "+sparkEnv)

     val(a:Long,b:Long) = start("local[4]","NewSparkTest",fileLoc)

     info("A is :"+a)
     info("B is :"+b)
     info("The end.")
  }
}
