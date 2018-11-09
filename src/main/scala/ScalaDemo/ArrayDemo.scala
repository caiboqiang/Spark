package ScalaDemo

import scala.collection.mutable.ArrayBuffer

/**
 * Created by Administrator on 2017/8/16.
 * 数组
 */
object ArrayDemo {
  def main(args: Array[String]) {

    /**
     * Array
     */
   /* val a = new Array[Int](10)

    val a1 = new Array[String](10)
    //转换成ArrayBuffer
    a1.toBuffer
    val b = Array("q","b")
    val b1 = Array(2,1)
    //循环数组
    for(i<- 0 to a.length-1 ){
       println(a(i))
    }*/

    /**
     * ArrayBuffer
     */
    val ab = ArrayBuffer[Int]()
    val ab1 = ArrayBuffer[String]()
    //把  ArrayBuffer 转换成   Array
    val Arr = ab1.toArray
    //添加元素
    ab+=(1)
    ab+=(2)
    ab+=(3,4,5)
    //在指定位置插入元素
    ab.insert(2,695)
    //移除指定元素
    ab.remove(1)
    //添加集合
    ab++=ArrayBuffer(74,56)
    println(ab.mkString)
    for (j <- 0 to ab.length-1){
      println(ab(j))
    }
    /*for(e <- ab){
      println(ab(e))
    }*/
  }
}
