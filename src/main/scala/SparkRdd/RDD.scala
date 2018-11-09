package SparkRdd

import org.apache.spark.{SparkContext, SparkConf}

/**
 * Created by Administrator on 2017/9/7.
 */
object RDD {
  def main(args: Array[String]) {
    val con = new SparkConf().setAppName("demo").setMaster("local[2]")
    val sc = new SparkContext(con)
    //获取数据
    val line = sc.textFile("D:\\Contos\\ZM1\\hello.txt",1)
    //对数据进行筛选
    val wordtup = line.flatMap(_.split(" ")).map((_,1))
    val so = wordtup.reduceByKey(_+_).sortByKey(false)
    print(so.collect().toBuffer)
    //统计字数  每行长度 计算总长度
    val length = line.map(_.length).reduce(_+_)
    println(length)


    //print(wordtup.collect().toBuffer)
    //聚合
    val woer = wordtup.reduceByKey(_+_)
    //保存计算过的数据
    //woer.saveAsTextFile("")
    print(woer.collect().toBuffer)
  }

}
