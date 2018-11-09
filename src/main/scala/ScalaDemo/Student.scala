package ScalaDemo

/**
 * Created by Administrator on 2017/8/21.
 */
class Student[T](val  local:T){
  def getStudentlocal(hu:T):T={
     println(hu+"-"+local)
    local
  }

}

object Student{
  def main(args: Array[String]) {
      val sd = new Student[Int](11111)
      val r = get[String]("hasbdbhywed")
    println(r)
  }

  def get[Y](h:Y): Y ={
       h
  }
}
