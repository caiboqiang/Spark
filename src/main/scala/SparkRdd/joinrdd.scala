package SparkRdd

import org.apache.spark.{SparkContext, SparkConf}

/**
 * Created by Administrator on 2017/9/15.
 */
object joinrdd {
  def main(args: Array[String]) {
    val con = new SparkConf().setAppName("joinrdd").setMaster("local[2]")
    val sc = new SparkContext(con)
    val stu = Array(
      Tuple2(1,"cai"),Tuple2(2,"bo"),
      Tuple2(3,"qiang"),Tuple2(4,"cbq"))

    val clastu = Array(
      Tuple2(1,100),Tuple2(2,70),Tuple2(3,50),
      Tuple2(4,10))


    val stulist = sc.parallelize(stu)
    val clastulist = sc.parallelize(clastu)
    val stucal = stulist.join(clastulist)
    stucal.foreach(stucals=>{
      println("id"+"="+stucals._1)
      println("name"+"="+stucals._2._1)
      println("cj"+"="+stucals._2._2)
      println("==============================")
    })
    println(stucal.collect().toBuffer)
  }

}
