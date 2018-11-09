package ScalaDemo

/**
 * Created by Administrator on 2017/8/17.
 * 函数式编程
 */
object HanShu {

  def main(args: Array[String]) {
     //sayHello(say("y"),"name")
    //sayHe(say(1,20),"name",50)
   // say(1,2)
    //f(say,50,20)
   // val num = fubce(func)
   // print(num
      val n = servf(serves)
    print(n)
  }


  def servf(cbq:Int=>(Int,String))={
    cbq(6)
  }
  //不长见特殊函数
  val serves : Int=> (Int,String)={
    //s表示引用变量燃后返回
    s => (s,"22")
  }
  val servee : Int=> String= {
    //s表示引用变量
    s => s.toString
  }
  val say = (x: Int, y: Int) => {
      println(x - y)
      x - y
  }
      //匿名函数的定义
      //(n: Int) => println(n)
        //函数的定义
    /*    val func = (n: Int) => {
          n * 10
        }
        def fubce(f: Int => Int) = {
          f(3)
        }
        def f(d: (Int, Int) => Int, x: Int, y: Int) = {
          val dd = d(x, y)
          //println(dd)
        }*/

        /*val say = (name:String)=>println(name)
  def sayHello(fun:(String)=Unit,n:String)={
    fun(n)
  }*/
   /*     def sayHe(F: (Int, Int), names: String, ages: Int) = {

          //var s = new Stu
          //s.name_=names
          //s.age_=ages
          //  s
        }
  }*/
}
