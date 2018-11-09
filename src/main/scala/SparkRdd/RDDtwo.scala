package SparkRdd

import org.apache.spark.{SparkContext, SparkConf}

/**
 * Created by Administrator on 2017/9/14.
 * c创建并行化数据
 */
object RDDtwo {
  def main(args: Array[String]) {
    val con =new SparkConf().setAppName("RDD").setMaster("local")
    val sc = new SparkContext(con)
    //用集合创建数据
    val Arr = Array(1,2,3,4)
    //前面表示参数  后面表示分区可以手动输入
    val SumRdd = sc.parallelize(Arr,1)

    val s = SumRdd.map(_*2)
    val mo = SumRdd.filter(_%2 ==0)
    val m = SumRdd.reduce(_+_)
    println(mo.collect().toBuffer)
    println(s.collect().toBuffer)

  }

}
