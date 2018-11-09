package sprk.streaming

import kafka.serializer.StringDecoder
import org.apache.spark.SparkConf
import org.apache.spark.streaming.kafka.KafkaUtils
import org.apache.spark.streaming.{Seconds, StreamingContext}

/**
 * Created by Administrator on 2017/8/31.
 * 累计统计
 */
object SparkStreaingUpdatastateByKey {
  def main(args: Array[String]) {
    val conf = new SparkConf().setAppName("KafkaWordCount").setMaster("local[2]")
    val ssc = new StreamingContext(conf, Seconds(1))
    ssc.checkpoint(".") //检查点必须设置
    val kafkaParams = Map[String,String]("metadata.broker.list"->"hadoop4:9092,hadoop6:9092,hadoop5:9092")
    val topicsSet = Set("testwc")
    val lines = KafkaUtils.createDirectStream[String,String,StringDecoder,StringDecoder](ssc,kafkaParams,topicsSet).map(_._2)
    val words = lines.flatMap(_.split(" "))
    val wordconut= words.map((_,1))
    val up = wordconut.updateStateByKey[Int](updatefunctions)
    up.print()
    ssc.start()
    ssc.awaitTermination()
  }
  val updatefunctions = (vla:Seq[Int],st:Option[Int])=>{
    val cur = vla.sum
    val pre = st.getOrElse(0)
    Some(cur + pre)
  }

}
