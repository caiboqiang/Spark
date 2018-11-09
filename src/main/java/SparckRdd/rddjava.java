package SparckRdd;

import org.apache.spark.SparkConf;
import org.apache.spark.api.java.JavaSparkContext;

/**
 * Created by Administrator on 2017/9/14.
 */
public class rddjava {
    public static void main(String[] args) {
       SparkConf con = new SparkConf().setAppName("RDD").setMaster("local[2]");
        JavaSparkContext sc = new JavaSparkContext(con);

        System.out.println("");
    }

}
