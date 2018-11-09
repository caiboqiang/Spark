package ScalaDemo

/**
 * Created by Administrator on 2017/8/17.
 */
class Stu {
  var name="q"
  var age=0
  //“_”表示没有初始化     private:只能在半生对象里访问
  private var id:Int=_
  private var st:String=_
  private [this] var xb:String=_
  //包可见 包访问权限   可访问
  /*private [scalademo] var sc:String=_*/
  def say(){
    println(xb)

  }

}
//半生对象 类名要一致
object Stu{
  def main(args: Array[String]) {
    val s = new Stu
    s.say()
    print(s.st)
   /* println(s.sc)*/
  }

}

object de{
  def main(args: Array[String]) {
    val s = new Stu
    s.age=50
    println(s.age)
  }
}
