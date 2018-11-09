package SparkRdd

import org.apache.spark.{SparkContext, SparkConf}

/**
 * Created by Administrator on 2017/10/10.
 * RDD共享变量
 */
object BroadcastRdd {
  def main(args: Array[String]) {
    //Broadcas()
    Accumulator()

  }
//共享变量方式一
  def Broadcas(){
    val con =new SparkConf().setAppName("BroadcastRdd").setMaster("local")
    val sc = new SparkContext(con)
    //用集合创建数据
    val Arr = Array(1,2,3,4)
    val tap = sc.parallelize(Arr,1)
    val factor = 3
    //创建共享变量
    val Broadcasfactor = sc.broadcast(factor)
    //获取共享变量   数组直接可以用map  截取字段用flatMap()
    val topmap = tap.map(_*Broadcasfactor.value)

    topmap.foreach(num =>println(num))
  }

  /**
   * 累加变量
   */
  def Accumulator() ={
    val con =new SparkConf().setAppName("AccumulatorRdd").setMaster("local")
    val sc = new SparkContext(con)
    //用集合创建数据
    val Arr = Array(1,2,3,4)
    val numacc = sc.accumulator(0)
    val tap = sc.parallelize(Arr,1)
    tap.foreach(num => numacc += num)
    println(numacc)
  }

}
