package SparckCZ

import scala.io.Source

/**
 * Created by Administrator on 2017/8/21.
 * 构造器
 * 每个类都有一个主构造器  和多个辅助构造器
 *
 * 跟在类后面的构造器叫做主构造器
 */
class GouZaoQi(val id:Int,val neme:String,gebder:String) {

}
object GouZaoQi{
  def main(args: Array[String]) {
    val sd = new  GouZaoQi(20,"ddd","ddd")
    println(sd)
    val sdw = Source.fromFile("D:\\PandaMonitorWeb\\pdsk\\src\\com\\baidu\\ueditor\\ActionEnter.java").mkString
   // sd.id=22
    println(sdw)

  }
}
