import org.apache.spark.sql.SQLContext
import org.apache.spark.{SparkConf, SparkContext}

object ReadCSVFile {

  def main(args : Array[String]): Unit = {
    val sparkConf = new SparkConf().setAppName("CSV Scala Reader").
      setMaster("local[2]") //set spark configuration

    val sc = new SparkContext(sparkConf)
    val sqlContext = new SQLContext(sc)

    import sqlContext.implicits._

    val filePath = "src\\main\\resources\\daily_conciliations.csv";
    val file = sc.textFile(filePath)

    val employes = sqlContext.read.format("com.databricks.spark.csv")
      .option("header", "true")
      .option("inferSchema", "true")
      .load(filePath)

    val selectedDesignation = employes.

    employes.show()
  }
}
