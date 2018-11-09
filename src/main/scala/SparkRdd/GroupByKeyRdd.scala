package SparkRdd

import org.apache.spark.{SparkContext, SparkConf}

/**
 * Created by Administrator on 2017/9/15.
 */
object GroupByKeyRdd {
  def main(args: Array[String]) {
    val con = new SparkConf().setAppName("demo").setMaster("local[2]")
    val sc = new SparkContext(con)
    val line = sc.textFile("D:\\Contos\\ZM1\\hello.txt",1)
    val tup = line.flatMap(_.split(" ")).map((_,1))
    val g = tup.groupByKey().collect().toBuffer
    print(tup.groupByKey().foreach(_._1))
    //print(g)
  }

}
