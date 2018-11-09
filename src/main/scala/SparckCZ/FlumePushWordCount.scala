package SparckCZ

import org.apache.spark.SparkConf
import org.apache.spark.streaming.flume.FlumeUtils
import org.apache.spark.streaming.{Seconds, StreamingContext}

/**
 * Created by Administrator on 2017/8/9.
 */
object FlumePushWordCount {

  def main(args: Array[String]) {
   // LoggerLevels
    LoggerLevels.setStreamingLogLevels()
    val conf = new SparkConf().setAppName("FlumePushWordCount").setMaster("local[2]")
    val ssc = new StreamingContext(conf,Seconds(5))
    //推送方式：flume向spark发送数据
    val flumeStrem = FlumeUtils.createStream(ssc,"192.168.1.109",8888)
    // flume中的数据通过event.getBody()才能拿到
    val words = flumeStrem.flatMap(x=>new String(x.event.getBody().array()).split(" ")).map((_,1))
    val re = words.reduceByKey(_+_)
    re.print()
    ssc.start()
    ssc.awaitTermination()

  }
}
