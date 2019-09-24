name := "CSVScalaReader"

version := "0.1"

scalaVersion := "2.10.4"


libraryDependencies += "org.apache.spark" %% "spark-core" % "1.6.1"
//for spark 1.6
libraryDependencies += "org.apache.spark" %% "spark-sql" % "1.6.1"
// for spark sqlcontext
libraryDependencies += "com.databricks" % "spark-csv_2.11" % "1.5.0"
// this is the show stealer,this is the dependency