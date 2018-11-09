package ScalaDemo

/**
 * Created by Administrator on 2017/8/22.
 * 多线程
 */
/*object ActorHello extends Actor{

}*/


/**
 * 样例类 有个好的特点不需要new
 */
case class Hello(id:Int,name:String)
object map {
  def main(args: Array[String]) {
    val m= Map("a"->1,"b"->2)
    val s = m.get("a").get
    judgeGrade("d","A",s)
  }


  val m= Map("a"->1,"b"->2)
  val s = m.get("b").get
  println(s)
  s match {
    case 1 =>println(m.getOrElse("a",0))
    case _=>println(".......")
  }


  def judgeGrade(name : String, grade: String,s:Int) {
    grade match {
      case "A" => println(name + ", you are excellent")
      case "B" => println(name + ", you are good")
      case "C" => println(name + ", you are just so so")
      case _ if name == "leo" => println(name + ", you are a good boy, come on")
      case _ => println("you need to work harder")
    }

    s match {
      case 1 =>println(m.get("a").get)
      case _=>println(".......")
    }

  }
}
