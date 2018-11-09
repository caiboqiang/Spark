package ScalaDemo

/**
 * Created by Administrator on 2017/8/16.
 * 函数入门
 */
object Demo {
  def main(args: Array[String]) {
    //Hello("cai",24)
    //val name =  he("cai",24)
    // val s = _for(100)
    //val s = _for(10)


    val s = num(1,2,510)
    println(s)

  }
  //函数定义 （没有返回值）
  def Hello(neme:String,age:Int)={
    if(age>18){
      println("成年人")
      print(neme+":"+age)
    }else{
      println("未成年人")
      print(neme+":"+age)
    }
  }
  // 函数定义(带返回值)
  def he(neme:String,age:Int): String ={
    neme+":"
  }
  //循环条件
  def _for(num:Int): Int ={
    var n=0
    for(i<- 1 to num){
        n=n+i
    }
    n
  }
  //递归函数   (带默认值)
  def fab(n:Int=0): Int ={
    if(n<=0){
      1
    }else{
      fab(n-1)+fab(n-2)
    }
  }
  //函数 可变参数 增强累加
  def num(nums:Int*): Int={
    var n= 0
    for(i <- nums){
        n=n+i
    }
    n
  }

}
