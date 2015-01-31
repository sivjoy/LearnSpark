package Transformations

import org.apache.spark.{SparkConf, SparkContext}

/**
 * Created by siv on 1/28/15.
 */
object Join extends App{

  var format = new java.text.SimpleDateFormat("yyyy-MM-dd")
  val joinData = "src/test/resources"
  val conf = new SparkConf().setAppName("Join")
  val sc = new SparkContext(conf)
  val reg =sc.textFile(joinData+"/reg.tsv").map(_.split("\t"))

  println("                                                                                            ")
  println("                                                                                            ")
  println("Printing the reg-------------------")
  reg.foreach(i=>println("The value is ==============>"+i) )
  println("End of printing reg -------------")
  println("                                                                                            ")
  println("                                                                                            ")
  val reg1=reg.map(r=>(r(1), Register(format.parse(r(0)), r(1), r(2), r(3).toFloat, r(4).toFloat)))
  println("                                                                                            ")
  println("                                                                                            ")
  println("Printing the reg1 -------------")
  reg1.foreach(i=>println("The value is ==============>"+i)  )
  println("End of printing reg1 -------------")
  println("                                                                                            ")
  println("                                                                                            ")

  val clk=sc.textFile(joinData+"/clk.tsv").map(_.split("\t"))
  println("                                                                                            ")
  println("                                                                                            ")
  println("Printing the clk ---------")
  clk.foreach(i=>println("The value is ==============>"+i) )
  println("End of printing clk -------------")
  println("                                                                                            ")
  println("                                                                                            ")

  val clk1= clk.map(c=>(c(1),Click(format.parse(c(0)),c(1),c(2).trim.toInt)))
  println("                                                                                            ")
  println("                                                                                            ")
  println("Printing the clk1 ---------")
  clk1.foreach(i=>println("The value is ==============>"+i) )
  println("End of printing clk1 -------------")
  println("                                                                                            ")
  println("                                                                                            ")

  //println(reg1.join(clk1).take(1))


}

case class Register(d:java.util.Date,uuid:String,cust_id:String,lat:Float,lng:Float)

case class Click(d:java.util.Date,uuid:String,landing_page:Int)



