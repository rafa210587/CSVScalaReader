import org.apache.spark.sql.SparkSession

object CsvScalaSpark2Reader {
  def main(args: Array[String]) : Unit = {
    val spark =  SparkSession
      .builder()
      .master("local")
      .appName("Csv Scala Reader")
      .getOrCreate();

    val file = spark.read.format("csv")
      .option("header", "true")
      .option("mode", "DROPMALFORMED")
      .load("src\\main\\resources\\file.csv").show()

    val sqlFile = spark.sql("SELECT * FROM csv. `src\\main\\resources\\file.csv`").show()
  }
}
