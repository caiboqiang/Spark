package sprk.streaming

import org.apache.spark.SparkConf
import org.apache.spark.streaming.{Seconds, StreamingContext}

/**
 * Created by Administrator on 2017/8/30.
 * SparckStreaming案例
 */
object SparckStreaming {
  def main(args: Array[String]) {
    val con = new SparkConf().setAppName("SparckStreamingDemo").setMaster("local[2]")
    //  Seconds(1) 时间
    //val streaming = new StreamingContext(sc,Seconds(8))
    val streaming = new StreamingContext(con,Seconds(5))
     //读取hdfs数据
    val lines = streaming.textFileStream("hdfs://hadoop1:9000/wc/")
    print(lines)
    print("000000000000000000000000000000000000000000000000000")
    //读数据
   // val lines = streaming.socketTextStream("",9999)
   // val wor = lines.flatMap(_.split(" "))
    val tup = lines.flatMap(_.split(" ")).map((_,1)).reduceByKey(_+_)
    tup.saveAsTextFiles("hdfs://hadoop1:9000/outwc/")
    tup.print()

    streaming.start()
    streaming.awaitTermination()
  }

}
