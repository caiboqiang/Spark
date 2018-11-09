package ScalaDemo

class SpecialPerson(val name:String)
class Studentsd(val name:String)
class Older(val name:String)
/**
 * Created by Administrator on 2017/8/31.
 * 隐式转换
 */
object implicits {
  /*def main(args: Array[String]) {
    val sd = buySpecialPerson("dsads")

  }
  var  tark = 0
  def buySpecialPerson(obj:SpecialPerson){
       tark +=1
    print("T"+ tark)
  }


  //隐式转换
  implicit def objimp(obj:Object):SpecialPerson={
    if(obj.getClass==classOf[Studentsd]){
       val stu = obj.asInstanceOf[Studentsd]
       new SpecialPerson(stu.name)
    }else if(obj.getClass==classOf[Older]){
      val older = obj.asInstanceOf[Older]
      new SpecialPerson(older.name)
    } else {
      new SpecialPerson("cai")
    }
  }*/

}

