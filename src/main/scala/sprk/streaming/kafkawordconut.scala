package sprk.streaming

import org.apache.commons.codec.StringDecoder
import org.apache.spark.SparkConf
import org.apache.spark.streaming.kafka.KafkaUtils
import org.apache.spark.streaming.{Seconds, StreamingContext}

/**
  * Created by Administrator on 2017/8/31.
  * kafka接收数据
    */
  object kafkawordconut {
    def main(args: Array[String]) {


    }



  def he(){
    val conf = new SparkConf().setAppName("KafkaWordCount").setMaster("local[2]")
    val ssc = new StreamingContext(conf, Seconds(5))
    val topicMap = Map("test"->1)   //数据源
    val lines = KafkaUtils.createStream(ssc,"hadoop4:2181,hadoop5:2181,hadoop6:2181","testWordCount",topicMap).map(_._2)
    val words = lines.flatMap(_.split(" "))
    val wordconut= words.map((_,1)).reduceByKey(_+_)
    wordconut.print()
    ssc.start()
    ssc.awaitTermination()
  }
     //第二种连接方式
  /*def main(args: Array[String]) {
    val conf = new SparkConf().setAppName("KafkaWordCount").setMaster("local[2]")
    val ssc = new StreamingContext(conf, Seconds(5))
    val kafkaParams = Map[String,String]("metadata.broker.list"->"hadoop4:9092,hadoop6:9092,hadoop5:9092")
    val topicsSet = Set("testwc")
    val lines = KafkaUtils.createDirectStream[String,String,StringDecoder,StringDecoder](ssc,kafkaParams,topicsSet).map(_._2)
    val words = lines.flatMap(_.split(" "))
    val wordconut= words.map((_,1)).reduceByKey(_+_)
    wordconut.print()
    ssc.start()
    ssc.awaitTermination()    779.52+517.10+189.22=1485.84+3500            4440+12378.08
    C:\Users\Administrator\AppData\Local\kingsoft\WPS Cloud Files\userdata\qing\filecache\caiboqiang
  }*/
}
