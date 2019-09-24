import org.apache.spark.sql.SQLContext
import org.apache.spark.{SparkConf, SparkContext}

object ReadCSVFile {

  case class Employee(empno:String, ename:String, designation:String, manager:String, hire_date:String, sal:String , deptno:String)

  def main(args : Array[String]): Unit = {
    val sparkConf = new SparkConf().setAppName("CSV Scala Reader").
      setMaster("local[*]") //set spark configuration

    val sc = new SparkContext(sparkConf)
    val sqlContext = new SQLContext(sc)
    import sqlContext.implicits._
    val textRDD = sc.textFile("src\\main\\resources\\emp_data.csv")
    //println(textRDD.foreach(println)
    val empRdd = textRDD.map {
      line =>
        val col = line.split(",")
        Employee(col(0), col(1), col(2), col(3), col(4), col(5), col(6))
    }
    val empDF = empRdd.toDF()
    empDF.show()
  }
}
