package sqlCRUD.Read

import org.apache.spark.sql.SparkSession

object readData {
  def readFromDatabase(spark: SparkSession): Unit = {
    val DF = spark.read
      .format("jdbc")
      .option("url", "jdbc:sqlserver://Localhost:1433;databaseName=master")
      .option("dbtable", "[dbo].[Employee]")
      .option("user", "SA")
      .option("password", "MyStrongPass123")
      .load()

    DF.show()
  }
}
